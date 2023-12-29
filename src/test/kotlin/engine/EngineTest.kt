package engine

import org.example.engine.Engine
import org.example.engine.Result
import kotlin.random.Random
import kotlin.test.Test
import kotlin.test.assertEquals

class EngineTest {
    @Test
    fun compressAndDecompressTest() {
        val random = Random
        val engine = Engine()
        val l = mutableListOf<String>("")
        l.add("abacaba")
        l.add("AAAAABBB#####")
        l.add("abacabadabacaba")
        l.add("aaaaa552323525dsdsaas123124124124saasdasdadas124124124125555513123121111")
        l.add("asdadad1212312312312313421125125125")
        val randomStrings = 1000
        val length = 2000
        val alphabet = "abcdefghijklmnopqrstuvwxyz0123456789"
        for (i in 0 until  randomStrings) {
            val sb = StringBuilder()
            for (j in 0 until  length) {
                val randomIndex = random.nextInt(alphabet.length)
                val randomChar = alphabet[randomIndex]
                sb.append(randomChar)
            }
            l.add(sb.toString())
        }
        for (el in l) {
            assertEquals(el, engine.decompress(engine.compress(el).feedback).feedback)
        }
    }
    @Test
    fun badInputTest() {
        val engine = Engine()
        assertEquals(Result("± at the start of a string", false), engine.decompress("±10A±1"))
        assertEquals(Result("± at the end of a string", false), engine.decompress("A±10A±1A±1±"))
        assertEquals(Result("Two ± in a row", false), engine.decompress("10A±±10"))
        assertEquals(Result("Not a digit after ±", false), engine.decompress("A±10A±A±1"))
        assertEquals(Result("Leading zero after ±", false), engine.decompress("A±10A±1A±01"))
        assertEquals(Result("Unable to parse ± situation (like 1±1±1±1±1)", false), engine.decompress("1±1±1±1±1"))
    }
}