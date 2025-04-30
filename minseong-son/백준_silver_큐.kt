import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val sb = StringBuilder()

    val br = BufferedReader(InputStreamReader(System.`in`))

    val q: Queue<Int> = LinkedList()

    val n = br.readLine().toInt()

    repeat(n) {

        val input = br.readLine().split(" ")

        when (input[0]) {
            "push" -> {
                val num = input[1].toInt()
                q.offer(num)
            }

            "size" -> {
                sb.append("${q.size}\n")
            }

            "empty" -> {
                sb.append("${
                    if (q.isEmpty()) {
                        1
                    } else {
                        0
                    }
                }\n")
            }

            "front" -> {
                sb.append("${q.peek() ?: -1}\n")
            }

            "back" -> {
                sb.append("${q.lastOrNull() ?: -1}\n")
            }

            "pop" -> {
                val popped = q.poll()
                sb.append("${popped ?: -1}\n")
            }
        }
    }

    print(sb)
}