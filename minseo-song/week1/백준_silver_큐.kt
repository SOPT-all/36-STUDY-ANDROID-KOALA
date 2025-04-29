package week1

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    val queue: Queue<Int> = LinkedList()

    repeat(bufferedReader.readLine().toInt()){
        val str = StringTokenizer(bufferedReader.readLine())
        when(str.nextToken()){
            "push" -> queue.add(str.nextToken().toInt())
            "pop" -> bufferedWriter.write(
                (if (queue.isEmpty()) -1 else queue.poll()).toString() + "\n"
            )
            "size" -> bufferedWriter.write(
                queue.size.toString() + "\n"
            )
            "empty" -> bufferedWriter.write(
                (if (queue.isEmpty()) 1 else 0).toString() + "\n"
            )
            "front" -> bufferedWriter.write(
                (if (queue.isEmpty()) -1 else queue.peek()).toString() + "\n"
            )
            "back" -> bufferedWriter.write(
                (if (queue.isEmpty()) -1 else queue.last()).toString() + "\n"
            )
        }
    }

    bufferedReader.close()
    bufferedWriter.flush()
}