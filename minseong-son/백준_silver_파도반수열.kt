fun main() {
    val t = readLine()!!.toInt()
    val inputs = IntArray(t) { readLine()!!.toInt() }
    val maxN = inputs.maxOrNull() ?: 0

    val dp = LongArray(maxN + 1) { 0 }
    dp[1] = 1
    dp[2] = 1
    dp[3] = 1
    dp[4] = 2
    dp[5] = 2

    for (i in 6..maxN) {
        dp[i] = dp[i - 1] + dp[i - 5]
    }

    val sb = StringBuilder()
    for (n in inputs) {
        sb.appendLine(dp[n])
    }

    print(sb)
}
