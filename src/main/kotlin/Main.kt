package org.example

import org.example.engine.Engine
//TIP To compress input <b>string compress</b>,
//to decompress input <b>string decompress</b>

fun main() {
    val e = Engine()
    var line = readlnOrNull()
    while (line != null) {
        val strings = line.split(" ")
        if (strings.size != 2) {
            println("Bad input, you should input 2 strings with the space delimiter")
            line = readlnOrNull()
            continue
        }
        val string = strings[0]
        val command = strings[1]
        when (command) {
            "compress" -> println(e.compress(string).feedback)
            "decompress" -> println(e.decompress(string).feedback)
            else -> println("Bad input, the second string should be compress or decompress only")
        }
        line = readlnOrNull()
    }
}