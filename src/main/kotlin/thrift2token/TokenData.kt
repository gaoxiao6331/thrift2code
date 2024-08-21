package gaoxiao6331.thrift2token

import gaoxiao6331.commom.token.Token
import gaoxiao6331.commom.Location

data class TokenData(val type: Token, val value: String, val loc: Location)
