package org.example.parser

import base.CompressedString

fun StringToCompress(s: String) : CompressedString {
    val cs = CompressedString()

    return cs
}

fun CompressToString(cs: CompressedString) : String {
    val sb = StringBuilder()
    cs.data.forEach { it ->
        for (i in 0..it.second) {
            sb.append(it.first)
        }
    }
    return sb.toString()
}