package gaoxiao6331.ast2code

import gaoxiao6331.commom.error.GrammarException
import gaoxiao6331.commom.exception.InternalException
import gaoxiao6331.commom.token.*

class Scanner {

    // this value should not be used due to reset()
    private var pos = Position(1,1,-1) // index is the last char consumed
    private var source = ""
    private var startPos = pos.copy()
    private var tokenList = mutableListOf<TokenData>()

    private fun reset(source: String) {
        this.pos = Position(1, 1,-1)
        this.startPos = this.pos.copy()
        this.source = source
        this.tokenList = mutableListOf()
    }

    private fun saveStartPos() {
        this.startPos = this.pos.copy()
    }

    private fun isEnd(i: Int = this.pos.index): Boolean {
        return i >= this.source.length
    }

    private fun advance(n: Int = 1) {
        this.pos.index += n
    }

    private fun previous(n: Int = 1): Char {
        val prevIdx = this.pos.index - n
        if (prevIdx >= 0) {
            return source[prevIdx]
        }
        throw InternalException("current index is ${this.pos.index}, cannot get previous ${n}th char")
    }

    private fun next(n: Int = 1): Char {
        val nextIdx = this.pos.index + n
        if (!isEnd(nextIdx)) {
            return source[nextIdx]
        }
        throw InternalException("current index is ${this.pos.index}, total length is ${this.source.length}, cannot get next ${n}th char")
    }

    private fun current(): Char {
        if (!isEnd()) {
            return previous(0)
        }
        throw InternalException("source code has been scanned")
    }

    private fun nextAndAdvance(n: Int = 1): Char {
        val c = next(n)
        advance(n)
        return c
    }

    private fun nextLine() {
        this.pos.line ++
        this.pos.column = 1
        advance()
    }

    private fun addToken(type: Token, value: String) {
        val location = Location(
            this.startPos.copy(),
            this.pos.copy()
        )
        val token = TokenData(type, value, location)
        this.tokenList.add(token)
    }

    private fun scanString() {
        val stringStart = nextAndAdvance()
        var hasStringEnd = false
        var value = ""
        while (!isEnd()) {
            when(val c = nextAndAdvance()) {
                Slash -> {
                    val n = nextAndAdvance()
                    value += n
                }
                NextLine -> {
                    value += c
                    nextLine()
                }
                stringStart -> {
                    hasStringEnd = true
                    break
                }
                else -> {
                    value += c
                }
            }
        }
        if (!hasStringEnd) {
            throw GrammarException(source, "string without close $stringStart", pos)
        }
        addToken(Literal.StringLiteral, value)
    }

    private fun extractAndAddSingleLineComment() {
        saveStartPos() // don't need # or //
        var comment = ""
        var c = next()
        while (!isEnd() && c != NextLine) {
            comment += c
            advance()
            c = next()
        }
        addToken(Literal.CommentLine, comment)
    }

    private fun extractAndAddMultiLinesComment() {
        saveStartPos() // don't need /*
        var comment = ""
        var hasCloseSymbols = false
        while (!isEnd()) {
            when(val c = nextAndAdvance()) {
                NextLine -> {
                    nextLine()
                    comment += c
                }
                Star -> {
                    if (next(2) == Slash) {
                        advance()
                        hasCloseSymbols = true
                        break
                    }
                }
                else -> {
                    comment += c
                }
            }
        }
        if (!hasCloseSymbols) {
            throw GrammarException(source, "comment without close symbol", pos)
        }
        addToken(Literal.CommentBlock, comment)
    }

    private fun scanComment() {
        when (val start = nextAndAdvance()) {
            Hash -> {
                extractAndAddSingleLineComment()
            }
            Slash -> {
                when (val secondChar = nextAndAdvance()) {
                    Slash -> extractAndAddSingleLineComment()
                    Star -> extractAndAddMultiLinesComment()
                    else -> throw GrammarException(source, "unknown grammar", pos)
                }
            }
            else -> throw InternalException("not comment")
        }
    }

    private fun extractHexDigit(): String {
        var value = ""
        var c = next()
        while (!isEnd() && c in HexDigit) {
            value += c
            advance()
            c = next()
        }
        if (value.length == 0) throw GrammarException(source, "not a valid hex number", pos)
        return value
    }

    private fun extractNumberNotStartWithSign(): String {
        /*
            0x | 0X -> hex
            123 -> int
            12.3 -> float
            1e3 | 1.0e-3.111 -> power of 10
         */
        var value = ""
        var hasDot = false
        var hasPower = false
        var powerHasDot = false
        var powerHasSign = false
        while (!isEnd()) {
            when(val c = nextAndAdvance()) {
                in X -> {
                    if (value == "0") {
                        return HexStart + extractHexDigit()
                    }
                    throw GrammarException(source, "$c should be used as hex number", pos)
                }
                Dot -> {
                    if ((hasDot && !hasPower) || (hasPower && powerHasDot) || (value.last() !in Digit)) {
                        throw GrammarException(source, "not a valid number", pos)
                    }
                    if (hasPower) {
                        powerHasDot = true
                    } else {
                        hasDot = true
                    }
                    value += c
                }
                in E -> {
                    if (hasPower || (value.last() !in Digit)) {
                        throw GrammarException(source, "not a valid number", pos)
                    }
                    hasPower = true
                    value += c
                }
                in PosOrNegSign -> {
                    if (!hasPower || powerHasSign || (value.last() !in E)) {
                        throw  throw GrammarException(source, "not a valid number", pos)
                    }
                    powerHasSign = true
                    value += c
                }
                in Digit -> {
                    value += c
                }
                else -> {
                    throw  throw GrammarException(source, "not a valid number", pos)
                }
            }
        }
        if (value.last() !in Digit) throw GrammarException(source, "not a valid number", pos)
        return value
    }

    private fun addNumberToken(value: String) {
        if (value.startsWith(HexStart)) {
            addToken(Literal.HexLiteral, value)
        } else if (E.any { value.contains(it) }) {
            addToken(Literal.ExponentialLiteral, value)
        } else if (value.contains(Dot)) {
            addToken(Literal.FloatLiteral, value)
        } else {
            addToken(Literal.IntLiteral, value)
        }
    }

    private fun scanNumber() {
        val value = extractNumberNotStartWithSign()
        addNumberToken(value)
    }

    private fun scanPosOrNegNumber() {
        val sign = nextAndAdvance()

        // ignore \s \n and other whitespace between sign and digit

        when(val c = next()) {
            in Digit -> {
                val value = sign + extractNumberNotStartWithSign()
                addNumberToken(value)
            }
            else -> {
                throw GrammarException(source, "not a valid number", pos)
            }
        }
    }

    // not for first char of identifier
    private fun isValidIdentifierChar(c: Char): Boolean {
        // TODO check non english letter and $
        // dot is for namespace xxx.yyy.zzz
        return c in Letter + Underscore + Digit + Dot
    }

    private fun scanIdentifierOrKeywordOrLiteral() {
        var value = ""
        while (!isEnd()) {
            val c = nextAndAdvance()
            if (c in WhiteSpace) break
            if (!isValidIdentifierChar(c)) throw GrammarException(source, "should be letter or underscore", pos)
            value += c

        }
        if (value in BoolLiteral) {
            addToken(Literal.BooleanLiteral, value)
        } else if (value in KeywordTokenList) {
            val type = KeyWordTokenMap[value]!!
            addToken(type, value)
        } else {
            addToken(Other.Identifier, value)
        }
    }

   fun scan(source: String) {
       reset(source)
       while (!isEnd()) {
           saveStartPos()
           when(val c = next()) {
               in WhiteSpace -> advance()
               NextLine -> nextLine()
               And -> TODO("& indicating pointer is supported by thrift, but there is no description in the document, deal wit it later")
               in PosOrNegSign -> scanPosOrNegNumber()
               in SingleCharMarkTokenList -> { // contain minus, so must behind minus
                   addToken(SingleCharMarkTokenMap[c]!!, "$c")
                   advance()
               }
               in StringStart -> scanString()
               in Comment -> scanComment()
               in Digit -> scanNumber()
               Underscore -> scanIdentifierOrKeywordOrLiteral()
               in Letter -> scanIdentifierOrKeywordOrLiteral()
               else -> throw GrammarException(source, "unknown grammar", pos)
           }
       }
   }

}