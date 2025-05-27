package week4

import java.util.LinkedList

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val computers = br.readLine().toInt()
    val graph = Array(computers + 1) { IntArray(computers + 1) }
    val visited = BooleanArray(computers + 1).apply { this[1] = true }
    repeat(br.readLine().toInt()) {
        val (from, to) = br.readLine().split(" ").map { it.toInt() }
        graph[from][to] = 1
        graph[to][from] = 1
    }
    write("${dfs(graph, visited)}")
    close()
}

fun dfs(graph: Array<IntArray>, visited: BooleanArray): Int {
    val stack = LinkedList<Int>().apply { push(1) }
    var count = 0

    while (stack.isNotEmpty()) {
        val cur = stack.pop()
        for (i in graph[cur].indices) {
            if (graph[cur][i] == 1 && !visited[i]) {
                visited[i] = true
                stack.push(i)
                count++
            }
        }
    }
    return count
}
