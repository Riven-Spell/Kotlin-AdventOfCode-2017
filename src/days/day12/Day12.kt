package days.day12

fun day12p1(s: String): String {
    return progTree(s.split("\n").map { it.split("<-> ")[1].split(regex=Regex(",\\s+")).map { n -> n.toInt() } }, 0).toString()
}

fun day12p2(s: String): String {
    val proglist: List<List<Int>> = s.split("\n").map { it.split("<-> ")[1].split(regex=Regex(",\\s+")).map { n -> n.toInt() } }
    var groups: Int = 0
    while(true) {
        progTree(proglist, proglist.mapIndexed{i,_ -> i}.find { !explored.contains(it) } ?: break)
        groups++
    }
    return groups.toString()
}

//Find all that connects to this.
var explored: List<Int> = listOf()
fun progTree(programs: List<List<Int>>, prog: Int): Int {
    if(!explored.contains(prog)) explored += prog
    programs[prog].filter { !explored.contains(it) }.map { explored += it; it }.map { progTree(programs, it) }
    return explored.size
}