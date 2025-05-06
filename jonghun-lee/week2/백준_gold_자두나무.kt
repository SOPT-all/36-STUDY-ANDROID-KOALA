package week2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (time, moveCount) = br.readLine().split(" ").map { it.toInt() }
    val arr = IntArray(time + 1)
    for (i in 1..time) {
        arr[i] = br.readLine().toInt()
    }

    val dp = Array(time + 1) { IntArray(moveCount + 1) }

    for (i in 1..time) {
        for (j in 0..moveCount) {
            val currentTree = if (j % 2 == 0) 1 else 2
            val plumCount = if (arr[i] == currentTree) 1 else 0
            if (j == 0) {
                dp[i][j] = dp[i - 1][j] + plumCount
            } else {
                dp[i][j] = maxOf(dp[i - 1][j], dp[i - 1][j - 1]) + plumCount
            }
        }
    }

    bw.write("${dp[time].max()}\n")
    bw.flush()
}
