fun main() {
    val n = readln().toInt()
    val a = readln().split(" ").map { it.toInt() }.toSet()

    val m = readln().toInt()
    val xList = readln().split(" ").map { it.toInt() }

    for (x in xList) {
        if (x in a) {
            println(1)
        } else {
            println(0)
        }
    }
}