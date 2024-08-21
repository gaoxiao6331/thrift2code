package thrift2token

import gaoxiao6331.thrift2token.TokenData
import gaoxiao6331.commom.token.Keyword
import gaoxiao6331.commom.token.Literal
import gaoxiao6331.commom.token.Mark
import gaoxiao6331.commom.token.Other

val sharedToken = listOf<TokenData>(
    // namespace
    D(Literal.CommentLine, " 示例中的共享文件内容 (shared.thrift)", L(P(0,0,0), P(0,0,0))),
    D(Keyword.NamespaceKeyword, Keyword.NamespaceKeyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Other.Identifier, "java", L(P(0,0,0), P(0,0,0))),
    D(Other.Identifier, "com.example.shared",L(P(0,0,0), P(0,0,0))),

    D(Keyword.TypedefKeyword, Keyword.TypedefKeyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Keyword.StringKeyword, Keyword.StringKeyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Other.Identifier, "UUID", L(P(0,0,0), P(0,0,0))),

    D(Keyword.ConstKeyword, Keyword.ConstKeyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Other.Identifier, "UUID", L(P(0,0,0), P(0,0,0))),
    D(Other.Identifier, "DEFAULT_UUID", L(P(0,0,0), P(0,0,0))),
    D(Mark.EqualToken, Mark.EqualToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Literal.StringLiteral ,"00000000-0000-0000-0000-000000000000", L(P(0,0,0), P(0,0,0))),

    D(Literal.CommentLine, " 服务方法中使用异步 (future) 语法", L(P(0,0,0), P(0,0,0))),
    D(Keyword.StructKeyword, Keyword.StructKeyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Other.Identifier, "SharedService", L(P(0,0,0), P(0,0,0))),
    D(Mark.LeftBraceToken, Mark.LeftBraceToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),

    D(Keyword.BoolKeyword, Keyword.BoolKeyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Other.Identifier, "checkUUID", L(P(0,0,0), P(0,0,0))),
    D(Mark.LeftParenthesisToken, Mark.LeftParenthesisToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Literal.IntLiteral, "1", L(P(0,0,0), P(0,0,0))),
    D(Other.Identifier, "UUID", L(P(0,0,0), P(0,0,0))),
    D(Other.Identifier, "uuid", L(P(0,0,0), P(0,0,0))),
    D(Mark.RightParenthesisToken, Mark.RightParenthesisToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Mark.RightBracketToken, Mark.RightBraceToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
)