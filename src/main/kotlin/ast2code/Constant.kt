package gaoxiao6331.ast2code

import gaoxiao6331.commom.token.Keyword
import gaoxiao6331.commom.token.Literal
import gaoxiao6331.commom.token.Mark
import org.intellij.lang.annotations.Identifier

val WhiteSpace = listOf(' ', '\r', '\t')

val NextLine = '\n'

val And = '&'

val SingleCharMarkTokenList = Mark.entries.map { it.markChar }
val SingleCharMarkTokenMap = Mark.entries.fold(mutableMapOf<Char, Mark>()) { map, mark ->
    map[mark.markChar] = Mark.valueOf(mark.name)
    return@fold map
}

val KeywordTokenList = Keyword.entries.map { it.keywordName }
val KeyWordTokenMap = Keyword.entries.fold(mutableMapOf<String, Keyword>()) { map, keyword ->
    map[keyword.keywordName] = Keyword.valueOf(keyword.name)
    return@fold map
}


val StringStart = listOf('\'', '"')


val Hash = '#'
val Slash = '/'
val Star = '*'
val Comment = listOf(Hash, Slash)

val Minus = '-'
val Plus = '+'
val PosOrNegSign = listOf(Minus, Plus)

val Digit = '0' .. '9'
val HexDigit = Digit + ('A'..'F') + ('a'..'f')
val X = listOf('x', 'X')
val E = listOf('e','E')
val HexStart = "0X"

val Dot = '.'

val Letter = ('a'..'z') + ('A'..'Z')
val Underscore = '_'

val BoolLiteral = listOf("true", "false")