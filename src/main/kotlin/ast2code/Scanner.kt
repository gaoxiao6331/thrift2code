package gaoxiao6331.ast2code

import gaoxiao6331.commom.exception.InternalException
import gaoxiao6331.commom.token.Token

class Scanner {

    // this value should not be used due to reset()
    private var pos = Position(1,1,0)
    private var source = ""
    private var startPos = Position(1,1,0)

    private fun reset(source: String) {
        this.pos = Position(1, 1,0)
        this.startPos = Position(1, 1, 0)
        this.source = source
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

    private fun nextLine() {
        this.pos.line ++
        this.pos.column = 1
    }

    private fun buildToken(type: Token): TokenData {
        val start = this.startPos.index
        val end = this.pos.index
        val value = this.source.substring(start, end)
        val location = Location(
            this.startPos.copy(),
            this.pos.copy()
        )
        return TokenData(type, value, location)
    }

   fun scan(source: String) {
       reset(source)
       while (!isEnd()) {
           saveStartPos()
           when(val c = next()) {
               in WhiteSpace -> continue
               NextLine -> nextLine()
               And -> TODO("& indicating pointer is supported by thrift, but there is no description in the document, deal wit it later")

           }
           advance()
       }
   }

}