import java.util.*

data class Point(val x: Int, val y: Int, val z: Int)

fun main() {
    val (m, n, h) = readln().split(" ").map { it.toInt() }
    val box = Array(h) { Array(n) { IntArray(m) } }
    val queue: Queue<Point> = LinkedList()

    for (z in 0 until h) {
        for (y in 0 until n) {
            val line = readln().split(" ").map { it.toInt() }
            for (x in 0 until m) {
                box[z][y][x] = line[x]
                if (line[x] == 1) {
                    queue.add(Point(x, y, z))
                }
            }
        }
    }

    val dx = arrayOf(1, -1, 0, 0, 0, 0)
    val dy = arrayOf(0, 0, 1, -1, 0, 0)
    val dz = arrayOf(0, 0, 0, 0, 1, -1)

    while (queue.isNotEmpty()) {
        val (x, y, z) = queue.poll()
        for (i in 0 until 6) {
            val nx = x + dx[i]
            val ny = y + dy[i]
            val nz = z + dz[i]
            if (nx in 0 until m && ny in 0 until n && nz in 0 until h) {
                if (box[nz][ny][nx] == 0) {
                    box[nz][ny][nx] = box[z][y][x] + 1
                    queue.add(Point(nx, ny, nz))
                }
            }
        }
    }

    var result = 0
    for (z in 0 until h) {
        for (y in 0 until n) {
            for (x in 0 until m) {
                if (box[z][y][x] == 0) {
                    println(-1)
                    return
                }
                result = maxOf(result, box[z][y][x])
            }
        }
    }

    println(result - 1)
}