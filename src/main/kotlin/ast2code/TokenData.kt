package gaoxiao6331.ast2code

import gaoxiao6331.commom.token.Token

data class Position(var line: Int, var column: Int, var index: Int)

data class Location(val start: Position, val end: Position)

data class TokenData(val type: Token, val value: String, val loc: Location)
