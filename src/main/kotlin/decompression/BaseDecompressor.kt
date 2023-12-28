package org.example.decompression

import base.CompressedString
import org.example.parser.compressToString

class BaseDecompressor : Decompressor {
    override fun decompress(cs: CompressedString): String {
        return compressToString(cs)
    }
}