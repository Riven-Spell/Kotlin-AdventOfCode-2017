package tests

import kotlin.system.measureTimeMillis

fun Test(indice: Int) {
    println("Testing Day ${((indice) % 2) + 1} Task ${(indice % 2) + 1}")
    if(days.List.size > indice && indice >= 0) {
        val func = days.List[indice]
        val tests = days.Tests[indice]
        val answers = days.Answers[indice]
        for ((i, v) in tests.withIndex()) {
            var s = false
            var o = ""
            val ms = measureTimeMillis {
                o = func(v)
                s = o == answers[i]
            }
            if (s) {
                println("Succeeded test $i in $ms ms with correct response $o")
            } else {
                println("Failed test $i in $ms ms with incorrect response $o, expecting ${answers[i]}")
                return
            }
        }
    } else {
        println("Day ${((indice) % 2) + 1} Task ${(indice % 2) + 1} has not been programmed.")
    }
}

fun TestAll() {
    for(i in days.List.indices) {
        Test(i)
    }
}