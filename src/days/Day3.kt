package days

import kotlin.math.*

fun Day3_1(s: String) : String {
    val x = s.toFloat()
    var csqrt = sqrt(x).toInt()
    csqrt -= if(csqrt % 2 == 0) 1 else 0 // Find closest last root
    val side = if(x.toInt() == csqrt) (csqrt + 2) / 2 else 0
    val distx = abs((x % (csqrt + 2)) - side)
    val disty = csqrt / 2
    return (distx + disty).toInt().toString()
}

fun Perim(root: Int) : Int = (root * 2) + ((root - 2) * 2)