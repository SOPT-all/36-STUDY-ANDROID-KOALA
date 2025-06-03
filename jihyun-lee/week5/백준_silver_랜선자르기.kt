fun main() {
    val (K, N) = readLine()!!.split(" ").map { it.toInt() }

    val lines = IntArray(K) { readLine()!!.toInt() }

    var start: Long = 1
    var end: Long = lines.maxOrNull()!!.toLong()

    var result: Long = 0

    while (start <= end) {
        val mid = (start + end) / 2

        var count = 0L
        for (line in lines) {
            count += line / mid
        }

        if (count >= N) {
            result = mid
            start = mid + 1
        } else {
            end = mid - 1
        }
    }

    println(result)
}