package week6

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val T = br.readLine().toInt()
    val dp = LongArray(102).apply {
        this[0] = 1
        this[1] = 1
        this[2] = 1
    }

    for (i in 3 until 102) {
        dp[i] = dp[i - 3] + dp[i - 2]
    }

    repeat(T) {
        write("${dp[br.readLine().toInt() - 1]}\n")
    }
    close()
}
