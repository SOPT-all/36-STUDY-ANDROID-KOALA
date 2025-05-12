import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var n : Int = 0
var m : Int = 0
var v : Int = 0
var graph = Array(0) {Array(0) {0} }
var dvisit = Array(0){0}
var dfsAnswer = arrayListOf<Int>()
var bvisit = Array(0){0}
var bfsAnswer = arrayListOf<Int>()

fun DFS(x : Int) {
    dfsAnswer.add(x)
    dvisit[x] = 1

    for (i in 1..n) {
        if (dvisit[i] == 0 && graph[x][i] == 1) {
            DFS(i)
        }
    }
}

fun BFS(x : Int) {
    var q : Queue<Int> = LinkedList<Int>()
    q.offer(x)
    bfsAnswer.add(x)
    bvisit[x] = 1
    while (!q.isEmpty()) {
        var tmp = q.poll()
        for (j in 1..n) {
            if (bvisit[j] == 0 && graph[tmp][j] == 1) {
                q.offer(j)
                bfsAnswer.add(j)
                bvisit[j] = 1
            }
        }
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    val input = br.readLine().split(" ")
    n = input[0].toInt()
    m = input[1].toInt()
    v = input[2].toInt()

    graph = Array(n+1) {Array(n+1) {0} }

    dvisit = Array(n+1) {0}
    bvisit = Array(n+1) {0}

    for (i in 1..m) {
        val (a,b) = br.readLine().split(" ")
        graph[a.toInt()][b.toInt()] = 1
        graph[b.toInt()][a.toInt()] = 1

    }
    DFS(v)
    BFS(v)

    dfsAnswer.joinToString(" ","","").forEach {
        sb.append(it)
    }
    println(sb)
    sb.clear()
    bfsAnswer.joinToString(" ","","").forEach {
        sb.append(it)
    }
    print(sb)
}