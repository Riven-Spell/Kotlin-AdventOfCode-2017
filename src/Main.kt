import tests.*

fun main(Args: Array<String>) {
    try {
        val execType = Args[0]

        //Calculate list indice.
        try {
            println("What day_task?")
            val dt = readLine().toString().split("_").map{v -> v.toInt()}
            if((1..2).contains(dt[1])) {
                val indice = ((dt[0] - 1) * 2) + (dt[1] - 1)
                if (execType == "test")
                    Test(indice)
                else {
                    println("What is your input?")
                    val input = readLine().toString()
                    if (days.List.size > indice && indice >= 0) {
                        print(days.List[indice](input))
                    } else {
                        println("Day ${((indice) % 2) + 1} Task ${(indice % 2) + 1}1 has not been programmed.")
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
        TestAll()
    }
}