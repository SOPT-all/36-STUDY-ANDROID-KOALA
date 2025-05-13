val br = System.`in`.bufferedReader()

//평면 이동 좌표
val dx = intArrayOf(-1, 1, 0, 0)
val dy = intArrayOf(0, 0, -1, 1)

fun fireBFS(
    q: ArrayDeque<Pair<Int, Int>>,
    visited: Array<IntArray>,
    maze: Array<CharArray>,
    R: Int,
    C: Int
) {
    val fireQueue = q
    while (fireQueue.isNotEmpty()) {
        val (x, y) = fireQueue.removeFirst()
        //이동
        for (i in 0 until 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if (nx in 0 until R && ny in 0 until C) {
                if (maze[nx][ny] != '#' && visited[nx][ny] == -1) {
                    visited[nx][ny] = visited[x][y] + 1
                    fireQueue.addLast(Pair(nx, ny))
                }
            }
        }
    }
}

fun jihunBFS(
    q: ArrayDeque<Pair<Int, Int>>,
    visited: Array<IntArray>,
    fireVisited : Array<IntArray>,
    maze: Array<CharArray>,
    R: Int,
    C: Int
) {
    val jihunQueue = q

    while (jihunQueue.isNotEmpty()) {
        val (x, y) = jihunQueue.removeFirst()

        //맨위, 맨아래, 맨 왼쪽, 맨 오른족
        if (x == 0 || x == R - 1 || y == 0 || y == C - 1) {
            println(visited[x][y] + 1)
            return
        }

        for (i in 0 until 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if (nx in 0 until R && ny in 0 until C) {
                if (maze[nx][ny] != '#' && visited[nx][ny] == -1) {
                    //불보다 먼저 도착하거나 불이 아예 안 오는 경우만
                    if (fireVisited[nx][ny] == -1 || visited[x][y] + 1 < fireVisited[nx][ny]) {
                        visited[nx][ny] = visited[x][y] + 1
                        jihunQueue.addLast(Pair(nx, ny))
                    }
                }
            }
        }
    }

    println("IMPOSSIBLE")
}


fun main() {
    val (R, C) = br.readLine().split(" ").map { it.toInt() }
    val maze = Array(R) { CharArray(C) }

    val fireVisited = Array(R) { IntArray(C) { -1 } }
    val jihunVisited = Array(R) { IntArray(C) { -1 } }

    val fireQueue = ArrayDeque<Pair<Int, Int>>()
    val jihunQueue = ArrayDeque<Pair<Int, Int>>()

    repeat(R) {
        val line = br.readLine()
        for (i in 0 until C) {
            maze[it][i] = line[i]
            //위치 받기
            when (maze[it][i]) {
                'J' -> {
                    jihunQueue.add(Pair(it, i))
                    jihunVisited[it][i] = 0
                }

                'F' -> {
                    fireQueue.add(Pair(it, i))
                    fireVisited[it][i] = 0
                }
            }
        }
    }

    fireBFS(
        q = fireQueue,
        visited = fireVisited,
        maze = maze,
        R = R,
        C = C
    )

    jihunBFS(
        q = jihunQueue,
        fireVisited = fireVisited,
        visited = jihunVisited,
        maze = maze,
        R = R,
        C = C
    )
}