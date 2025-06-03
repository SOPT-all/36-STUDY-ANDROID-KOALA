package week2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    val st = StringTokenizer(bufferedReader.readLine())
    val t = st.nextToken().toInt()
    val w = st.nextToken().toInt()

    val tree = IntArray(t + 1)
    for (i in 1..t) {
        tree[i] = bufferedReader.readLine().toInt()
    }

    val dp =
        Array(t + 1) { IntArray(w + 1) } // dp[i][j] = i초까지 j번 이동했을 때 자루를 최대 몇개 받을 수 있는가 저장하는 2차원 dp 배열

    for (t in 1..t) { // 현재 시간
        for (w in 0..w) { // 지금까지 움직인 횟수
            val currentPos = if (w % 2 == 0) 1 else 2 // 자두 위치 = 이동 수가 짝수면 1, 홀수면 2
            val gain = if (tree[t] == currentPos) 1 else 0 // 자두 위치와 자두 떨어지는 나무 위치가 같으면 자두 획득

            dp[t][w] = dp[t - 1][w] + gain // 현재 위치 유지

            if (w > 0) {
                dp[t][w] = maxOf(dp[t][w], dp[t - 1][w - 1] + gain) // 현재 위치 유지, 이동하기 중 더 큰 값 선택
            }
        }
    }

    bufferedWriter.write((0..w).maxOf { dp[t][it] }.toString())
    bufferedReader.close()
    bufferedWriter.close()
}