package decompression

import base.CompressedString
import org.example.decompression.BaseDecompressor
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class BaseDecompressorTest {
    private val decompressor = BaseDecompressor()
    @Test
    fun smallTest() {
        val cs = CompressedString()
        cs.add('C', 3)
        cs.add('A', 3)
        cs.add('B', 2)
        cs.add('D', 4)
        assertEquals("CCCAAABBDDDD", decompressor.decompress(cs))
    }
    @Test
    fun iterateABCDTest() {
        val l1 = 10L
        val l2 = 10L
        val l3 = 10L
        val l4 = 10L
        for (i1 in 1.. l1) {
            for (i2 in 1.. l2) {
                for (i3 in 1.. l3) {
                    for (i4 in 1.. l4) {
                        val sb = StringBuilder()
                        val cs = CompressedString()
                        cs.add('A', i1)
                        cs.add('B', i2)
                        cs.add('C', i3)
                        cs.add('D', i4)
                        for (j1 in 0..< i1) {
                            sb.append('A')
                        }
                        for (j2 in 0..< i2) {
                            sb.append('B')
                        }
                        for (j3 in 0..< i3) {
                            sb.append('C')
                        }
                        for (j4 in 0..< i4) {
                            sb.append('D')
                        }
                        Assertions.assertEquals(sb.toString(), decompressor.decompress(cs))
                    }
                }
            }
        }
    }
}