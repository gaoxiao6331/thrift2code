package gaoxiao6331.commom.exception

import gaoxiao6331.commom.Position
import gaoxiao6331.commom.Location

data class GrammarException(val source: String, val msg: String, val location: Position): Exception() {
    override val message: String?
        get()  {
            return "loc(${location.line}, ${location.column}): ${msg}"
        }
}
