package Koala.Week1

fun main() = with(System.`in`.bufferedReader()) {

    val num = readLine().toInt()
    val output = StringBuilder()

    repeat(num) {
        val (a, b) = readLine().split(" ")
        output.appendLine(a.toInt() + b.toInt())
    }

    print(output)

}
