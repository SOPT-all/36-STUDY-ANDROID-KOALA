package week5

import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main() {
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    val (k, n) = readln().split(" ").map { it.toInt() }
    val cables = List(k) { readln().toLong() }

    var left = 1L
    var right = cables.maxOrNull()!!
    var answer = 0L

    while (left <= right) {
        val mid = (left + right) / 2
        val count = cables.sumOf { it / mid }

        if (count >= n) {
            answer = mid
            left = mid + 1
        } else {
            right = mid - 1
        }
    }
    bufferedWriter.write(answer.toString())
    bufferedWriter.close()
}