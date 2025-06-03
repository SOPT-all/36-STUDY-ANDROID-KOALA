package week4

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val dx = intArrayOf(-1, 1, 0, 0, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1, 0, 0)
    val dz = intArrayOf(0, 0, 0, 0, -1, 1)

    // M 가로 N 세로 H 높이
    val (M, N, H) = br.readLine().split(" ").map { it.toInt() }
    val tomatoBox = Array(H) { Array(N) { IntArray(M) } }
    val queue = LinkedList<IntArray>()

    for (z in 0 until H) {
        for (y in 0 until N) {
            val row = br.readLine().split(" ").map { it.toInt() }
            for (x in 0 until M) {
                tomatoBox[z][y][x] = row[x]
                if (row[x] == 1) {
                    queue.offer(intArrayOf(z, y, x))
                }
            }
        }
    }

    var dayCount = -1

    while (queue.isNotEmpty()) {
        val size = queue.size

        repeat(size) {
            val (z, y, x) = queue.poll()

            for (i in 0 until 6) {
                val nz = z + dz[i]
                val ny = y + dy[i]
                val nx = x + dx[i]

                if (nz in 0 until H && ny in 0 until N && nx in 0 until M) {
                    if (tomatoBox[nz][ny][nx] == 0) {
                        tomatoBox[nz][ny][nx] = 1
                        queue.offer(intArrayOf(nz, ny, nx))
                    }
                }
            }
        }

        dayCount += 1

    }

    for (z in 0 until H)
        for (y in 0 until N)
            for (x in 0 until M)
                if (tomatoBox[z][y][x] == 0) {
                   println(-1)
                    return
                }
   println(dayCount)

}
