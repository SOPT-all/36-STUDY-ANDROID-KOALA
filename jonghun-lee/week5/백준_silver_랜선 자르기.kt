package week5

import java.io.BufferedReader
import java.io.InputStreamReader

lateinit var cables: List<Long>
var N = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (k, n) = br.readLine().split(" ").map { it.toInt() }
    N = n
    cables = List(k) { br.readLine().toLong() }

    var left = 1L
    var right = cables.maxOrNull()!!
    var result = 0L

    while (left <= right) {
        val mid = (left + right) / 2
        if (isPossible(mid)) {
            result = mid
            left = mid + 1
        } else {
            right = mid - 1
        }
    }

    println(result)
}

fun isPossible(length: Long): Boolean {
    return cables.sumOf { it / length } >= N
}
