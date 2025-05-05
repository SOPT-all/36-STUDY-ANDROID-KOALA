private val br = System.`in`.bufferedReader()

fun main() {
    //a->b  -> ba -> bab  ->
    val dp = Array(46) { Pair(0, 0) }
    dp[0] = Pair(1, 0)
    dp[1] = Pair(0, 1)

    val k = br.readLine().toInt()

    for (i in 2..k) {
        dp[i] = Pair(
            dp[i-1].second,
            dp[i-1].first+dp[i-1].second
        )/*dp[i].copy(
            first = dp[i-1].second,
            second = dp[i-1].first + dp[i-1].second
        )*/
    }

    with(System.out.bufferedWriter()) {
        write("${dp[k].first} ${dp[k].second}")
        flush()
    }
}