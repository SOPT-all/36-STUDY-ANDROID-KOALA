import java.util.*

fun main() {
    val (R, C) = readln().split(" ").map { it.toInt() }
    val maze = Array(R) { CharArray(C) }
    val fireTime = Array(R) { IntArray(C) { -1 } }
    val jihunTime = Array(R) { IntArray(C) { -1 } }

    val fireQueue: Queue<Pair<Int, Int>> = LinkedList()
    val jihunQueue: Queue<Pair<Int, Int>> = LinkedList()

    for (i in 0 until R) {
        val line = readln()
        for (j in 0 until C) {
            maze[i][j] = line[j]
            if (maze[i][j] == 'F') {
                fireQueue.add(i to j)
                fireTime[i][j] = 0
            }
            if (maze[i][j] == 'J') {
                jihunQueue.add(i to j)
                jihunTime[i][j] = 0
            }
        }
    }

    val dx = intArrayOf(1, -1, 0, 0)
    val dy = intArrayOf(0, 0, 1, -1)

    while (fireQueue.isNotEmpty()) {
        val (x, y) = fireQueue.poll()
        for (dir in 0 until 4) {
            val nx = x + dx[dir]
            val ny = y + dy[dir]
            if (nx in 0 until R && ny in 0 until C) {
                if (maze[nx][ny] != '#' && fireTime[nx][ny] == -1) {
                    fireTime[nx][ny] = fireTime[x][y] + 1
                    fireQueue.add(nx to ny)
                }
            }
        }
    }

    while (jihunQueue.isNotEmpty()) {
        val (x, y) = jihunQueue.poll()

        if (x == 0 || y == 0 || x == R - 1 || y == C - 1) {
            println(jihunTime[x][y] + 1)
            return
        }

        for (dir in 0 until 4) {
            val nx = x + dx[dir]
            val ny = y + dy[dir]
            if (nx in 0 until R && ny in 0 until C) {
                if (maze[nx][ny] == '.' && jihunTime[nx][ny] == -1) {
                    if (fireTime[nx][ny] == -1 || fireTime[nx][ny] > jihunTime[x][y] + 1) {
                        jihunTime[nx][ny] = jihunTime[x][y] + 1
                        jihunQueue.add(nx to ny)
                    }
                }
            }
        }
    }

    println("IMPOSSIBLE")
}
