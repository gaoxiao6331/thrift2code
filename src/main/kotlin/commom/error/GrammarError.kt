package gaoxiao6331.commom.error

data class GrammarError(val msg: String): Error() {
    override val message: String?
        get() = msg
}
