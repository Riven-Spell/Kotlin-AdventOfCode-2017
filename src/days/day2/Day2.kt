package days.day2

fun day2p1(s: String) : String {
    val lines = s.split("\n")
    return (1..lines.size).mapIndexed {i,_ -> lineSum(lines[i]) }.sum().toString()
}

fun day2p2(s: String) : String {
    val lines = s.split("\n")
    return (1..lines.size).mapIndexed {i,_ -> lineSum2(lines[i]) }.sum().toString()
}

fun lineSum(s: String): Int {
    val lines = s.split(regex = Regex("\\s+")).map { it.toInt() }
    return lines.max()!! - lines.min()!!
}

fun lineSum2(s: String): Int {
    val lines = s.split(regex = Regex("\\s+")).map { it.toInt() }
    lines.forEach{n -> lines.forEach { if(n % it == 0 && it != n) return n / it }}
    return 0 //None of the inputs on AoC will ever trigger this, but kotlin wants it.
}