package org.example.compression

import base.CompressedString
import org.example.parser.CompressToString

class BaseCompressor : Compressor {
    override fun compress(s : String) : CompressedString {
        val cs = CompressedString()
        if (s.isEmpty()) {
            return cs
        }
        var prev = s.first() + 1;
        var len : Long = 0L;
        s.forEach { it ->
            if (it == prev) {
                len += 1;
            }
            else {
                cs.add(prev, len)
                len = 1;
                prev = it;
            }
        }
        cs.add(prev, len)
        len = 1;
        return cs
    }
}