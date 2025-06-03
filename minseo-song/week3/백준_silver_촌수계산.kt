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

    val n = StringTokenizer(bufferedReader.readLine()).nextToken().toInt()

    val st = StringTokenizer(bufferedReader.readLine())
    val a = st.nextToken().toInt()
    val b = st.nextToken().toInt()

    val m = StringTokenizer(bufferedReader.readLine()).nextToken().toInt()

    val graph = Array(n + 1) { mutableListOf<Int>() }

    repeat(m) {
        val edge = StringTokenizer(bufferedReader.readLine())
        val x = edge.nextToken().toInt()
        val y = edge.nextToken().toInt()

        graph[x].add(y)
        graph[y].add(x)
    }

    val visited = BooleanArray(n + 1)
    val queue: Queue<Pair<Int, Int>> = LinkedList()

    queue.add(Pair(a, 0))
    visited[a] = true

    var result = -1

    while (queue.isNotEmpty()){
        val (current, count) = queue.poll()

        if (current == b){
            result = count
            break
        }

        for (next in graph[current]){
            if (!visited[next]){
                visited[next] = true
                queue.add(Pair(next, count + 1))
            }
        }
    }

    bufferedWriter.write("$result")
    bufferedWriter.close()
}