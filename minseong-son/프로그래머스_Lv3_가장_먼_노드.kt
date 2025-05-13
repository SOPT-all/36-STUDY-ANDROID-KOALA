import java.util.LinkedList

class Solution {
    val br = System.`in`.bufferedReader()

    fun bfs(start: Int, graph: Array<MutableList<Int>>, visited: Array<Boolean>) : Int {
        val q = LinkedList<Pair<Int, Int>>()
        q.add(Pair(start, 0))
        visited[start] = true
        var maximum = -1
        val depthList = mutableListOf<Int>()

        while (q.isNotEmpty()) {
            val (head, depth) = q.poll()
            depthList.add(depth)
            maximum = maxOf(maximum, depth)

            for (next in graph[head]) {
                if (!visited[next]) {
                    visited[next] = true
                    q.add(Pair(next, depth + 1))

                }
            }


        }

        return depthList.count { it == maximum }
    }

    fun solution(n: Int, edge: Array<IntArray>): Int {
        val graph = Array(n + 1) { mutableListOf<Int>() }
        val visited = Array(n + 1) { false }

        for ((x, y) in edge) {
            graph[x].add(y)
            graph[y].add(x)
        }

        val answer = bfs(1, graph, visited)
        return answer
    }
}