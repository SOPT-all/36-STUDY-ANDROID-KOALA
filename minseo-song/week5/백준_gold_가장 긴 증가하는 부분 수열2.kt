package week5

import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main() {
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    val n = readln().toInt()
    val a = readln().split(" ").map { it.toInt() }

    val dp = mutableListOf<Int>()

    for (num in a) {
        if (dp.isEmpty() || dp.last() < num) {
            dp.add(num)
        } else {
            var left = 0
            var right = dp.size - 1
            while (left < right) {
                val mid = (left + right) / 2
                if (dp[mid] < num) {
                    left = mid + 1
                } else {
                    right = mid
                }
            }
            dp[left] = num
        }
    }
    bufferedWriter.write(dp.size.toString())
    bufferedWriter.close()
}