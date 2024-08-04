package gaoxiao6331.ast2code

enum class TokenType {

}

data class Position(val line: Int, val column: Int, val index: Int)

data class Location(val start: Position, val end: Position)

data class Token(val type: TokenType, val value: Any, val loc: Location)