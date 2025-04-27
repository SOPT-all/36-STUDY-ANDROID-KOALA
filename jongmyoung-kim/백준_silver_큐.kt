import java.util.LinkedList

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val queue = LinkedList<Int>()
    repeat(br.readLine().toInt()) {
        val command = br.readLine()
        when {
            command.startsWith("pu") -> queue.offer(command.split(" ")[1].toInt())
            command[0] == 's' -> write("${queue.size}\n")
            command[0] == 'e' -> write("${if (queue.isEmpty()) 1 else 0}\n")
            command[0] == 'f' -> write("${if (queue.isNotEmpty()) queue.first() else -1}\n")
            command[0] == 'b' -> write("${if (queue.isNotEmpty()) queue.last() else -1}\n")
            else -> write("${if (queue.isNotEmpty()) queue.poll() else -1}\n")
        }
    }
    close()
}
