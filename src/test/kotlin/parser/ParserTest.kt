package parser

import org.example.parser.stringToCompress
import kotlin.test.Test
import kotlin.test.assertEquals

class ParserTest {
    @Test
    fun smallTest() {
        val l = listOf(
            "A±10B±123C±123D±123123",
            "A±110B±123C±123D±123123",
            "A±11230B±2C±123D±123123",
            "A±11320B±2C±2D±1223",
            "A±131210B±123C±2D±1223",
            "A±10B±123C±12D±123123",
            "A±2B±13C±13D±912313",
            )
        for (el in l) {
            assertEquals(el, stringToCompress(el).toString())
        }
    }
    @Test
    fun trickyTest() {
        val l = listOf(
            "1±21±21±21±2",
            "-±10+±10/±10?±10>±10<±10",
            "0±20±20±20±2",
        )
        for (el in l) {
            assertEquals(el, stringToCompress(el).toString())
        }
    }
}