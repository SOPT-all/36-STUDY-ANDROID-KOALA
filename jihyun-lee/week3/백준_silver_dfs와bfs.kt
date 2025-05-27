import java.util.*

fun main() {
    val (n, m, v) = readLine()!!.split(" ").map { it.toInt() } 
    val graph = Array(n + 1) { mutableListOf<Int>() } 

    repeat(m) {
        val (a, b) = readLine()!!.split(" ").map { it.toInt() }
        graph[a].add(b) 
        graph[b].add(a)
    }

    for (i in 1..n) {
        graph[i].sort()
    }

    val visitedDFS = BooleanArray(n + 1)
    dfs(v, graph, visitedDFS)
    println()
    
    val visitedBFS = BooleanArray(n + 1)
    bfs(v, graph, visitedBFS)
}

fun dfs(node: Int, graph: Array<MutableList<Int>>, visited: BooleanArray) {
    visited[node] = true
    print("$node ")

    for (next in graph[node]) {
        if (!visited[next]) {
            dfs(next, graph, visited)
        }
    }
}

fun bfs(start: Int, graph: Array<MutableList<Int>>, visited: BooleanArray) {
    val queue: Queue<Int> = LinkedList()
    queue.add(start)
    visited[start] = true

    while (queue.isNotEmpty()) {
        val node = queue.poll()
        print("$node ")

        for (next in graph[node]) {
            if (!visited[next]) {
                visited[next] = true
                queue.add(next)
            }
        }
    }
}
