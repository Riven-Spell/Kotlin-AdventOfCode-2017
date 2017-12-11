package days.day5

fun day5p1(s: String): String {
    var jumps = s.split(regex=Regex("\\s+")).map { it.toInt() }.toMutableList()
    var stackptr = 0
    var it = 0
    while(stackptr < jumps.size) {
        jumps[stackptr]++
        stackptr += jumps[stackptr] - 1
        it++
    }
    return it.toString()
}

fun day5p2(s: String): String {
    var jumps = s.split(regex=Regex("\\s+")).map { it.toInt() }.toMutableList()
    var stackptr = 0
    var it = 0
    while(stackptr < jumps.size) {
        val manip = if(jumps[stackptr] >= 3) -1 else 1
        jumps[stackptr] += manip
        stackptr += jumps[stackptr] - manip
        it++
    }
    return it.toString()
}