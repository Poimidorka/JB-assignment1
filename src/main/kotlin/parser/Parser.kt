package org.example.parser

import base.CompressedString

fun stringToCompress(s: String) : CompressedString {
    val cs = CompressedString()

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
                    if (numStarted) {
                        throw Exception("Two ± in a row")
                    }
                    counter = 0
                    c = prev
                    numStarted = true
                }

                else -> {
                    if (numStarted) {
                        if (it.isDigit()) {
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
        for (i in 0..< it.second) {
            sb.append(it.first)
        }
    }
    return sb.toString()
}