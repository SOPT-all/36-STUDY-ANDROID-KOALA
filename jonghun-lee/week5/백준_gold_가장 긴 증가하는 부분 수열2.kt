package week5

fun main() {
    val n = readln().toInt()
    val a = readln().split(" ").map { it.toInt() }

    val list = mutableListOf<Int>()

    for (x in a) {
        val pos = list.binarySearch(x)
        if (pos < 0) {
            val insertPos = -(pos + 1)
            if (insertPos == list.size) list.add(x)  else list[insertPos] = x
        }
    }

    println(list.size)
}