package week3

import java.util.LinkedList

private val br = System.`in`.bufferedReader()
private var route = ""

fun main() = with(System.out.bufferedWriter()) {
    val (N, M, V) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(N + 1) { IntArray(N + 1) }
    val visited = BooleanArray(N + 1) { false }
    route += "$V "

    repeat(M) {
        val (start, end) = br.readLine().split(" ").map { it.toInt() }
        graph[start][end] = 1
        graph[end][start] = 1
    }
    dfs(V, graph, visited)
    write("${route}\n")
    write("${bfs(V, graph)}")
    close()
}

fun dfs(index: Int, graph: Array<IntArray>, visited: BooleanArray) {
    visited[index] = true

    for (i in graph.indices) {
        if (graph[index][i] == 1 && !visited[i]) {
            route += "$i "
            dfs(i, graph, visited)
        }
    }
}

fun bfs(index: Int, graph: Array<IntArray>): String {
    val visited = BooleanArray(graph.size + 1) { false }
    val queue = LinkedList<Int>()
    var route = ""

    visited[index] = true
    queue.add(index)

    while (queue.isNotEmpty()) {
        val current = queue.poll()
        route += "$current "

        for (i in 1 until graph.size) {
            if(!visited[i] && graph[current][i] == 1) {
                visited[i] = true
                queue.add(i)
            }
        }
    }

    return route
}
