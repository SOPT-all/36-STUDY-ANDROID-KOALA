package week6

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val N = br.readLine().toInt()

    val dp = Array(N + 1) { IntArray(10) }.apply {
        this[0].fill(1)
    }

    for (i in 1 until N) {
        for (j in 0..9) {
            for (k in j until 10) {
                dp[i][j] += dp[i - 1][k] % 10007
            }
        }
    }

    println(dp[N - 1].toList().reduce { acc, i -> (acc + i) % 10007 })
}
