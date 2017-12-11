package days.day6

import kotlin.math.abs

fun day6p1(s: String): String {
    var blocks = s.split(regex = Regex("\\s+")).map { it.toInt() }.toMutableList()
    var seenBefore = HashSet<List<Int>>()
    while(seenBefore.add(blocks)) {
        val max = blocks.max()!!
        val maxIndex = blocks.indexOf(max)
        blocks[maxIndex] = 0
        (1..max).forEach { i -> blocks[(maxIndex + i) % blocks.size]++}
    }
    return seenBefore.size.toString()
}

fun day6p2(s: String): String {
    var blocks = s.split(regex = Regex("\\s+")).map { it.toInt() }.toMutableList()
    var seenBefore = HashMap<List<Int>, Int>()
    while(!seenBefore.containsKey(blocks)) {
        seenBefore.put(blocks, seenBefore.size)
        val max = blocks.max()!!
        val maxIndex = blocks.indexOf(max)
        blocks[maxIndex] = 0
        (1..max).forEach { i -> blocks[(maxIndex + i) % blocks.size]++}
    }
    return abs(seenBefore.size - seenBefore[blocks]!!).toString()
}