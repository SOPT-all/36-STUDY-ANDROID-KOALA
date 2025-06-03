package week4

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(){
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    val (n, m) = bufferedReader.readLine().split(" ").map { it.toInt() }
    var map = Array(n){bufferedReader.readLine().split(" ").map { it.toInt() }.toIntArray()}

    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)

    fun countIceberg(): Int {
        val visited = Array(n) { BooleanArray(m) }
        var count = 0

        fun dfs(x: Int, y: Int) {
            visited[x][y] = true
            for (i in 0 until 4) {
                val nx = x + dx[i]
                val ny = y + dy[i]
                if (nx in 0 until n && ny in 0 until m && !visited[nx][ny] && map[nx][ny] > 0) {
                    dfs(nx, ny)
                }
            }
        }

        for (i in 0 until n) {
            for (j in 0 until m) {
                if (map[i][j] > 0 && !visited[i][j]) {
                    dfs(i, j)
                    count++
                }
            }
        }
        return count
    }

    fun melt(): Array<IntArray> {
        val newMap = Array(n) { map[it].clone() }

        for (i in 0 until n) {
            for (j in 0 until m) {
                if (map[i][j] > 0) {
                    var sea = 0
                    for (k in 0 until 4) {
                        val ni = i + dx[k]
                        val nj = j + dy[k]
                        if (ni in 0 until n && nj in 0 until m && map[ni][nj] == 0) {
                            sea++
                        }
                    }
                    newMap[i][j] = maxOf(0, map[i][j] - sea)
                }
            }
        }

        return newMap
    }

    var year = 0

    while (true) {
        val parts = countIceberg()
        if (parts >= 2) {
            bufferedWriter.write("$year")
            bufferedWriter.close()
            return
        }

        if (parts == 0) {
            bufferedWriter.write("0")
            bufferedWriter.close()
            return
        }

        map = melt()
        year++
    }
}