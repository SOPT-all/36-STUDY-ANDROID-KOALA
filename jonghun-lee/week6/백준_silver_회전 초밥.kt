package week6

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.ArrayDeque

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (N, d, k, c) = br.readLine().split(" ").map { it.toInt() }
    val sushi = IntArray(N) { br.readLine().toInt() }

    val deque = ArrayDeque<Int>()
    val count = IntArray(d + 1)
    var sushiKind = 0

    for (i in 0 until k) {
        val s = sushi[i]
        deque.addLast(s)
        if (count[s] == 0) sushiKind++
        count[s]++
    }

    var max = if (count[c] == 0) sushiKind + 1 else sushiKind

    for (i in 1 until N) {
        val removed = deque.removeFirst()
        count[removed]--
        if (count[removed] == 0) sushiKind--

        val next = sushi[(i + k - 1) % N]
        deque.addLast(next)
        if (count[next] == 0) sushiKind++
        count[next]++

        val total = if (count[c] == 0) sushiKind + 1 else sushiKind
        max = if (total > max) total else max

    }

    bw.write("$max\n")
    bw.flush()
    bw.close()
}
