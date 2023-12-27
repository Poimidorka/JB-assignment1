package org.example.decompression

import base.CompressedString

interface Decompressor {
    fun decompress(cs: CompressedString) : String
}