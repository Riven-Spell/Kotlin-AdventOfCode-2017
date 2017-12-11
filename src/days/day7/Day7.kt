package days.day7

import kotlin.math.abs

data class Program(val Name: String, val Weight: Int, val Links: List<String>)

val nregex = Regex("[a-z]+")
val wregex = Regex("\\(\\d+\\)")
val weregex = Regex("\\d+")
val lregex = Regex("->")

fun day7p1(s: String) : String {
    var programs = HashMap<String,Program>()
    var linkbacks = HashMap<String,MutableList<String>>()

    return toBase(linkbacks, s.split("\n").map { prog ->
        val links: List<String> = if(lregex.containsMatchIn(prog)) nregex.findAll(lregex.split(prog)[1]).map{it.value}.toList() else listOf()
        val name: String = nregex.find(lregex.split(prog)[0])!!.value
        val weight: Int = weregex.find(wregex.find(prog)!!.value)!!.value.toInt()
        Program(name,weight,links)
    }.map { prog ->
        programs[prog.Name] = prog
        linkbacks[prog.Name] = mutableListOf()
        prog
    }.map { prog ->
        prog.Links.forEach { linked ->
            linkbacks[linked]!!.add(prog.Name)
        }
        prog.Name
    }.first())
}

fun Program.findTotalWeight(programs: HashMap<String,Program>): Int = this.Weight + this.Links.map { programs[it]!!.findTotalWeight(programs) }.sum()

data class WeightTree(val Name: String, val Weight:Int, val Subs:List<WeightTree>) {
    fun CorrectWeight(): Int {
        val wts = HashMap<Int,Int>()
        Subs.forEach {
            if(wts.contains(it.Weight)) {
                wts[it.Weight] = wts[it.Weight]!! + 1
            } else {
                wts[it.Weight] = 1
            }
        }
        return wts.keys.toList()[wts.values.indexOf(wts.values.max()!!)]
    }

    fun FindWrong(): WeightTree {
        val cWeight = CorrectWeight()
        val icw = Subs.find { it.Weight != cWeight }
        return if(icw == null) {
            this
        } else {
            icw.FindWrong()
        }
    }
}

fun Program.buildWeightTree(programs: HashMap<String,Program>): WeightTree {
    val w = this.findTotalWeight(programs)
    val sw = this.Links.map { programs[it]!!.buildWeightTree(programs) }
    return WeightTree(this.Name, w, sw)
}

fun day7p2(s: String) : String {
    var programs = HashMap<String,Program>()
    var linkbacks = HashMap<String,MutableList<String>>()

    val base = toBase(linkbacks, s.split("\n").map { prog ->
        val links: List<String> = if(lregex.containsMatchIn(prog)) nregex.findAll(lregex.split(prog)[1]).map{it.value}.toList() else listOf()
        val name: String = nregex.find(lregex.split(prog)[0])!!.value
        val weight: Int = weregex.find(wregex.find(prog)!!.value)!!.value.toInt()
        Program(name,weight,links)
    }.map { prog ->
        programs[prog.Name] = prog
        linkbacks[prog.Name] = mutableListOf()
        prog
    }.map { prog ->
        prog.Links.forEach { linked ->
            linkbacks[linked]!!.add(prog.Name)
        }
        prog.Name
    }.first())

    val bwt = programs[base]!!.buildWeightTree(programs)
    val iwt = bwt.FindWrong()
    val cwt = programs[linkbacks[iwt.Name]!![0]]!!.buildWeightTree(programs)

    return (programs[iwt.Name]!!.Weight - abs(iwt.Weight - cwt.CorrectWeight())).toString()
}


fun toBase(linkbacks: HashMap<String,MutableList<String>>, name:String): String = if(linkbacks[name]!!.isEmpty())
    name
else {
    linkbacks[name]!!.map { toBase(linkbacks, it) }.first()
}