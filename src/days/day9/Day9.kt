package days.day9

class StreamReader(s: String) {
    private val stream = s.toCharArray()

    fun Read(): Pair<Int,Int> {
        var score = 0
        var scope = 0
        var garbage = false
        var garbagechars = 0
        var i = 0
        while(i < stream.size) {
            if(garbage) {
                when(stream[i]) {
                    '!' -> i++
                    '>' -> garbage = false
                    else -> garbagechars++
                }
            } else {
                when(stream[i]) {
                    '{' -> scope++
                    '}' -> {score += scope; scope--}
                    '<' -> garbage = true
                }
            }
            i++
        }
        return Pair(score,garbagechars)
    }
}

fun day9p1(s: String): String {
    return StreamReader(s).Read().first.toString()
}

fun day9p2(s:String): String {
    return StreamReader(s).Read().second.toString()
}