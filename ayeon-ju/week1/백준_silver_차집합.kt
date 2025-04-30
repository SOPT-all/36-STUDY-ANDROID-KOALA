package Koala.Week1


fun main() = with(System.`in`.bufferedReader()) {

    val (nA, nB) = readLine().split(" ").map { it.toInt() }


    val a = readLine().split(" ").map { it.toInt() }.toSet()
    val b = readLine().split(" ").map { it.toInt() }.toSet()

    val result = (a - b).sorted()


    println(result.size)
    if (result.isNotEmpty()) {
        println(result.joinToString(" "))
    }
    
}

