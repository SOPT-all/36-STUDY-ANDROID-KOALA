package week6

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.ArrayDeque

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (N, S) = br.readLine().split(" ").map { it.toInt() }
    val arr = br.readLine().split(" ").map { it.toInt() }

    val deque = ArrayDeque<Int>()
    var sum = 0
    var minLength: Int? = null

    var left = 0
    for (right in 0 until N) {
        deque.addLast(arr[right])
        sum += arr[right]

        while (sum >= S) {
            if (minLength == null || deque.size < minLength) {
                minLength = deque.size
            }
            sum -= deque.removeFirst()
            left++
        }
    }

    bw.write("${minLength ?: 0}\n")
    bw.flush()
    bw.close()
}
