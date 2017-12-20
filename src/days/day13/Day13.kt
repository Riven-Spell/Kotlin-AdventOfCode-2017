package days.day13

fun day13p1(s: String): String = s.split("\n").map { it.split(": ") }.map { Pair(it[0].toInt(), it[1].toInt()) }.filter { it ->
    val i = it.first
    val ms = it.second - 1
    if((i / ms) % 2 == 0){ (i % ms) } else { ms - (i % ms) } == 0
}.map {
    it.first * it.second
}.sum().toString()

fun day13p2(s: String): String {
    var pause = 0
    val walls = s.split("\n").map { it.split(": ") }.map { Pair(it[0].toInt(), it[1].toInt()) }
    while (walls.any { it ->
        val i = it.first + pause
        val ms = it.second - 1
        if((i / ms) % 2 == 0){ (i % ms) } else { ms - (i % ms) } == 0
    }) {
        pause++
    }
    return pause.toString()
}