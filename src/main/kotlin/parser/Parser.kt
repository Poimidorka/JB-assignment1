package org.example.parser

import base.CompressedString

fun stringToCompress(s: String) : CompressedString {
    val cs = CompressedString()
    if (s == "") {
        return cs
    }
    //For ± separation
    var numStarted = false
    var prev = s.first()

    //For a number after ±
    var c = 'a'
    var counter = 0L

    if (s.first() == '±') {
        throw Exception("± at the start of a string")
    }
    if (s.last() == '±') {
        throw Exception("± at the end of a string")
    }
    s.forEachIndexed { index, it ->
        if (index != 0) {
            when {
                it == '±' -> {
                    if (prev == '±') {
                        throw Exception("Two ± in a row")
                    }
                    if (numStarted) {
                        if (counter < 10) {
                            throw Exception("Unable to parse ± situation (like 1±1±1±1±1)")
                        }
                        else {
                            counter /= 10
                            cs.add(c, counter)
                        }
                    }
                    counter = 0
                    c = prev
                    numStarted = true
                }
                else -> {
                    if (numStarted) {
                        if (it.isDigit()) {
                            if (counter == 0L && it == '0') {
                                throw Exception("Leading zero after ±")
                            }
                            counter = counter * 10 + (it - '0')
                        } else {
                            if (prev == '±') {
                                throw Exception("Not a digit after ±")
                            }
                            cs.add(c, counter)
                            counter = 0
                            numStarted = false
                        }
                    } else {
                        cs.add(prev, 1)
                    }
                }
            }
            prev = it
        }
    }
    if (numStarted) {
        cs.add(c, counter)
    }
    else {
        cs.add(prev, 1)
    }
    return cs
}

fun compressToString(cs: CompressedString) : String {
    val sb = StringBuilder()
    cs.data.forEach {
        for (i in 0 until  it.second) {
            sb.append(it.first)
        }
    }
    return sb.toString()
}