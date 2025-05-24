package week3

import java.util.PriorityQueue

fun solution(n: Int, edge: Array<IntArray>): Int {
    val graph = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }

    edge.forEach { (start, end) ->
        graph[start].add(end to 1)
        graph[end].add(start to 1)
    }

    val dist = Array(n + 1) { Int.MAX_VALUE }.apply { this[1] = 0 }
    val pQueue = PriorityQueue<Pair<Int, Int>>(compareBy { it.second }).apply { add(1 to 0) }

    while (pQueue.isNotEmpty()) {
        val (currentNode, currentDist) = pQueue.poll()

        if (dist[currentNode] < currentDist) continue

        graph[currentNode].forEach {
            val nextNode = it.first
            val nextDist = currentDist + it.second

            if(nextDist < dist[nextNode]) {
                dist[nextNode] = nextDist
                pQueue.add(Pair(nextNode, nextDist))
            }
        }
    }

    return dist.count { it == dist.drop(1).maxOf { it } }
}
