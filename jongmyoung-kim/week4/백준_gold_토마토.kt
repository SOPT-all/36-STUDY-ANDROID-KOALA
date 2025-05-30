package week4

import java.util.LinkedList

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (M, N, H) = br.readLine().split(" ").map { it.toInt() }
    val box = Array(H) { Array(N) { br.readLine().split(" ").map { it.toInt() }.toIntArray() } }
    val queue = LinkedList<Pair<Triple<Int, Int, Int>, Int>>()

    if (box.all { it.all { !it.contains(0) } }) write("0")
    else {
        for (i in 0 until H) {
            for (j in 0 until N) {
                for (k in 0 until M) {
                    if (box[i][j][k] == 1) {
                        queue.offer(Pair(Triple(i, j, k), 0))
                    }
                }
            }
        }
        write("${box.bfs(queue)}")
    }
    close()
}

fun Array<Array<IntArray>>.bfs(queue: LinkedList<Pair<Triple<Int, Int, Int>, Int>>): Int {
    val directions = arrayOf(Triple(0, 1, 0), Triple(0, 0, -1), Triple(0, -1, 0), Triple(0, 0, 1), Triple(1, 0, 0), Triple(-1, 0, 0))

    while (queue.isNotEmpty()) {
        val (cur, move) = queue.poll()

        for (i in directions.indices) {
            val dz = cur.first + directions[i].first
            val dy = cur.second + directions[i].second
            val dx = cur.third + directions[i].third

            if (dz in this.indices && dy in this[0].indices && dx in this[0][0].indices &&  this[dz][dy][dx] == 0) {
                this[dz][dy][dx] = 1
                queue.offer(Pair(Triple(dz, dy, dx), move + 1))
            }
        }
        if (this.all { it.all { !it.contains(0) } }) return move + 1
    }
    return -1
}
