package base;

import kotlin.Pair;
import kotlin.collections.*;
public data class CompressedString(val data: MutableList<Pair<Char, Long>>) {
    constructor() : this(mutableListOf<Pair<Char, Long>>())
    public fun add(p : Pair<Char, Long>) {
        data.add(p)
    }
    public fun add(c : Char, counter: Long) {
        data.add(Pair<Char, Long>(c, counter))
    }
}
