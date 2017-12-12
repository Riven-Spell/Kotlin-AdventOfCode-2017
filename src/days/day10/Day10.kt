package days.day10

import kotlin.experimental.xor

var outputVal = 255

class Hasher(s: String) {
    private val sizes = s

    fun realHash(): String {
        val bytes = sizes.toByteArray(Charsets.US_ASCII) + listOf<Byte>(17,31,73,47,23)

        var pos = 0
        var skip = 0
        var list = (0..255).toMutableList()
        for(i in 1..64) {
            bytes.forEach { len ->
                (0..(len-1)).map { (it + pos) % list.size }.map { list[it] }.reversed().forEachIndexed{ i, v ->
                    list[(pos+i) % list.size] = v
                }

                pos = (pos + skip + len) % list.size
                skip++
            }
        }

        return list.withIndex().groupBy { it.index / 16 }.map { it.value.map { it.value } }.map{ it.map { n -> n.toByte() } }.map { list ->
            var o = list[0]
            list.drop(1).forEach {
                o = o.xor(it)
            }
            o
        }.map { String.format("%02x", it) }.joinToString("")
    }

    fun hashSingle(): Int {
        var output = (0..outputVal).toMutableList()
        val slist = sizes.split(regex = Regex(",\\s*")).map { it.toInt() }
        var pos = 0
        var skip = 0
        slist.forEach {
            (0..(it - 1)).map { x -> x + pos }.map { x -> output[x % output.size] }.reversed().forEachIndexed { i, v ->
                output[(pos + i) % output.size] = v
            }

            pos += it + skip
            skip++
        }
        return output[0] * output[1]
    }
}

fun day10p1(s: String): String = Hasher(s).hashSingle().toString()
fun day10p2(s: String): String = Hasher(s).realHash()