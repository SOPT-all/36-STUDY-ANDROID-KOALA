package week2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val k = br.readLine().toInt()
    val dp = longArrayOf(0, 1, 1, 1, 2, 2) + LongArray(95) //dp[0] = 0 을 넣어주기

    for (i in 6..100) {
        dp[i] = dp[i - 1] + dp[i - 5]
    }

    repeat(k) {
        val num = br.readLine().toInt()
        bw.write("${dp[num]}\n")
    }

    bw.flush()
}
