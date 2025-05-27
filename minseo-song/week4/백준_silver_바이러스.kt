package week4

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    val n = bufferedReader.readLine().toInt()
    val m = bufferedReader.readLine().toInt()

    val graph = Array(n + 1) { mutableListOf<Int>() }
    val visited = BooleanArray(n + 1)

    repeat(m) {
        val edge = StringTokenizer(bufferedReader.readLine())
        val x = edge.nextToken().toInt()
        val y = edge.nextToken().toInt()

        graph[x].add(y)
        graph[y].add(x)
    }

    var count = 0

    fun dfs(node: Int){
        visited[node] = true
        for (next in graph[node]){
            if (!visited[next]){
                count++
                dfs(next)
            }
        }
    }

    dfs(1)

    bufferedWriter.write(count.toString())
    bufferedWriter.close()
}