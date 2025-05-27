import java.util.LinkedList
import java.util.Queue

val br = System.`in`.bufferedReader()
val dx = intArrayOf(-1, 1, 0, 0)
val dy = intArrayOf(0, 0, -1, 1)

fun melt(iceberg : Array<IntArray>, sea :  Array<IntArray>, q : Queue<Pair<Int, Int>>) : Queue<Pair<Int, Int>> {
    val newQ : Queue<Pair<Int, Int>> = LinkedList()

    for ((x,y) in q) {
        //0에서 안내려가게
        iceberg[x][y] = maxOf(0, iceberg[x][y] - sea[x][y])
        if (iceberg[x][y] > 0) {
            newQ.add(Pair(x,y))
        }
    }

    return newQ
}

fun BFSIceberg(iceberg: Array<IntArray>, N: Int, M: Int) : Int {
    val visited = Array(N) { BooleanArray(M) }
    var count = 0

    for (i in 0 until N) {
        for (j in 0 until M) {
            //아직 빙산이 남아있고 방문하지 않은 빙산이있다면
            if (iceberg[i][j] > 0 && !visited[i][j]) {
                count++
                val q: Queue<Pair<Int, Int>> = LinkedList()
                q.add(Pair(i, j))
                visited[i][j] = true

                while (q.isNotEmpty()) {
                    val (n, m) = q.poll()
                    for (i in 0 until 4) {
                        val x = n + dx[i]
                        val y = m + dy[i]
                        if (x in 0 until N && y in 0 until M) {
                            if (!visited[x][y] && iceberg[x][y] > 0) {
                                visited[x][y] = true
                                q.add(Pair(x, y))
                            }
                        }
                    }
                }
            }
        }
    }

    return count
}

fun main() {
    var answer = 0
    val (N,M) = br.readLine().split(" ").map { it.toInt() }
    val iceberg = Array(N) { IntArray(M) }
    //해당 위치의 인접 바다개수
    val sea = Array(N) { IntArray(M) }
    val q : Queue<Pair<Int, Int>> = LinkedList()

    for (n in 0 until N) {
        val row = br.readLine().split(" ").map { it.toInt() }
        for (m in 0 until M) {
            iceberg[n][m] = row[m]
            if (row[m] > 0) {
                q.add(Pair(n,m))
            }
        }
    }

    while (q.isNotEmpty()) {
        val icebergCnt = BFSIceberg(iceberg, N, M)
        if (icebergCnt >= 2) {
            println(answer)
            return
        }

        //다노금 분리x
        if (icebergCnt == 0) {
            println(0)
            return
        }

        //주위 인접 바다 세기용
        for ((n,m) in q) {
            var seaCount = 0
            for (i in 0 until 4) {
                val x = n + dx[i]
                val y = m + dy[i]

                //범위에서 안넘어가게
                if (x in 0 until N && y in 0 until M) {
                    if (iceberg[x][y] == 0) {
                        seaCount++
                    }
                }
            }
            sea[n][m] = seaCount
        }

        val newQ = melt(
            iceberg = iceberg,
            sea = sea,
            q = q
        )

        q.clear()
        q.addAll(newQ)

        answer += 1
    }

    //q가 비었을 때 -> newQ로인해 다 노갔다는 ㄸ,ㅅ
    println(0)
}