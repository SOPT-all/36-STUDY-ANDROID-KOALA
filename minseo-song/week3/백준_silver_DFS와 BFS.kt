package week3

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    val st = StringTokenizer(bufferedReader.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val t = st.nextToken().toInt()

    val graph = Array(n + 1) { IntArray(n + 1) }

    repeat(m) {
        val edge = StringTokenizer(bufferedReader.readLine())
        val a = edge.nextToken().toInt()
        val b = edge.nextToken().toInt()

        graph[a][b] = 1
        graph[b][a] = 1
    }

    fun dfs(graph: Array<IntArray>, visited: BooleanArray, v: Int, writer: BufferedWriter) {
        visited[v] = true
        writer.write("$v ")

        for (i in 1 until graph.size) {
            if (!visited[i] && graph[v][i] == 1) {
                dfs(graph, visited, i, writer)
            }
        }
    }

    fun bfs(graph: Array<IntArray>, visited: BooleanArray, start: Int, writer: BufferedWriter) {
        val queue: Queue<Int> = LinkedList()
        queue.add(start)
        visited[start] = true

        while (queue.isNotEmpty()) {
            val v = queue.poll()
            writer.write("$v ")

            for (i in 1 until graph.size) {
                if (!visited[i] && graph[v][i] == 1) {
                    queue.add(i)
                    visited[i] = true
                }
            }
        }
    }

    val visitedDfs = BooleanArray(n+1)
    dfs(graph, visitedDfs, t, bufferedWriter)
    bufferedWriter.write("\n")

    val visitedBfs = BooleanArray(n+1)
    bfs(graph, visitedBfs, t, bufferedWriter)
    bufferedWriter.close()
}