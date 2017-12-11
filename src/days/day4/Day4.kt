package days.day4

fun day4p1(s: String) : String {
    return s.split("\n").map { it.split(regex=Regex("\\s+")) }.filter { var phrases: HashSet<String> = HashSet(); !it.any { phrase -> !phrases.add(phrase) } }.size.toString()
}

fun day4p2(s: String) : String {
    return s.split("\n").map { it.split(regex=Regex("\\s+")).map { chars -> chars.toCharArray() }.map { chars -> chars.sort(); String(chars) } }.filter { var phrases: HashSet<String> = HashSet(); !it.any { phrase -> !phrases.add(phrase) } }.size.toString()
}