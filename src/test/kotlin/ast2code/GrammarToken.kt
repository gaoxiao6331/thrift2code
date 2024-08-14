package ast2code

import gaoxiao6331.ast2code.KeyWordTokenMap
import gaoxiao6331.ast2code.Location
import gaoxiao6331.ast2code.Position
import gaoxiao6331.ast2code.TokenData
import gaoxiao6331.commom.token.Keyword
import gaoxiao6331.commom.token.Other
import gaoxiao6331.commom.token.Token

typealias D = TokenData
typealias P = Position
typealias L = Location

val grammarToken = listOf<TokenData>(
    D(Keyword.NamespaceKeyword, Keyword.NamespaceKeyword.keywordName, L(P(0,0,0), P(0,0,0))),
    D(Other.Identifier, "java", L(P(0,0,0), P(0,0,0))),
)