package gaoxiao6331.commom

data class Position(var line: Int, var column: Int, var index: Int)

data class Location(val start: Position, val end: Position)