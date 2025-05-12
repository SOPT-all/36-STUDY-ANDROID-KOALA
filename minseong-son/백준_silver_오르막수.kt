val br = System.`in`.bufferedReader()
val sb = StringBuilder()

fun main() {
    val n = br.readLine().toInt()

    //자리수, 마지막 자리수값
    val dp = Array(n+1) { IntArray(10){0} }

    //1자리수는 1개씩 0포함
    repeat(10) {
        dp[1][it] = 1
    }

    for (i in 2..n) {
        for (j in 0..9) {
            if (j == 0) {
                //마지막 자리수가 0 => 그냥 0이니 전거에서 가져옴
                dp[i][j] = dp[i - 1][j]
            } else {
                dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % 10007
            }
        }
    }

    sb.append(dp[n].sum() % 10007)
    print(sb)
}