package week3

import java.util.LinkedList

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (R, C) = br.readLine().split(" ").map { it.toInt() }
    val maze = Array(R) { br.readLine().toCharArray() }
    var start = Pair(0, 0)
    val fire = LinkedList<Pair<Int, Int>>()

    for (i in maze.indices) {
        for (j in maze[0].indices) {
            if (maze[i][j] == 'J') {
                start = Pair(i, j)
                maze[i][j] = '.'
            }
            if (maze[i][j] == 'F') fire.offer(Pair(i, j))
        }
    }
    write(maze.bfs(start, fire))
    close()
}

fun Array<CharArray>.bfs(start: Pair<Int, Int>, fire: LinkedList<Pair<Int, Int>>): String {
    val directions = arrayOf(Pair(1, 0), Pair(0, -1), Pair(-1, 0), Pair(0, 1))
    val queue = LinkedList<Pair<Pair<Int, Int>, Int>>().apply { offer(Pair(start, 1))}
    val visited = Array(this.size) { BooleanArray(this[0].size) }.apply { this[start.first][start.second] = true }

    while (queue.isNotEmpty()) {
        repeat(fire.size) { // 불은 동시에 번짐 (지훈이의 1번의 이동)
            val (x, y) = fire.poll()

            for (i in directions.indices) { // 4방향에 대해 불이 번짐
                val dx = x + directions[i].first
                val dy = y + directions[i].second

                if (dx in this.indices && dy in this[0].indices && this[dx][dy] == '.') {
                    this[dx][dy] = 'F'
                    fire.offer(Pair(dx, dy))
                }
            }
        }
        repeat(queue.size) {
            val (coordinate, time) = queue.poll()

            if (coordinate.first == 0 || coordinate.first == this.size - 1 || coordinate.second == 0 || coordinate.second == this[0].size - 1) return "$time"

            for (i in directions.indices) {
                val dx = coordinate.first + directions[i].first
                val dy = coordinate.second + directions[i].second

                if (dx in this.indices && dy in this[0].indices && this[dx][dy] == '.' && !visited[dx][dy]) {
                    visited[dx][dy] = true
                    queue.offer(Pair(Pair(dx, dy), time + 1))
                }
            }
        }
    }
    return "IMPOSSIBLE"
}
