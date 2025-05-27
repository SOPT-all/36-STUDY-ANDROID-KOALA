import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var computer_num = 0
var computer_connect = 0
var graph = Array(0) {Array(0){0} }
var visit = Array(0) {0}
var cnt = 0

fun BFS(x : Int) {
    val q : Queue<Int> = LinkedList()
    q.offer(x)
    visit[x] = 1

    while (!q.isEmpty()) {
        for (i in 0 until q.size) {
            val temp = q.poll()
            for (j in 1..computer_num) {
                if (graph[temp][j] == 1 && visit[j] == 0) {
                    visit[j] = 1
                    q.offer(j)
                    cnt++
                }
            }
        }
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    computer_num = br.readLine().toInt()
    computer_connect = br.readLine().toInt()
    graph = Array(computer_num+1){Array(computer_num+1){0} }
    visit = Array(computer_num+1){0}

    for (i in 1..computer_connect) {
        val (a,b) = br.readLine().split(" ").map { it.toInt() }

        //양방
        graph[a][b] = 1
        graph[b][a] = 1
    }
    BFS(1)
    print(cnt)
}