package week4

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

lateinit var graph : Array<MutableList<Int>>
lateinit var visited: BooleanArray


fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    val m = br.readLine().toInt()
    visited = BooleanArray(n+1)
    graph = Array(n+1){ mutableListOf() }

    repeat(m){
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        graph[a].add(b)
        graph[b].add(a)
    }

    val stack = ArrayDeque<Int>()
    var count = 0

    stack.addLast(1)
    visited[1] = true

    while (stack.isNotEmpty()) {
        val current = stack.removeLast()

        for (node in graph[current].reversed()) {
            if (!visited[node]) {
                visited[node] = true
                count+=1
                stack.addLast(node)
            }
        }
    }
    bw.write("${count}")
    bw.flush()
}

