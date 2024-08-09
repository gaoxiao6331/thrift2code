package gaoxiao6331.ast2code

import gaoxiao6331.commom.exception.InternalException

class Scanner {

    private var pos = Position(1,1,0)
    private var source = ""
    private var startPos = Position(1,1,0)

    private fun reset(source: String) {
        this.pos = Position(1, 1,0)
        this.source = source
    }

    private fun saveStartPos() {
        this.startPos = this.pos.copy()
    }

    private fun isEnd(i: Int = this.pos.index): Boolean {
        return i >= this.source.length
    }

    private fun advance(): Char {
        val curChar = source[this.pos.index]
        this.pos.index++
        return curChar
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


   fun scan(source: String) {
       reset(source)
       while (!isEnd()) {
           saveStartPos()

       }
   }

}