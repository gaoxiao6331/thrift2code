package thrift2token

import kotlin.test.Test
import kotlin.test.asserter

class ScannerTest {

    @Test
    fun testSharedToken() {
        asserter.assertSame("test", 1,1)
        asserter.assertSame("test", 1,2)
    }
}