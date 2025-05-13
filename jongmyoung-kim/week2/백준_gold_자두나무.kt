package week6

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (T, W) = br.readLine().split(" ").map { it.toInt() }
    val plum = IntArray(T) { 1 - br.readLine().toInt() % 2 }
    val dp = Array(T + 1) { IntArray(W + 1) }

    for (i in 1..T) {
        for (j in 0..W) {
            val current = if (plum[i - 1] == j % 2) 1 else 0

            dp[i][j] = dp[i][j].coerceAtLeast(dp[i - 1][j] + current)

            if (j > 0) dp[i][j] = dp[i][j].coerceAtLeast(dp[i - 1][j - 1] + current)
        }
    }
    write("${dp[T].maxOrNull()}\n")
    close()
}
