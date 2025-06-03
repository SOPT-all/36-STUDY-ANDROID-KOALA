package week5

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    br.readLine()
    val A = br.readLine().split(" ").map { it.toInt() }.groupingBy { it }.eachCount()
    br.readLine()
    val X = br.readLine().split(" ").map { it.toInt()}.toIntArray()
    X.forEach {
        write("${if (A.containsKey(it)) 1 else 0}\n")
    }
    close()
}
