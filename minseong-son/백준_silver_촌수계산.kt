import java.util.LinkedList

val br = System.`in`.bufferedReader()

//graph = 인접노드 리스트, visited = 방문 체크용 - 중복방지
fun bfs(start: Int, graph: Array<MutableList<Int>>, visited: Array<Boolean>, target : Int) : Int {
    val q = LinkedList<Pair<Int, Int>>()
    q.add(Pair(start, 0))
    visited[start] = true


    while (q.isNotEmpty()) {
        val (head, depth) = q.poll()
        if (head == target) return depth

        for (next in graph[head]) {
            if (!visited[next]) {
                visited[next] = true
                q.add(Pair(next, depth + 1))
            }
        }
    }

    return -1
}

fun main() {
    val n = br.readLine().toInt()
    val (a,b) = br.readLine().split(" ").map { it.toInt() }
    val m = br.readLine().toInt()

    val graph = Array(n + 1) { mutableListOf<Int>() }
    val visited = Array(n + 1) { false }

    repeat(m) {
        val (x,y) = br.readLine().split(" ").map { it.toInt() }

        graph[x].add(y)
        graph[y].add(x)
    }

    val answer = bfs(a, graph, visited, b)
    println(answer)
}