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

    D(Literal.IntLiteral, "4", L(P(0,0,0), P(0,0,0))),
    D(Mark.ColonToken , Mark.ColonToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Keyword.OptionalKeyword, Keyword.OptionalKeyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Keyword.ListKeyword, Keyword.ListKeyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Mark.LessThanToken , Mark.LessThanToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Keyword.StringKeyword, Keyword.StringKeyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Mark.GreaterThanToken , Mark.GreaterThanToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Other.Identifier, "hobbies", L(P(0,0,0), P(0,0,0))),
    D(Mark.CommaToken, Mark.CommaToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),

    D(Literal.IntLiteral, "5", L(P(0,0,0), P(0,0,0))),
    D(Mark.ColonToken , Mark.ColonToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Keyword.MapKeyword, Keyword.MapKeyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Mark.LessThanToken , Mark.LessThanToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Keyword.StringKeyword, Keyword.StringKeyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Mark.CommaToken, Mark.CommaToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Keyword.StringKeyword, Keyword.StringKeyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Mark.GreaterThanToken , Mark.GreaterThanToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Other.Identifier, "attributes", L(P(0,0,0), P(0,0,0))),
    D(Mark.CommaToken, Mark.CommaToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),

    D(Literal.IntLiteral, "6", L(P(0,0,0), P(0,0,0))),
    D(Mark.ColonToken , Mark.ColonToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Other.Identifier, "Container", L(P(0,0,0), P(0,0,0))),
    D(Other.Identifier, "Container", L(P(0,0,0), P(0,0,0))),
    D(Literal.CommentLine, " 嵌套类型", L(P(0,0,0), P(0,0,0))),

    D(Mark.RightBraceToken, Mark.RightBraceToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),

    // union
    D(Literal.CommentLine, " 定义联合体", L(P(0,0,0), P(0,0,0))),
    D(Keyword.UnionKeyword, Keyword.UnionKeyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Other.Identifier, "ExampleUnion", L(P(0,0,0), P(0,0,0))),
    D(Mark.LeftBraceToken, Mark.LeftBraceToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),

    D(Literal.IntLiteral, "1", L(P(0,0,0), P(0,0,0))),
    D(Mark.ColonToken , Mark.ColonToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Keyword.I32Keyword, Keyword.I32Keyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Other.Identifier, "intValue", L(P(0,0,0), P(0,0,0))),
    D(Mark.CommaToken, Mark.CommaToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),

    D(Literal.IntLiteral, "2", L(P(0,0,0), P(0,0,0))),
    D(Mark.ColonToken , Mark.ColonToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Keyword.StringKeyword, Keyword.StringKeyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Other.Identifier, "stringValue", L(P(0,0,0), P(0,0,0))),
    D(Mark.CommaToken, Mark.CommaToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),

    D(Literal.IntLiteral, "3", L(P(0,0,0), P(0,0,0))),
    D(Mark.ColonToken , Mark.ColonToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Keyword.BoolKeyword, Keyword.BoolKeyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Other.Identifier, "boolValue", L(P(0,0,0), P(0,0,0))),
    D(Mark.CommaToken, Mark.CommaToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),

    D(Mark.RightBraceToken, Mark.RightBraceToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),


    // exception
    D(Literal.CommentLine, " 定义异常", L(P(0,0,0), P(0,0,0))),
    D(Keyword.ExceptionKeyword, Keyword.ExceptionKeyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Other.Identifier, "InvalidOperation", L(P(0,0,0), P(0,0,0))),
    D(Mark.LeftBraceToken, Mark.LeftBraceToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),

    D(Literal.IntLiteral, "1", L(P(0,0,0), P(0,0,0))),
    D(Mark.ColonToken , Mark.ColonToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Keyword.I32Keyword, Keyword.I32Keyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Other.Identifier, "code", L(P(0,0,0), P(0,0,0))),
    D(Mark.CommaToken, Mark.CommaToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),

    D(Literal.IntLiteral, "2", L(P(0,0,0), P(0,0,0))),
    D(Mark.ColonToken , Mark.ColonToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Keyword.StringKeyword, Keyword.StringKeyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Other.Identifier, "message", L(P(0,0,0), P(0,0,0))),
    D(Mark.CommaToken, Mark.CommaToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),

    D(Mark.RightBraceToken, Mark.RightBraceToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),

    // service
    D(Literal.CommentLine, " 定义服务", L(P(0,0,0), P(0,0,0))),
    D(Keyword.ServiceKeyword, Keyword.ServiceKeyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Other.Identifier, "PersonService", L(P(0,0,0), P(0,0,0))),
    D(Mark.LeftBraceToken, Mark.LeftBraceToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),

    D(Other.Identifier, "Person", L(P(0,0,0), P(0,0,0))),
    D(Other.Identifier, "getPersonByName", L(P(0,0,0), P(0,0,0))),
    D(Mark.LeftParenthesisToken, Mark.LeftParenthesisToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Literal.IntLiteral, "1", L(P(0,0,0), P(0,0,0))),
    D(Mark.ColonToken , Mark.ColonToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Keyword.StringKeyword, Keyword.StringKeyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Other.Identifier, "name", L(P(0,0,0), P(0,0,0))),
    D(Mark.RightParenthesisToken, Mark.RightParenthesisToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Keyword.ThrowsKeyword, Keyword.ThrowsKeyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Mark.LeftParenthesisToken, Mark.LeftParenthesisToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Literal.IntLiteral, "1", L(P(0,0,0), P(0,0,0))),
    D(Mark.ColonToken , Mark.ColonToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Other.Identifier, "InvalidOperation", L(P(0,0,0), P(0,0,0))),
    D(Other.Identifier, "io", L(P(0,0,0), P(0,0,0))),
    D(Mark.RightParenthesisToken, Mark.RightParenthesisToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Mark.CommaToken, Mark.CommaToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),

    D(Keyword.ListKeyword, Keyword.ListKeyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Mark.LessThanToken , Mark.LessThanToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Other.Identifier, "Person", L(P(0,0,0), P(0,0,0))),
    D(Mark.GreaterThanToken , Mark.GreaterThanToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Other.Identifier, "getAllPersons", L(P(0,0,0), P(0,0,0))),
    D(Mark.LeftParenthesisToken, Mark.LeftParenthesisToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Mark.RightParenthesisToken, Mark.RightParenthesisToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Mark.CommaToken, Mark.CommaToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),

    D(Keyword.VoidKeyword, Keyword.VoidKeyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Other.Identifier, "savePerson", L(P(0,0,0), P(0,0,0))),
    D(Mark.LeftParenthesisToken, Mark.LeftParenthesisToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Literal.IntLiteral, "1", L(P(0,0,0), P(0,0,0))),
    D(Mark.ColonToken , Mark.ColonToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Other.Identifier, "Person", L(P(0,0,0), P(0,0,0))),
    D(Other.Identifier, "person", L(P(0,0,0), P(0,0,0))),
    D(Mark.RightParenthesisToken, Mark.RightParenthesisToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Keyword.ThrowsKeyword, Keyword.ThrowsKeyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Mark.LeftParenthesisToken, Mark.LeftParenthesisToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Literal.IntLiteral, "1", L(P(0,0,0), P(0,0,0))),
    D(Mark.ColonToken , Mark.ColonToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Other.Identifier, "InvalidOperation", L(P(0,0,0), P(0,0,0))),
    D(Other.Identifier, "io", L(P(0,0,0), P(0,0,0))),
    D(Mark.RightParenthesisToken, Mark.RightParenthesisToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Mark.CommaToken, Mark.CommaToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),

    D(Keyword.OnewayKeyword, Keyword.OnewayKeyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Keyword.VoidKeyword, Keyword.VoidKeyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Other.Identifier, "ping", L(P(0,0,0), P(0,0,0))),
    D(Mark.LeftParenthesisToken, Mark.LeftParenthesisToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Mark.RightParenthesisToken, Mark.RightParenthesisToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Mark.CommaToken, Mark.CommaToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),

    D(Keyword.BoolKeyword, Keyword.BoolKeyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Other.Identifier, "checkPersonExists", L(P(0,0,0), P(0,0,0))),
    D(Mark.LeftParenthesisToken, Mark.LeftParenthesisToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Literal.IntLiteral, "1", L(P(0,0,0), P(0,0,0))),
    D(Mark.ColonToken , Mark.ColonToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Keyword.StringKeyword, Keyword.StringKeyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Other.Identifier, "name", L(P(0,0,0), P(0,0,0))),
    D(Mark.RightParenthesisToken, Mark.RightParenthesisToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Mark.CommaToken, Mark.CommaToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Literal.CommentLine, " 返回布尔值的方法", L(P(0,0,0), P(0,0,0))),

    D(Literal.CommentLine, " 定义类型别名", L(P(0,0,0), P(0,0,0))),
    D(Keyword.TypedefKeyword, Keyword.TypedefKeyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Keyword.I64Keyword, Keyword.I64Keyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Other.Identifier, "Timestamp", L(P(0,0,0), P(0,0,0))),

    // container struct
    D(Literal.CommentLine, " 定义容器", L(P(0,0,0), P(0,0,0))),
    D(Keyword.StructKeyword, Keyword.StructKeyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Other.Identifier, "Container", L(P(0,0,0), P(0,0,0))),
    D(Mark.LeftBraceToken, Mark.LeftBraceToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),

    D(Literal.IntLiteral, "1", L(P(0,0,0), P(0,0,0))),
    D(Mark.ColonToken , Mark.ColonToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Keyword.ListKeyword, Keyword.ListKeyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Mark.LessThanToken , Mark.LessThanToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Keyword.I32Keyword, Keyword.I32Keyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Mark.GreaterThanToken , Mark.GreaterThanToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Other.Identifier, "numbers", L(P(0,0,0), P(0,0,0))),
    D(Mark.CommaToken, Mark.CommaToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),

    D(Literal.IntLiteral, "2", L(P(0,0,0), P(0,0,0))),
    D(Mark.ColonToken , Mark.ColonToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Keyword.SetKeyword, Keyword.SetKeyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Mark.LessThanToken , Mark.LessThanToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Keyword.StringKeyword, Keyword.StringKeyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Mark.GreaterThanToken , Mark.GreaterThanToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Other.Identifier, "uniqueStrings", L(P(0,0,0), P(0,0,0))),
    D(Mark.CommaToken, Mark.CommaToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),

    D(Literal.IntLiteral, "3", L(P(0,0,0), P(0,0,0))),
    D(Mark.ColonToken , Mark.ColonToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Keyword.MapKeyword, Keyword.MapKeyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Mark.LessThanToken , Mark.LessThanToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Keyword.StringKeyword, Keyword.StringKeyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Mark.CommaToken, Mark.CommaToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Keyword.I32Keyword, Keyword.I32Keyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Mark.GreaterThanToken , Mark.GreaterThanToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Other.Identifier, "nameToId", L(P(0,0,0), P(0,0,0))),
    D(Mark.CommaToken, Mark.CommaToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Mark.RightBraceToken, Mark.RightBraceToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),

    // Empty struct
    D(Literal.CommentLine, " 定义空结构体", L(P(0,0,0), P(0,0,0))),
    D(Keyword.StructKeyword, Keyword.StructKeyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Other.Identifier, "EmptyStruct", L(P(0,0,0), P(0,0,0))),
    D(Mark.LeftBraceToken, Mark.LeftBraceToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Mark.RightBraceToken, Mark.RightBraceToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),

    D(Literal.CommentLine, " 单行注释", L(P(0,0,0), P(0,0,0))),
    D(Literal.CommentBlock, "\n  多行注释\n", L(P(0,0,0), P(0,0,0))),

    // all types
    D(Literal.CommentLine, " 包含所有基本类型和复杂类型的结构体", L(P(0,0,0), P(0,0,0))),
    D(Keyword.StructKeyword, Keyword.StructKeyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Other.Identifier, "EmptyStruct", L(P(0,0,0), P(0,0,0))),
    D(Mark.LeftBraceToken, Mark.LeftBraceToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),

    D(Literal.IntLiteral, "1", L(P(0,0,0), P(0,0,0))),
    D(Mark.ColonToken , Mark.ColonToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Keyword.BoolKeyword, Keyword.BoolKeyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Other.Identifier, "aBool", L(P(0,0,0), P(0,0,0))),
    D(Mark.CommaToken, Mark.CommaToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),

    D(Literal.IntLiteral, "2", L(P(0,0,0), P(0,0,0))),
    D(Mark.ColonToken , Mark.ColonToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Keyword.ByteKeyword, Keyword.ByteKeyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Other.Identifier, "aByte", L(P(0,0,0), P(0,0,0))),
    D(Mark.CommaToken, Mark.CommaToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),

    D(Literal.IntLiteral, "3", L(P(0,0,0), P(0,0,0))),
    D(Mark.ColonToken , Mark.ColonToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Keyword.I16Keyword, Keyword.I16Keyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Other.Identifier, "aI16", L(P(0,0,0), P(0,0,0))),
    D(Mark.CommaToken, Mark.CommaToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),

    D(Literal.IntLiteral, "4", L(P(0,0,0), P(0,0,0))),
    D(Mark.ColonToken , Mark.ColonToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Keyword.I32Keyword, Keyword.I32Keyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Other.Identifier, "aI32", L(P(0,0,0), P(0,0,0))),
    D(Mark.CommaToken, Mark.CommaToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),

    D(Literal.IntLiteral, "5", L(P(0,0,0), P(0,0,0))),
    D(Mark.ColonToken , Mark.ColonToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Keyword.I64Keyword, Keyword.I64Keyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Other.Identifier, "aI64", L(P(0,0,0), P(0,0,0))),
    D(Mark.CommaToken, Mark.CommaToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),

    D(Literal.IntLiteral, "6", L(P(0,0,0), P(0,0,0))),
    D(Mark.ColonToken , Mark.ColonToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Keyword.DoubleKeyword, Keyword.DoubleKeyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Other.Identifier, "aDouble", L(P(0,0,0), P(0,0,0))),
    D(Mark.CommaToken, Mark.CommaToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),

    D(Literal.IntLiteral, "7", L(P(0,0,0), P(0,0,0))),
    D(Mark.ColonToken , Mark.ColonToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Keyword.StringKeyword, Keyword.StringKeyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Other.Identifier, "aString", L(P(0,0,0), P(0,0,0))),
    D(Mark.CommaToken, Mark.CommaToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),

    D(Literal.IntLiteral, "8", L(P(0,0,0), P(0,0,0))),
    D(Mark.ColonToken , Mark.ColonToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Keyword.BinaryKeyword, Keyword.BinaryKeyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Other.Identifier, "aBinary", L(P(0,0,0), P(0,0,0))),
    D(Mark.CommaToken, Mark.CommaToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),

    D(Literal.IntLiteral, "9", L(P(0,0,0), P(0,0,0))),
    D(Mark.ColonToken , Mark.ColonToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Keyword.ListKeyword, Keyword.ListKeyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Mark.LessThanToken, Mark.LessThanToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Keyword.StringKeyword, Keyword.StringKeyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Mark.GreaterThanToken, Mark.GreaterThanToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Keyword.ListKeyword, Keyword.ListKeyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Other.Identifier, "aList", L(P(0,0,0), P(0,0,0))),
    D(Mark.CommaToken, Mark.CommaToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),

    D(Literal.IntLiteral, "10", L(P(0,0,0), P(0,0,0))),
    D(Mark.ColonToken , Mark.ColonToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Keyword.ListKeyword, Keyword.ListKeyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Mark.LessThanToken, Mark.LessThanToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Keyword.StringKeyword, Keyword.StringKeyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Mark.GreaterThanToken, Mark.GreaterThanToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Keyword.SetKeyword, Keyword.SetKeyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Other.Identifier, "aSet", L(P(0,0,0), P(0,0,0))),
    D(Mark.CommaToken, Mark.CommaToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),

    D(Literal.IntLiteral, "11", L(P(0,0,0), P(0,0,0))),
    D(Mark.ColonToken , Mark.ColonToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Keyword.ListKeyword, Keyword.ListKeyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Mark.LessThanToken, Mark.LessThanToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Keyword.StringKeyword, Keyword.StringKeyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Keyword.I32Keyword, Keyword.I32Keyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Mark.GreaterThanToken, Mark.GreaterThanToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Keyword.MapKeyword, Keyword.MapKeyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Other.Identifier, "aMap", L(P(0,0,0), P(0,0,0))),
    D(Mark.CommaToken, Mark.CommaToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),

    D(Literal.IntLiteral, "12", L(P(0,0,0), P(0,0,0))),
    D(Mark.ColonToken , Mark.ColonToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    D(Other.Identifier, "ExampleUnion", L(P(0,0,0), P(0,0,0))),
    D(Other.Identifier, "aUnion", L(P(0,0,0), P(0,0,0))),
    D(Mark.RightBraceToken, Mark.RightBraceToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),


    D(Mark.RightBraceToken, Mark.RightBraceToken.markChar.toString(), L(P(0,0,0), P(0,0,0))),
    )