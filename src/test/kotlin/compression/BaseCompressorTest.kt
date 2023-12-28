package compression

import org.example.compression.BaseCompressor
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class BaseCompressorTest {
    private val compressor = BaseCompressor()
    @Test
    fun smallTest() {
        assertEquals("A±3", compressor.compress("AAA").toString())
        assertEquals("A±3B±3", compressor.compress("AAABBB").toString())
        assertEquals("A±3B±3C±2", compressor.compress("AAABBBCC").toString())
        assertEquals("A±4", compressor.compress("AAAA").toString())
        assertEquals("A±5", compressor.compress("AAAAA").toString())
        assertEquals("A±6", compressor.compress("AAAAAA").toString())
        assertEquals("A±7", compressor.compress("AAAAAAA").toString())
        assertEquals("A±8", compressor.compress("AAAAAAAA").toString())
        assertEquals("A±9", compressor.compress("AAAAAAAAA").toString())
    }
    @Test
    fun bigLength() {
        val len = 100000000L
        val sb = StringBuilder()
        for (i in 0L..< len) {
            sb.append('A')
        }
        assertEquals("A±$len", compressor.compress(sb.toString()).toString())
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
                        assertEquals("A±${i1}B±${i2}C±${i3}D±${i4}", compressor.compress(sb.toString()).toString())
                    }
                }
            }
        }
    }
}