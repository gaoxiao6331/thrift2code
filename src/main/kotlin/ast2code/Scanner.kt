package gaoxiao6331.ast2code

import gaoxiao6331.commom.error.GrammarException
import gaoxiao6331.commom.exception.InternalException
import gaoxiao6331.commom.token.Mark
import gaoxiao6331.commom.token.Token

class Scanner {

    // this value should not be used due to reset()
    private var pos = Position(1,1,-1)
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

    private fun addToken(type: Token) {
        val start = this.startPos.index
        val end = this.pos.index
        val value = this.source.substring(start, end)
        val location = Location(
            this.startPos.copy(),
            this.pos.copy()
        )
        val token = TokenData(type, value, location)
        this.tokenList.add(token)
    }

    private fun scanString() {

    }

    private fun extractAndAddSingleLineComment() {

    }

    private fun scanComment() {
        when (val start = nextAndAdvance()) {
            '#' -> {
                extractAndAddSingleLineComment()
            }
            '/' -> {
                when (val secondChar = nextAndAdvance()) {
                    '/' -> extractAndAddSingleLineComment()
                    '*' -> TODO()
                    else -> throw GrammarException(source, "unknown grammar", pos)
                }
            }
            else -> throw InternalException("not comment")
        }
    }

    private fun scanMinus() {

    }

   fun scan(source: String) {
       reset(source)
       while (!isEnd()) {
           saveStartPos()
           when(val c = next()) {
               in WhiteSpace -> advance()
               NextLine -> nextLine()
               And -> TODO("& indicating pointer is supported by thrift, but there is no description in the document, deal wit it later")
               in SingleCharMarkTokenList -> {
                   addToken(SingleCharMarkTokenMap[c]!!)
                   advance()
               }
               in StringStart -> scanString()
               in Comment -> scanComment()
               Minus -> scanMinus()
               else -> throw GrammarException(source, "unknown grammar", pos)
           }
       }
   }

}