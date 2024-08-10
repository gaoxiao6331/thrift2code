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
        addToken(Literal.CommentLine, comment)
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

    private fun scanNumber() {
        /*
            0x
            0X
            123
            12.3
            1.0e3
            1.0e3.111
         */

    }

    private fun scanMinus() {
        advance()
        when(val c = next()) {
            in Digit -> {
                scanNumber()
            }
            else -> {
                TODO("check whether there is other situations or not")
            }
        }
    }

    // not for first char of identifier
    private fun isValidIdentifierChar(c: Char): Boolean {
        // TODO check non english letter and $
        return c in Letter + Underscore + Digit
    }

    private fun scanIdentifierOrKeyword() {
        var value = ""
        while (!isEnd()) {
            val c = nextAndAdvance()
            if (c in WhiteSpace) break
            if (!isValidIdentifierChar(c)) throw GrammarException(source, "should be letter or underscore", pos)
            value += c

        }
        if (value in KeywordTokenList) {
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
               Minus -> scanMinus()
               in SingleCharMarkTokenList -> { // contain minus, so must behind minus
                   addToken(SingleCharMarkTokenMap[c]!!, "$c")
                   advance()
               }
               in StringStart -> scanString()
               in Comment -> scanComment()
               in Digit -> scanNumber()
               Underscore -> scanIdentifierOrKeyword()
               in Letter -> scanIdentifierOrKeyword()
               else -> throw GrammarException(source, "unknown grammar", pos)
           }
       }
   }

}