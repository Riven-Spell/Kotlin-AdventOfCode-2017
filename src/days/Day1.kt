package days

fun Day1_1(s: String): String {
    val inputs = s.split("").filter{!it.isEmpty()}.map { it.toInt() }
    return inputs.filterIndexed { i, v -> inputs[(i + 1) % inputs.size] == v}.sumBy{ it }.toString()
}

fun Day1_2(s: String): String {
    val inputs = s.split("").filter{!it.isEmpty()}.map { it.toInt() }
    return inputs.filterIndexed { i, v -> inputs[(i + (inputs.size / 2)) % inputs.size] == v}.sumBy{ it }.toString()
}