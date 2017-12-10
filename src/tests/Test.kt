package tests

import kotlin.system.measureTimeMillis

fun Test(indice: Int) {
    println("Testing Day ${((indice) / 2) + 1} Task ${(indice % 2) + 1}")
    if(days.list.size > indice && indice >= 0) {
        val func = days.list[indice]
        val tests = days.tests[indice]
        val answers = days.answers[indice]
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
            }
        }
    } else {
        println("Day ${((indice) % 2) + 1} Task ${(indice % 2) + 1} has not been programmed.")
    }
}

fun TestAll() {
    for(i in days.list.indices) {
        Test(i)
    }
}