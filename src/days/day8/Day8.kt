package days.day8

class CPU(instructions: String) {
    var registry: HashMap<String, Int> = HashMap()
    var registryAllTimeHighest: Int = 0
    private var instSet: List<String> = instructions.split("\n")

    fun Exec() {
        instSet.map { it.split(regex=Regex("\\s+")) }.forEach { descmd ->
            if(RunCheck(descmd.drop(4))) {
                when(descmd[1]) {
                    //For some reason, plusAssign and minusAssign don't inline set with a config like this.
                    //This is a workaround. for a year old bug. in a programming language developed by a professional company. Thanks, JetBrains.
                    "inc" -> registry[descmd[0]] = registry.getOrPut(descmd[0],{0}) + descmd[2].toInt()
                    "dec" -> registry[descmd[0]] = registry.getOrPut(descmd[0],{0}) - descmd[2].toInt()
                }
            }
            if(registry.values.max()!! > registryAllTimeHighest)
                registryAllTimeHighest = registry.values.max()!!
        }
    }

    fun RunCheck(cmd: List<String>): Boolean {
        return when(cmd[1]) {
            ">" -> registry.getOrPut(cmd[0],{0}) > cmd[2].toInt()
            "<" -> registry.getOrPut(cmd[0],{0}) < cmd[2].toInt()
            ">=" -> registry.getOrPut(cmd[0],{0}) >= cmd[2].toInt()
            "<=" -> registry.getOrPut(cmd[0],{0}) <= cmd[2].toInt()
            "==" -> registry.getOrPut(cmd[0],{0}) == cmd[2].toInt()
            "!=" -> registry.getOrPut(cmd[0],{0}) != cmd[2].toInt()
            else -> false
        }
    }
}

fun day8p1(s: String): String {
    val cpu = CPU(s)
    cpu.Exec()
    return cpu.registry.values.max().toString()
}

fun day8p2(s: String): String {
    val cpu = CPU(s)
    cpu.Exec()
    return cpu.registryAllTimeHighest.toString()
}