package week3

import java.util.LinkedList
import java.util.Queue

fun main() {
    println(solution(6, arrayOf(intArrayOf(3, 6), intArrayOf(4, 3), intArrayOf(3, 2), intArrayOf(1, 3), intArrayOf(1, 2), intArrayOf(2, 4), intArrayOf(5, 2))))
}

fun solution(n: Int, vertex: Array<IntArray>): Int {
    val graph = Array(n + 1) { mutableListOf<Int>() }

    for ((a, b) in vertex) {
        graph[a].add(b)
        graph[b].add(a)
    }

    val distance = IntArray(n + 1) { -1 }
    val queue: Queue<Int> = LinkedList()

    distance[1] = 0
    queue.add(1)

    while (queue.isNotEmpty()) {
        val current = queue.poll()
        for (next in graph[current]) {
            if (distance[next] == -1) {
                distance[next] = distance[current] + 1
                queue.add(next)
            }
        }
    }

    val maxDistance = distance.maxOrNull()!!
    return distance.count { it == maxDistance }
}