package week1

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.Stack
import java.util.StringTokenizer

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    val stack = Stack<Int>()

    repeat(bufferedReader.readLine().toInt()) {
        val str = StringTokenizer(bufferedReader.readLine())
        when (str.nextToken()) {
            "push" -> stack.push(str.nextToken().toInt())
            "pop" -> bufferedWriter.write(
                (if (stack.isEmpty()) -1 else stack.pop()).toString() + "\n"
            )

            "size" -> bufferedWriter.write(
                stack.size.toString() + "\n"
            )

            "empty" -> bufferedWriter.write(
                (if (stack.isEmpty()) 1 else 0).toString() + "\n"
            )

            "top" -> bufferedWriter.write(
                (if (stack.isEmpty()) -1 else stack.peek()).toString() + "\n"
            )
        }
    }
    bufferedReader.close()
    bufferedWriter.flush()
}