import java.util.*

fun main() {
    val n = readLine()!!.toInt()
    val (start, end) = readLine()!!.split(" ").map { it.toInt() }
    val m = readLine()!!.toInt()

    val graph = Array(n + 1) { mutableListOf<Int>() }

    repeat(m) {
        val (parent, child) = readLine()!!.split(" ").map { it.toInt() }
        graph[parent].add(child)
        graph[child].add(parent)
    }

    val visited = IntArray(n + 1) { -1 }

    val queue: Queue<Int> = LinkedList()

    queue.add(start)
    visited[start] = 0

    while (queue.isNotEmpty()) {
        val current = queue.poll()

        for (neighbor in graph[current]) {
            if (visited[neighbor] == -1) {
                visited[neighbor] = visited[current] + 1
                queue.add(neighbor)
            }
        }
    }

    println(visited[end])
}
