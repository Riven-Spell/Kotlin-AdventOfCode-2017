import tests.*
import kotlin.system.measureTimeMillis

fun main(Args: Array<String>) {
    try {
        val execType = Args[0]

        //Calculate list indice.
        try {
            println("What day_task?")
            val dt = readLine()!!.split("_").map{v -> v.toInt()}
            if((1..2).contains(dt[1])) {
                val indice = ((dt[0] - 1) * 2) + (dt[1] - 1)
                if (execType == "test") {
                    val ms = measureTimeMillis {
                        Test(indice)
                    }
                    println("Tests completed in $ms ms")
                } else {
                    val input = inputs.GetInput(dt[0])
                    if (days.list.size > indice && indice >= 0) {
                        val ms = measureTimeMillis {
                            println("Got result ${days.list[indice](input)}")
                        }
                        println("took $ms ms executing!")
                    } else {
                        println("Day ${((indice) % 2) + 1} Task ${(indice % 2) + 1} has not been programmed.")
                    }
                }
            } else {
                println("${dt[0]}_${dt[1]} is an invalid day_task!")
            }
        } catch (Ex: Exception) {
            Ex.printStackTrace()
        }
    } catch(Ex: Exception) {
        //Testing ALL.
        println("Testing all tasks.")
        val ms = measureTimeMillis {
            TestAll()
        }
        println("Did all tests in $ms ms")
    }
}