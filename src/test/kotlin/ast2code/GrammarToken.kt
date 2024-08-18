package ast2code

import gaoxiao6331.ast2code.KeyWordTokenMap
import gaoxiao6331.ast2code.Location
import gaoxiao6331.ast2code.Position
import gaoxiao6331.ast2code.TokenData
import gaoxiao6331.commom.token.*

typealias D = TokenData
typealias P = Position
typealias L = Location

val grammarToken = listOf<TokenData>(
    // namespace
    D(Literal.CommentLine, " 定义命名空间", L(P(0,0,0), P(0,0,0))),
    D(Keyword.NamespaceKeyword, Keyword.NamespaceKeyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Other.Identifier, "java", L(P(0,0,0), P(0,0,0))),
    D(Other.Identifier, "com.example.project",L(P(0,0,0), P(0,0,0))),

    D(Keyword.NamespaceKeyword, Keyword.NamespaceKeyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Other.Identifier, "py", L(P(0,0,0), P(0,0,0))),
    D(Other.Identifier, "example.project",L(P(0,0,0), P(0,0,0))),

    // include
    D(Literal.CommentLine, " 引入其他 Thrift 文件", L(P(0,0,0), P(0,0,0))),
    D(Keyword.IncludeKeyword, Keyword.IncludeKeyword.keywordName, L(P(0,0,0), P(0,0,0))),

    // const
    D(Literal.CommentLine, " 定义常量", L(P(0,0,0), P(0,0,0))),
    D(Keyword.ConstKeyword, Keyword.ConstKeyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Keyword.I32Keyword, Keyword.I32Keyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Other.Identifier, "DEFAULT_AGE", L(P(0,0,0), P(0,0,0))),
    D(Mark.EqualToken, Mark.EqualToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Literal.IntLiteral ,"25", L(P(0,0,0), P(0,0,0))),

    D(Keyword.ConstKeyword, Keyword.ConstKeyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Keyword.StringKeyword, Keyword.StringKeyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Other.Identifier, "DEFAULT_NAME", L(P(0,0,0), P(0,0,0))),
    D(Mark.EqualToken, Mark.EqualToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Literal.StringLiteral ,"Anonymous", L(P(0,0,0), P(0,0,0))),

    D(Keyword.ConstKeyword, Keyword.ConstKeyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Keyword.DoubleKeyword, Keyword.DoubleKeyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Other.Identifier, "PI", L(P(0,0,0), P(0,0,0))),
    D(Mark.EqualToken, Mark.EqualToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Literal.FloatLiteral ,"3.14159", L(P(0,0,0), P(0,0,0))),

    // enum
    D(Literal.CommentLine, " 定义枚举", L(P(0,0,0), P(0,0,0))),
    D(Keyword.EnumKeyword, Keyword.EnumKeyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Other.Identifier, "Gender", L(P(0,0,0), P(0,0,0))),
    D(Mark.LeftBraceToken, Mark.LeftBraceToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),

    D(Other.Identifier, "MALE", L(P(0,0,0), P(0,0,0))),
    D(Mark.EqualToken, Mark.EqualToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Literal.IntLiteral, "0", L(P(0,0,0), P(0,0,0))),
    D(Mark.CommaToken, Mark.CommaToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),

    D(Other.Identifier, "FEMALE", L(P(0,0,0), P(0,0,0))),
    D(Mark.EqualToken, Mark.EqualToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Literal.IntLiteral, "1", L(P(0,0,0), P(0,0,0))),
    D(Mark.CommaToken, Mark.CommaToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),

    D(Other.Identifier, "OTHER", L(P(0,0,0), P(0,0,0))),
    D(Mark.EqualToken, Mark.EqualToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Literal.IntLiteral, "2", L(P(0,0,0), P(0,0,0))),

    D(Mark.RightBraceToken, Mark.RightBraceToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),

    // struct
    D(Literal.CommentLine, " 定义结构体", L(P(0,0,0), P(0,0,0))),
    D(Keyword.StructKeyword, Keyword.StructKeyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Other.Identifier, "Person", L(P(0,0,0), P(0,0,0))),
    D(Mark.LeftBraceToken, Mark.LeftBraceToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),

    D(Literal.IntLiteral, "1", L(P(0,0,0), P(0,0,0))),
    D(Mark.ColonToken , Mark.ColonToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Keyword.RequiredKeyword, Keyword.RequiredKeyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Keyword.StringKeyword, Keyword.StringKeyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Other.Identifier, "name", L(P(0,0,0), P(0,0,0))),
    D(Mark.EqualToken, Mark.EqualToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Literal.StringLiteral, "John Doe", L(P(0,0,0), P(0,0,0))),
    D(Mark.CommaToken, Mark.CommaToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Literal.CommentLine, " 默认值", L(P(0,0,0), P(0,0,0))),

    D(Literal.IntLiteral, "2", L(P(0,0,0), P(0,0,0))),
    D(Mark.ColonToken , Mark.ColonToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Keyword.OptionalKeyword, Keyword.OptionalKeyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Keyword.I32Keyword, Keyword.I32Keyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Other.Identifier, "age", L(P(0,0,0), P(0,0,0))),
    D(Mark.EqualToken, Mark.EqualToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Literal.StringLiteral, "DEFAULT_AGE", L(P(0,0,0), P(0,0,0))),
    D(Mark.CommaToken, Mark.CommaToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Literal.CommentLine, " 使用常量", L(P(0,0,0), P(0,0,0))),

    D(Literal.IntLiteral, "3", L(P(0,0,0), P(0,0,0))),
    D(Mark.ColonToken , Mark.ColonToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Keyword.RequiredKeyword, Keyword.RequiredKeyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Other.Identifier, "Gender", L(P(0,0,0), P(0,0,0))),
    D(Other.Identifier, "gender", L(P(0,0,0), P(0,0,0))),
    D(Mark.CommaToken, Mark.CommaToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),



    D(Mark.RightBraceToken, Mark.RightBraceToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    )