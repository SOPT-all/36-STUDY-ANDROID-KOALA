package week3

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer

data class Point(val x: Int, val y: Int)

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    val st = StringTokenizer(bufferedReader.readLine())
    val r = st.nextToken().toInt()
    val c = st.nextToken().toInt()

    val fireTime = Array(r) { IntArray(c) { -1 } }
    val jihunTime = Array(r) { IntArray(c) { -1 } }

    val fireQueue: Queue<Point> = LinkedList()
    val jihunQueue: Queue<Point> = LinkedList()

    val map = Array(r) { CharArray(c) }

    for (i in 0 until r){
        val line = bufferedReader.readLine()
        for (j in 0 until c){
            map[i][j] = line[j]
            when(map[i][j]){
                'F' -> {
                    fireQueue.add(Point(i, j))
                    fireTime[i][j] = 0
                }
                'J' -> {
                    jihunQueue.add(Point(i, j))
                    jihunTime[i][j] = 0
                }
            }
        }
    }

    val dx = intArrayOf(-1, 1, 0 ,0)
    val dy = intArrayOf(0, 0, -1, 1)

    while (fireQueue.isNotEmpty()) {
        val (x, y) = fireQueue.poll()
        for (i in 0 until 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]
            if (nx in 0 until r && ny in 0 until c) {
                if (map[nx][ny] != '#' && fireTime[nx][ny] == -1) {
                    fireTime[nx][ny] = fireTime[x][y] + 1
                    fireQueue.add(Point(nx, ny))
                }
            }
        }
    }

    while (jihunQueue.isNotEmpty()) {
        val (x, y) = jihunQueue.poll()
        if (x == 0 || x == r - 1 || y == 0 || y == c - 1) {
            bufferedWriter.write("${jihunTime[x][y] + 1}")
            bufferedWriter.close()
            return
        }

        for (i in 0 until 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]
            if (nx in 0 until r && ny in 0 until c) {
                if (map[nx][ny] == '.' && jihunTime[nx][ny] == -1) {
                    if (fireTime[nx][ny] == -1 || jihunTime[x][y] + 1 < fireTime[nx][ny]) {
                        jihunTime[nx][ny] = jihunTime[x][y] + 1
                        jihunQueue.add(Point(nx, ny))
                    }
                }
            }
        }
    }

    bufferedWriter.write("IMPOSSIBLE")
    bufferedWriter.close()
}