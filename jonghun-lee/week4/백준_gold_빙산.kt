package week4

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

/*
덩어리 수를 나누는 과정에서 조금 오래 걸렸음.
토마토 처럼 큐 사이즈의 크기를 덩어리 수로 생각 하면 안됐음 ㅜ
처음 큐의 상하좌우를 탐색할 때 인접한 노드의 값이 있을 때 방문 처리만 한다면 같은 빙산 덩어리로 생각할 수 있음
*/

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)

    val (N, M) = br.readLine().split(" ").map { it.toInt() }

    val iceberg = Array(N) { IntArray(M) }
    repeat(N) { y ->
        val row = br.readLine().split(" ").map { it.toInt() }
        for (x in 0 until M) {
            iceberg[y][x] = row[x]
        }
    }

    val queue = LinkedList<IntArray>()
    var yearCount = 0

    while (true) {
        val visited = Array(N) { BooleanArray(M) }
        var chunkCount = 0

        for (y in 0 until N) {
            for (x in 0 until M) {
                if (iceberg[y][x] > 0 && !visited[y][x]) {
                    queue.offer(intArrayOf(y, x))
                    visited[y][x] = true
                    chunkCount += 1

                    while (queue.isNotEmpty()) {
                        val (cy, cx) = queue.poll()
                        for (i in 0 until 4) {
                            val ny = cy + dy[i]
                            val nx = cx + dx[i]

                            if (ny in 0 until N && nx in 0 until M && !visited[ny][nx] && iceberg[ny][nx] > 0) {
                                visited[ny][nx] = true
                                queue.offer(intArrayOf(ny, nx))
                            }
                        }
                    }
                }
            }
        }

        if (chunkCount >= 2) {
            println(yearCount)
            return
        }

        if (chunkCount == 0) {
            println(0)
            return
        }

        val melt = Array(N) { IntArray(M) }
        for (y in 0 until N) {
            for (x in 0 until M) {
                if (iceberg[y][x] > 0) {
                    for (i in 0 until 4) {
                        val ny = y + dy[i]
                        val nx = x + dx[i]
                        if (ny in 0 until N && nx in 0 until M && iceberg[ny][nx] == 0) {
                            melt[y][x]++
                        }
                    }
                }
            }
        }

        for (y in 0 until N) {
            for (x in 0 until M) {
                iceberg[y][x] = maxOf(0, iceberg[y][x] - melt[y][x])
            }
        }

        yearCount += 1
    }
}
