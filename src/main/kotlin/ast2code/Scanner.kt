package gaoxiao6331.ast2code

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

   fun scan(source: String) {

   }

}