package days.day14

import days.day10.binaryKnotHash
import days.day3.plus

fun day14p1(s: String): String = (0..127).map { "$s-$it" }.map { binaryKnotHash(it).toCharArray() }.map { it.filter { it == '1' }.size }.sum().toString()

fun day14p2(s: String): String {
    (0..127).map { "$s-$it" }.map { binaryKnotHash(it).toCharArray() }.map{ it.withIndex().filter { it.value == '1' } }.withIndex().forEach {
        val y = it.index
        it.value.forEach {
            val x = it.index
            groups[Pair(x,y)] = 0
        }
    }
    var gnums = 0
    groups.keys.forEach { if(propGroups(it,gnums + 1)) gnums++ }
    return gnums.toString()
}

var groups: HashMap<Pair<Int,Int>, Int> = HashMap()
val outerpos = listOf(Pair(0,1),Pair(0,-1),Pair(1,0), Pair(-1,0))
fun propGroups(pos: Pair<Int,Int>, gn: Int): Boolean {
    groups[pos] ?: return false
    if (groups[pos] != 0)
        return false
    groups[pos] = gn
    outerpos.map { it + pos }.forEach { propGroups(it,gn) }
    return true
}