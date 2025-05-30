package week4

import java.util.LinkedList

private val br = System.`in`.bufferedReader()
private val directions = arrayOf(Pair(1, 0), Pair(0, -1), Pair(-1, 0), Pair(0, 1))

data class Iceberg(val x: Int, val y: Int, var weight: Int) // 빙산의 좌표, 높이, 주변 바다의 수

fun main() = with(System.out.bufferedWriter()) {
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val ocean = Array(N) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }
    val icebergs = mutableListOf<Iceberg>()
    var years = 0

    for (i in 0 until N) {
        for (j in 0 until M) {
            if (ocean[i][j] > 0) icebergs.add(Iceberg(i, j, ocean.checkWeight(i, j)))
        }
    }

    if (icebergs.isEmpty()) write("0")
    else {
        while (true) {
            var chunks = 0
            val remove = mutableListOf<Iceberg>()
            val visited = Array(N) { BooleanArray(M) }

            for (i in 0 until N) {
                for (j in 0 until M) {
                    if (ocean[i][j] > 0 && !visited[i][j]) {
                        chunks++
                        ocean.bfs(i, j, visited)
                    }
                }
            }

            if (chunks >= 2) {
                write("$years")
                break
            }
            if (ocean.all { it.all { it <= 0 } }) {
                write("0")
                break
            }

            repeat(icebergs.size) { // 전체적으로 빙산이 녹는 시점
                ocean[icebergs[it].x][icebergs[it].y] -= icebergs[it].weight
                if (ocean[icebergs[it].x][icebergs[it].y] <= 0) remove.add(icebergs[it])
            }
            icebergs.removeAll(remove)
            icebergs.forEach { it.weight = ocean.checkWeight(it.x, it.y) }
            years++
        }
    }
    close()
}

fun Array<IntArray>.checkWeight(x: Int, y: Int): Int {
    var weight = 0

    for (i in directions.indices) {
        val dx = x + directions[i].first
        val dy = y + directions[i].second

        if (dx in this.indices && dy in this[0].indices && this[dx][dy] <= 0) weight++
    }
    return weight
}

fun Array<IntArray>.bfs(x: Int, y: Int, visited: Array<BooleanArray>) {
    val queue = LinkedList<Pair<Int, Int>>().apply { offer(Pair(x, y)) }
    visited[x][y] = true

    while (queue.isNotEmpty()) {
        val cur = queue.poll()

        for (i in directions.indices) {
            val dx = cur.first + directions[i].first
            val dy = cur.second + directions[i].second

            if (dx in this.indices && dy in this[0].indices && !visited[dx][dy] && this[dx][dy] > 0) {
                visited[dx][dy] = true
                queue.offer(Pair(dx, dy))
            }
        }
    }
}
