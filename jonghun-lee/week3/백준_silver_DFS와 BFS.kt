package week3

import java.io.BufferedReader
import java.io.InputStreamReader
lateinit var graph: Array<MutableList<Int>>
lateinit var visited: BooleanArray

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m, v) = br.readLine().split(" ").map { it.toInt() }

    graph = Array(n + 1) { mutableListOf() }

    repeat(m) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        graph[a].add(b)
        graph[b].add(a)
    }

    for (i in 1..n) {
        graph[i].sort()
    }

    visited = BooleanArray(n + 1)
    dfs(v)
    println()

    visited = BooleanArray(n + 1)
    bfs(v)
    println()
}

fun dfs(start: Int) {
    val stack = ArrayDeque<Int>()
    stack.addLast(start)
    visited[start] = true
    print("$start ")

    while (stack.isNotEmpty()) {
        val current = stack.last()
        var foundNext = false

        for (next in graph[current]) {
            if (!visited[next]) {
                visited[next] = true
                stack.addLast(next)
                print("$next ")
                foundNext = true
                break
            }
        }

        if (!foundNext) {
            stack.removeLast()
        }
    }
}

fun bfs(start: Int) {
    val queue = ArrayDeque<Int>()
    queue.addLast(start)
    visited[start] = true

    while (queue.isNotEmpty()) {
        val current = queue.removeFirst()
        print("$current ")

        for (next in graph[current]) {
            if (!visited[next]) {
                visited[next] = true
                queue.addLast(next)
            }
        }
    }
}
