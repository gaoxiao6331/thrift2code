package gaoxiao6331.ast2code

import gaoxiao6331.commom.token.Keyword
import gaoxiao6331.commom.token.Mark

val WhiteSpace = listOf(' ', '\r', '\t')

val NextLine = '\n'

val And = '&'

val SingleCharMarkTokenList = Mark.entries.map { it.markChar }
val SingleCharMarkTokenMap = Mark.entries.fold(mutableMapOf<Char, Mark>()) { map, mark ->
    map[mark.markChar] = Mark.valueOf(mark.name)
    return@fold map
}

val KeywordTokenList = Keyword.entries.map { it.keywordName }
val KeyWordTokenMap = Keyword.entries.fold(mutableMapOf<String, Mark>()) { map, keyword ->
    map[keyword.keywordName] = Mark.valueOf(keyword.name)
    return@fold map
}


val StringStart = listOf('\'', '"')


val Hash = '#'
val Slash = '/'
val Star = '*'
val Comment = listOf(Hash, Slash)

val Minus = '-'
