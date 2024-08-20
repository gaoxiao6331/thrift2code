package gaoxiao6331.commom.token

enum class Mark(val markChar: Char) : Token {
    LeftParenthesisToken('('),
    RightParenthesisToken(')'),
    LeftBraceToken('{'),
    RightBraceToken('}'),
    LeftBracketToken('['),
    RightBracketToken(']'),
    CommaToken(','),
    DotToken('.'),
    MinusToken('-'),
    SemicolonToken(';'),
    ColonToken(':'),
    StarToken('*'),
    EqualToken('='),
    LessThanToken('<'),
    GreaterThanToken('>'),
}