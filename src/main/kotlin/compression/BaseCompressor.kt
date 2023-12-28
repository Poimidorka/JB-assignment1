package org.example.compression

import base.CompressedString

class BaseCompressor : Compressor {
    override fun compress(s : String) : CompressedString {
        val cs = CompressedString()
        if (s.isEmpty()) {
            return cs
        }
        var prev = s.first()
        var len = 0L
        s.forEach {
            if (it == prev) {
                len += 1
            }
            else {
                cs.add(prev, len)
                len = 1
                prev = it
            }
        }
        cs.add(prev, len)
        len = 1
        return cs
    }
}