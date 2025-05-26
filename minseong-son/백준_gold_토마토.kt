import java.util.LinkedList
import java.util.Queue

val br = System.`in`.bufferedReader()

//가로(M), 세로(N), 높이(H) 이동 좌표
//위, 아래, 왼쪽, 오른쪽, 앞, 뒤
val dm = intArrayOf(0, 0, -1, 1, 0, 0) //x축
val dn = intArrayOf(0, 0, 0, 0, -1, 1) //y축
val dh = intArrayOf(1, -1, 0, 0, 0, 0) //z축


fun main() {
    var answer = 0
    val (M, N, H) = br.readLine().split(" ").map { it.toInt() }

    val box = Array(H) { Array(N) { IntArray(M) } }
    
    val queue: Queue<Triple<Int, Int, Int>> = LinkedList()

    //박스에 담기
    for (h in 0 until H) {
        for (n in 0 until N) {
            val row = br.readLine().split(" ").map { it.toInt() }
            for (m in 0 until M) {
                box[h][n][m] = row[m]
                if (box[h][n][m] == 1) {
                    queue.add(Triple(h, n, m))
                }
            }
        }
    }


    while (queue.isNotEmpty()) {
        //현재 위치를 가져옴
        val (h, n, m) = queue.poll()
        for (i in 0 until 6) {
            val z = h + dh[i]
            val x = m + dm[i]
            val y = n + dn[i]

            //상자에서 나가지 못하게
            if (x in 0 until M && y in 0 until N && z in 0 until H) {
                //안 익었다면 익히기
                if (box[z][y][x] == 0) {
                    //일수 갱신
                    box[z][y][x] = box[h][n][m] + 1
                    queue.add(Triple(z, y, x))
                }
            }
        }
    }


    for (h in 0 until H) {
        for (n in 0 until N) {
            for (m in 0 until M) {
                //BFS가 끝났는데도 안익은게 있으면 -1
                if (box[h][n][m] == 0) {
                    println(-1)
                    return
                }

                answer = maxOf(answer, box[h][n][m])
            }
        }
    }

    //이미 익어있던 토마토(0일차) 때문에 -1
    println(answer - 1)
}