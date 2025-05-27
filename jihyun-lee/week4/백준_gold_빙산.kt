import java.util.*

data class Point(val x: Int, val y: Int)

val dx = listOf(-1, 1, 0, 0)
val dy = listOf(0, 0, -1, 1)

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    var board = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    var year = 0

    fun bfs(startX: Int, startY: Int, visited: Array<BooleanArray>) {
        val queue: Queue<Point> = LinkedList()
        queue.add(Point(startX, startY))
        visited[startX][startY] = true

        while (queue.isNotEmpty()) {
            val (x, y) = queue.poll()
            for (d in 0..3) {
                val nx = x + dx[d]
                val ny = y + dy[d]
                if (nx in 0 until n && ny in 0 until m && board[nx][ny] > 0 && !visited[nx][ny]) {
                    visited[nx][ny] = true
                    queue.add(Point(nx, ny))
                }
            }
        }
    }

    while (true) {
        // 1. 빙산 덩어리 개수 확인
        val visited = Array(n) { BooleanArray(m) }
        var count = 0

        for (i in 0 until n) {
            for (j in 0 until m) {
                if (board[i][j] > 0 && !visited[i][j]) {
                    bfs(i, j, visited)
                    count++
                }
            }
        }

        if (count >= 2) {
            println(year)
            return
        }

        if (count == 0) {
            println(0)
            return
        }

        // 2. 빙산 녹이기
        val melt = Array(n) { IntArray(m) }
        for (i in 0 until n) {
            for (j in 0 until m) {
                if (board[i][j] > 0) {
                    var water = 0
                    for (d in 0..3) {
                        val ni = i + dx[d]
                        val nj = j + dy[d]
                        if (ni in 0 until n && nj in 0 until m && board[ni][nj] == 0) {
                            water++
                        }
                    }
                    melt[i][j] = water
                }
            }
        }

        for (i in 0 until n) {
            for (j in 0 until m) {
                board[i][j] = maxOf(0, board[i][j] - melt[i][j])
            }
        }

        year++
    }
}