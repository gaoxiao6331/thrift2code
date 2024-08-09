package gaoxiao6331.commom.token

enum class Literal: Token {
    CommentLine,
    CommentBlock,
    StringLiteral,
    IntLiteral,
    FloatLiteral,
    HexLiteral,
    ExponentialLiteral,
    BooleanLiteral,
}