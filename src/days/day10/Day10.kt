package days.day10

var outputVal = 255

class Hasher(s: String) {
    private val sizes = s.split(regex = Regex(",\\s*")).map { it.toInt() }

    fun hash(): Int {
        var output = (0..outputVal).toMutableList()
        var pos = 0
        var skip = 0
        sizes.forEach {
            (0..(it - 1)).map { x -> x + pos }.map{ x -> output[x % output.size] }.reversed().forEachIndexed { i,v ->
                output[(pos+i) % output.size] = v
            }

            pos += it + skip
            skip++
        }
        return output[0] * output[1]
    }
}

fun day10p1(s: String): String = Hasher(s).hash().toString()