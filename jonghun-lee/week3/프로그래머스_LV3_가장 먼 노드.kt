package week3

class Solution {
    fun solution(n: Int, edge: Array<IntArray>): Int {
        val graph = Array(n + 1) { mutableListOf<Int>() }
        edge.forEach { (a, b) ->
            graph[a] += b
            graph[b] += a
        }

        val distances = IntArray(n + 1) { -1 }
        val queue = ArrayDeque<Int>().apply {
            add(1)
            distances[1] = 0
        }

        while (queue.isNotEmpty()) {
            val current = queue.removeFirst()
            graph[current].forEach { next ->
                if (distances[next] == -1) {
                    distances[next] = distances[current] + 1
                    queue.add(next)
                }
            }
        }

        val max = distances.maxOrNull() ?: 0
        return distances.count { it == max }
    }
}
