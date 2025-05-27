package week4

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList
import java.util.Queue

data class Tomato(val x: Int, val y: Int, val z: Int)

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    val (m, n, h) = bufferedReader.readLine().split(" ").map { it.toInt() }

    val box = Array(h) { Array(n) { IntArray(m) } }
    val queue: Queue<Tomato> = LinkedList()

    for (x in 0 until h) {
        for (y in 0 until n) {
            val row = bufferedReader.readLine().split(" ").map { it.toInt() }
            for (z in 0 until m) {
                box[x][y][z] = row[z]
                if (box[x][y][z] == 1) {
                    queue.add(Tomato(x, y, z))
                }
            }
        }
    }

    val dz = intArrayOf(1, -1, 0, 0, 0, 0)
    val dx = intArrayOf(0, 0, 1, -1, 0, 0)
    val dy = intArrayOf(0, 0, 0, 0, 1, -1)

    while (queue.isNotEmpty()) {
        val (x, y, z) = queue.poll()

        for (i in 0 until 6) {
            val nx = x + dx[i]
            val ny = y + dy[i]
            val nz = z + dz[i]

            if (nx in 0 until h && ny in 0 until n && nz in 0 until m) {
                if (box[nx][ny][nz] == 0) {
                    box[nx][ny][nz] = box[x][y][z] + 1
                    queue.add(Tomato(nx, ny, nz))
                }
            }
        }
    }

    var max = 0
    for (x in 0 until h) {
        for (y in 0 until n) {
            for (z in 0 until m) {
                if (box[x][y][z] == 0) {
                    bufferedWriter.write("-1")
                    bufferedWriter.close()
                    return
                }
                max = maxOf(max, box[x][y][z])
            }
        }
    }

    bufferedWriter.write("${max - 1}")
    bufferedWriter.close()
}