package org.example.engine

import base.CompressedString
import org.example.compression.BaseCompressor
import org.example.compression.Compressor
import org.example.decompression.BaseDecompressor
import org.example.decompression.Decompressor
import org.example.parser.stringToCompress

data class Result(val feedback: String, val successful: Boolean)

class Engine {
    private val compressor: Compressor = BaseCompressor()
    private val decompressor: Decompressor = BaseDecompressor()
    public fun compress(s : String) : Result {
        return try {
            Result(compressor.compress(s).toString(), true)
        } catch (e: Exception) {
            Result(e.message?:"Some error occurred", false)
        }
    }
    public fun decompress(s : String) : Result {
        return try {
            val cs: CompressedString = stringToCompress(s)
            Result(decompressor.decompress(cs), true)
        } catch (e : Exception) {
            Result(e.message?:"Some error occurred", false)
        }
    }
}