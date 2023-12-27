package org.example.compression

import base.CompressedString

interface Compressor {
    fun compress(s: String) : CompressedString
}