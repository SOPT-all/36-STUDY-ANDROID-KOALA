import java.util.*

fun main() {

    val br = System.`in`.bufferedReader()

    val n = br.readLine().toInt()  // 컴퓨터 수
    val m = br.readLine().toInt()  // 연결된 쌍 수

    val graph = Array(n+1){mutableListOf<Int>()}
    val visited = BooleanArray(n+1)

    repeat(m) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        graph[a].add(b)
        graph[b].add(a)
    }

    val queue: Queue<Int> = LinkedList()
    var infectedCount = 0

    queue.add(1)
    visited[1] = true

    while(queue.isNotEmpty()){
        val current = queue.poll()

        for (neighbor in graph[current]){
            if(!visited[neighbor]){
                visited[neighbor] = true
                infectedCount++
                queue.add(neighbor)
            }
        }
    }

    println(infectedCount)
    
}