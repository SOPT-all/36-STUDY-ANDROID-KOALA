package week1

import java.util.LinkedList

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val stack = LinkedList<Int>()
    repeat(br.readLine().toInt()) {
        val command = br.readLine()
        when {
            command.startsWith("pu") -> stack.push(command.split(" ")[1].toInt())
            command[0] == 's' -> write("${stack.size}\n")
            command[0] == 'e' -> write("${if (stack.isEmpty()) 1 else 0}\n")
            command[0] == 't' -> write("${if (stack.isNotEmpty()) stack[0] else -1}\n")
            else -> write("${if (stack.isNotEmpty()) stack.pop() else -1}\n")
        }
    }
    close()
}
