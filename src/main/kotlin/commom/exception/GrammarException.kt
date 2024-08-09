package gaoxiao6331.commom.error

import gaoxiao6331.ast2code.Position

data class GrammarException(val source: String, val msg: String, val location: Position): Exception() {
    override val message: String?
        get()  {
            return "loc(${location.line}, ${location.column}): ${msg}"
        }
}
