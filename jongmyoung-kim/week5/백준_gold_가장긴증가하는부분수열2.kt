package week5

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val size = br.readLine().toInt()
    val seq =  br.readLine().split(" ").map { it.toInt() }
    val list = mutableListOf<Int>()
    for (num in seq) {
        val pos = list.binarySearch(num)
        val insertPos = if (pos > -1) pos else -pos - 1
        if (list.size == insertPos) list.add(num) else list[insertPos] = num
    }
    write("${list.size}")
    close()
}