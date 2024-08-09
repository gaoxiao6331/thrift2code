package gaoxiao6331.ast2code

import gaoxiao6331.commom.exception.InternalException

class Scanner {

    private var line = 1
    private var column = 1
    private var idx = 0
    private var source = ""

    private fun reset(source: String) {
        this.line = 1
        this.column = 1
        this.source = source
        this.idx = 0
    }

    private fun isEnd(): Boolean {
        return this.idx >= this.source.length
    }

    private fun advance(): Char {
        val curChar = source[idx]
        idx++
        return curChar
    }

    private fun previous(n: Int = 1): Char {
        val prevIdx = idx - n
        if (prevIdx >= 0) {
            return source[prevIdx]
        }
        throw InternalException("current index is ${idx}, cannot get previous $n")
    }

   fun scan(source: String) {
       while (!isEnd()) {

       }
   }

}