package week5

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (K, N) = br.readLine().split(" ").map { it.toInt() }
    val lanCables = Array(K) { br.readLine().toLong() }

    lanCables.sort()

    var left = 0L
    var right = lanCables.last() + 1

    while (left < right) {
        val mid = (left + right) / 2
        val count = lanCables.sumOf { it / mid }

        if (count < N) right = mid
        else left = mid + 1
    }
    write("${right - 1}")
    close()
}