package days.day11

import days.day3.*
import kotlin.math.abs
import kotlin.math.max

fun distfromzero(p2d: point2D): Int {
    val dx = p2d.first - 0
    val dy = p2d.second - 0

    return if(dx.positive() == dy.positive())
        abs(dx + dy)
    else
        max(abs(dx), abs(dy))
}

fun Int.positive(): Boolean = this >= 0

fun day11p1(s: String): String {
    var childpos = point2D(0,0)
    s.split(",").forEach {
        childpos += when(it) {
            "n" ->  point2D(1,0)
            "nw" -> point2D(0,1)
            "ne" -> point2D(1,-1)
            "s" -> point2D(-1,0)
            "sw" -> point2D(-1,1)
            "se" -> point2D(0,-1)
            else -> point2D(0,0)
        }
    }
    //return (childpos.toList().map { abs(it) }.max()!! + if(abs(childpos.first) > 1 && childpos.second % 2 == 0) 1 else 0).toString()
    return distfromzero(childpos).toString()
}

fun day11p2(s: String): String {
    var childpos = point2D(0,0)
    var largestdist = 0
    s.split(",").forEach {
        childpos += when(it) {
            "n" ->  point2D(1,0)
            "nw" -> point2D(0,1)
            "ne" -> point2D(1,-1)
            "s" -> point2D(-1,0)
            "sw" -> point2D(-1,1)
            "se" -> point2D(0,-1)
            else -> point2D(0,0)
        }
        val dist = distfromzero(childpos)
        if(dist > largestdist) {
            largestdist = dist
        }
    }
    return largestdist.toString()
}