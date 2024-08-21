package thrift2token

import kotlin.test.Test
import org.junit.jupiter.api.Assertions.*

class ScannerTest {

    @Test
    fun testSharedToken() {
        assertEquals(2, 1 + 1)
        assertEquals(3, 1 + 1)
    }
}