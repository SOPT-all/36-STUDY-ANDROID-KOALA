import kotlin.math.max

val br = System.`in`.bufferedReader()

fun main() {
    val (t,w) = br.readLine().split(" ").map { it.toInt() }
    val dp = Array(t + 1) { IntArray(w + 1) {0} }
    val trees = IntArray(t + 1)

    for (i in 1..t) {
        trees[i] = br.readLine().toInt()
    }

    for(i in 1..t) {
        for (j in 0..w) {
            val currentTree = if (j % 2 == 0) {
                1
            } else {
                2
            }

            if (trees[i] == currentTree) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + 1
                } else {
                    dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - 1]) + 1
                }
            } else {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j]
                } else {
                    dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - 1])
                }
            }
        }
    }

    print(dp[t].max())
}