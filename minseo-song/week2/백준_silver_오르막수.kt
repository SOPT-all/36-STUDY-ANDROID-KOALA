package week2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    val n = bufferedReader.readLine().toInt()

    val dp = Array(n + 1) { LongArray(10) }

    for (j in 0..9) {
        dp[1][j] = 1
    }

    for (i in 2..n) {
        for (j in 0..9) {
            for (k in 0..j) {
                dp[i][j] = (dp[i][j] + dp[i - 1][k]) % 10007
            }
        }
    }

    bufferedWriter.write((dp[n].sum()%10007).toString())
    bufferedReader.close()
    bufferedWriter.close()
}