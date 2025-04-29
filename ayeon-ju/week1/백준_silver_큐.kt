package Koala.Week1

import java.util.LinkedList
import java.util.Queue

fun main() = with(System.`in`.bufferedReader()) {

    val queue : Queue<Int?> = LinkedList()
    val num = readLine().toInt()
    val output = StringBuilder()

    for (i in 1..num) {

        val tmp = readLine().split(" ")

        when(tmp[0]) {
            "push" -> {
                queue.add(tmp[1].toInt())
            }

            "pop" -> {
                if (queue.isNotEmpty()) output.appendLine(queue.poll())
                else output.appendLine("-1")
            }

            "size" -> {
                output.appendLine(queue.size)
            }

            "empty" -> {
                if (queue.isEmpty()) output.appendLine("1")
                else output.appendLine("0")
            }

            "front" -> {
                if (queue.isNotEmpty()) output.appendLine(queue.peek())
                else output.appendLine("-1")
            }

            "back" -> {
                if (queue.isNotEmpty()) output.appendLine((queue as LinkedList).peekLast())
                else output.appendLine("-1")
            }
        }

    }

    print(output)

}
