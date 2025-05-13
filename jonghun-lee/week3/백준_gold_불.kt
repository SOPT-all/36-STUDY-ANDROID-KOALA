package week3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.ArrayDeque

//해결 실패 ㅜㅜ
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (r, c) = br.readLine().split(" ").map { it.toInt() }
    val map = Array(r) { br.readLine().toCharArray() }

    val fireTime = Array(r) { IntArray(c) { -1 } }
    val jihunTime = Array(r) { IntArray(c) { -1 } }

    val fireQueue = ArrayDeque<Pair<Int, Int>>()
    val jihunQueue = ArrayDeque<Pair<Int, Int>>()

    val dx = listOf(-1, 1, 0, 0)
    val dy = listOf(0, 0, -1, 1)

    for (i in 0 until r) {
        for (j in 0 until c) {
            when (map[i][j]) {
                'F' -> {
                    fireQueue.add(i to j)
                    fireTime[i][j] = 0
                }
                'J' -> {
                    jihunQueue.add(i to j)
                    jihunTime[i][j] = 0
                }
            }
        }
    }

    while (fireQueue.isNotEmpty()) {
        val (x, y) = fireQueue.removeFirst()

        for (d in 0..3) {
            val nx = x + dx[d]
            val ny = y + dy[d]

            if (nx in 0 until r && ny in 0 until c) {
                if (map[nx][ny] != '#' && fireTime[nx][ny] == -1) {
                    fireTime[nx][ny] = fireTime[x][y] + 1
                    fireQueue.add(nx to ny)
                }
            }
        }
    }

    while (jihunQueue.isNotEmpty()) {
        val (x, y) = jihunQueue.removeFirst()

        if (x == 0 || y == 0 || x == r - 1 || y == c - 1) {
            println(jihunTime[x][y] + 1)
            return
        }

        for (d in 0..3) {
            val nx = x + dx[d]
            val ny = y + dy[d]

            if (nx in 0 until r && ny in 0 until c) {
                if (map[nx][ny] == '.' && jihunTime[nx][ny] == -1) {
                    val nextTime = jihunTime[x][y] + 1
                    if (fireTime[nx][ny] == -1 || nextTime < fireTime[nx][ny]) {
                        jihunTime[nx][ny] = nextTime
                        jihunQueue.add(nx to ny)
                    }
                }
            }
        }
    }

    println("IMPOSSIBLE")
}
