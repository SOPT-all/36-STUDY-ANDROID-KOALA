package week2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    val n = bufferedReader.readLine().toInt()

    val dp = Array(n + 1) { LongArray(10) } // dp[i][j] = 길이가 i이고, 마지막 숫자가 j인 오르막 수의 개수

    for (j in 0..9) { // 길이가 1인 경우, 오르막수가 모두 1개인 것으로 초기값 설정
        dp[1][j] = 1
    }

    for (i in 2..n) {
        for (j in 0..9) {
            for (k in 0..j) { // 오르막수이기 때문에 이전 자리 숫자 k <= j
                dp[i][j] = (dp[i][j] + dp[i - 1][k]) % 10007
            }
        }
    }

    bufferedWriter.write((dp[n].sum()%10007).toString())
    bufferedReader.close()
    bufferedWriter.close()
}