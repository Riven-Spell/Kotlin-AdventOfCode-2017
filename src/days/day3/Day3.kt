package days.day3

import kotlin.math.*

fun day3p1(s: String) : String {
    val x = s.toInt()
    val upper = (1..x step 2).first { it * it >= x }
    val xdist = abs((x % upper) - ((upper / 2) + 1)) - if(sqrt(x.toFloat()).toInt().toFloat().pow(2).toInt() == x) 1 else 0
    val ydist = upper / 2
    return (xdist + ydist).toString()
}

typealias point2D = Pair<Int,Int>

operator fun point2D.plus(p: point2D): point2D = point2D(this.first + p.first, this.second + p.second)
operator fun point2D.minus(p: point2D): point2D = point2D(this.first - p.first, this.second - p.second)

operator fun List<point2D>.plus(p: point2D): List<point2D> = this.map { it + p }
operator fun List<point2D>.minus(p: point2D): List<point2D> = this.map { it - p }

infix fun Int.pow(x: Int): Int = this.toFloat().pow(x).toInt()

fun List<Int>.extend(n: Int): List<Int> = this + (1..n).map { this.last() }

typealias Memblock = HashMap<point2D, Int>

fun Memblock.around(p: point2D): Int = (-1..1).map { x -> (-1..1).map { y -> point2D(x,y) } }.map { b -> b.filter { it != point2D(0,0) } }.map { it + p }.map { b -> b.map { this[it] ?: 0 }.sum() }.sum()
fun Memblock.getZero(p: point2D): Int = this[p] ?: 0

fun day3p2(s: String) : String {
    val moves = listOf(point2D(0,1), point2D(-1,0), point2D(0,-1), point2D(1,0))
    var croot = 3
    var cursor = point2D(1,0)
    var mblck = Memblock()
    mblck[point2D(0,0)] = 1
    mblck[point2D(1,0)] = 1
    var max = s.toInt()

    //(1..((croot pow 2) - ((croot - 2) pow 2))).map { it - 1 }.map { it / (croot - 1) }.drop(1).extend(1).map { moves [it] } -- one liner to snake around
    while (true) {
        (1..((croot pow 2) - ((croot - 2) pow 2))).map { it - 1 }.map { it / (croot - 1) }.drop(1).extend(1).map { moves[it] }.map { cursor += it; cursor }.forEachIndexed { i, pos ->
            mblck[pos] = mblck.around(pos)
            if (mblck.getZero(pos) > max) {
                val ntimes = i + ((croot - 2) pow 2)
                println("found result after $ntimes iterations")
                return mblck.getZero(pos).toString()
            }
        }
        croot += 2
    }
}