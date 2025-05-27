import java.util.*

class Solution {
    fun solution(n: Int, vertex: Array<IntArray>): Int {
        val graph = Array(n + 1) { mutableListOf<Int>() }
        for ((a, b) in vertex) {
            graph[a].add(b)
            graph[b].add(a)
        }

        val distance = IntArray(n + 1) { -1 }

        val queue: Queue<Int> = LinkedList()
        queue.add(1) 
        distance[1] = 0 

        while (queue.isNotEmpty()) {
            val current = queue.poll()
            for (neighbor in graph[current]) {
                if (distance[neighbor] == -1) {
                    distance[neighbor] = distance[current] + 1
                    queue.add(neighbor)
                }
            }
        }

        val maxDistance = distance.maxOrNull()!!

        return distance.count { it == maxDistance }
    }  
}