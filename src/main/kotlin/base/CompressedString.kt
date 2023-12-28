package base

import kotlin.Pair

data class CompressedString(val data: MutableList<Pair<Char, Long>>) {
    constructor() : this(mutableListOf<Pair<Char, Long>>())
    fun add(c : Char, counter: Long) {
        data.add(Pair(c, counter))
    }
    override fun toString(): String {
        val sb = StringBuilder()
        data.forEach {
            sb.append(it.first)
            sb.append('±')
            sb.append(it.second.toString())
        }
        return sb.toString()
    }
}
