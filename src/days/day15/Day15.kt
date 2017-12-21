package days.day15

fun day15p1(s: String): String {
    val remove = Regex("Generator [AB] starts with ")
    val afac = 16807
    val bfac = 48271
    var gens = s.split("\n").map { remove.replace(it, "") }.map { it.toLong() }.toMutableList()
    var out = 0
    for(i in 0..40_000_000) {
        gens[0] = (gens[0] * afac) % 2147483647
        gens[1] = (gens[1] * bfac) % 2147483647

        if((gens[0] and 0x0000FFFF) == (gens[1] and 0x0000FFFF)) {
            out++
        }
    }
    return out.toString()
}

fun day15p2(s: String): String {
    val remove = Regex("Generator [AB] starts with ")
    val afac = 16807
    val bfac = 48271
    var gens = s.split("\n").map { remove.replace(it, "") }.map { it.toLong() }.toMutableList()
    var out = 0
    for(i in 0..5000000) {
        gens[0] = (gens[0] * afac) % 2147483647
        while(gens[0] % 4 != 0.toLong()) {
            gens[0] = (gens[0] * afac) % 2147483647
        }

        gens[1] = (gens[1] * bfac) % 2147483647
        while(gens[1] % 8 != 0.toLong()) {
            gens[1] = (gens[1] * bfac) % 2147483647
        }

        if((gens[0] and 0xFFFF) == (gens[1] and 0xFFFF))
            out++
    }
    return out.toString()
}