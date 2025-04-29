package week1

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    br.readLine()
    val A = br.readLine().split(" ").map { it.toInt() }.toSortedSet()
    val B = br.readLine().split(" ").map { it.toInt() }.toSortedSet()
    val answer = A - B

    write("${answer.size}\n${answer.joinToString(" ")}")
    close()
}
