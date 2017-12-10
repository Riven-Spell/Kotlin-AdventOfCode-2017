package days.day3

import kotlin.math.*

fun day3p1(s: String) : String {
    val x = s.toInt()
    val upper = (1..x step 2).first { it * it >= x }
    val xdist = abs((x % upper) - ((upper / 2) + 1)) - if(sqrt(x.toFloat()).toInt().toFloat().pow(2).toInt() == x) 1 else 0
    val ydist = upper / 2
    println("$upper $xdist $ydist")
    return (xdist + ydist).toString()
}

typealias point2D = Pair<Int,Int>

operator fun point2D.plus(p: point2D): point2D = point2D(this.first + p.first, this.second + p.second)
operator fun point2D.minus(p: point2D): point2D = point2D(this.first - p.first, this.second - p.second)



infix fun Int.pow(x: Int): Int = this.toFloat().pow(x).toInt()

fun List<Int>.extend(n: Int): List<Int> = this + (1..n).map { this.last() }

fun day3p2(s: String) : String {
    val moves = listOf(point2D(0,1), point2D(-1,0), point2D(0,-1), point2D(1,0))
    var croot = 5
    var cursor = point2D(1,0)


    println((1..((croot pow 2) - ((croot - 2) pow 2))).map { it + 1 }.map { it / (croot - 1)}.drop(1).extend(1))

    return "not implemented"
}