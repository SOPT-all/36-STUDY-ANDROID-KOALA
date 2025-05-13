package week3

import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val (start, end) = br.readLine().split(" ").map { it.toInt() }
    val m = br.readLine().toInt()

    val graph = Array(n + 1) { mutableListOf<Int>() }
    repeat(m) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        graph[a].add(b)
        graph[b].add(a)
    }

    val visited = BooleanArray(n + 1)
    val queue = ArrayDeque<Pair<Int, Int>>()
    queue.add(start to 0)
    visited[start] = true

    while (queue.isNotEmpty()) {
        val (current, depth) = queue.removeFirst()
        if (current == end) {
            println(depth)
            return
        }

        for (next in graph[current]) {
            if (!visited[next]) {
                visited[next] = true
                queue.add(next to depth + 1)
            }
        }
    }

    println(-1)
}

