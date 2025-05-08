package week6

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val K = br.readLine().toInt()
    val dp = Array(2) { IntArray(K + 1) }.apply {
        this[0][0] = 1
        this[0][1] = 0
        this[1][0] = 0
        this[1][1] = 1
    }

    for (i in 1..K) {
        dp[0][i] = dp[1][i - 1]
        dp[1][i] = dp[0][i - 1] + dp[1][i - 1]
    }

    write("${dp[0][K]} ${dp[1][K]}")
    close()
}
