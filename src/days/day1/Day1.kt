package days.day1

fun day1p1(s: String): String {
    val inputs = s.split("").filter{!it.isEmpty()}.map { it.toInt() }
    return inputs.filterIndexed { i, v -> inputs[(i + 1) % inputs.size] == v}.sum().toString()
}

fun day1p2(s: String): String {
    val inputs = s.split("").filter{!it.isEmpty()}.map { it.toInt() }
    return inputs.filterIndexed { i, v -> inputs[(i + (inputs.size / 2)) % inputs.size] == v}.sum().toString()
}