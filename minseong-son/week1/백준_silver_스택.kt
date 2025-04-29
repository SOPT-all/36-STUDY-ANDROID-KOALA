import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val stack : Stack<Int> = Stack()
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()

    repeat(n) {
        val input = br.readLine().split(" ").map { it }

        when (input[0]) {
            "push" -> stack.push(input[1].toInt())
            "pop" -> bw.write("${stack.removeLastOrNull() ?: -1}\n")
            "size" -> bw.write("${stack.size}\n")
            "empty" -> bw.write("${if (stack.isEmpty()) 1 else 0}\n")
            "top" -> bw.write("${stack.lastOrNull() ?: -1}\n")
        }
    }

    bw.flush()
    bw.close()
}