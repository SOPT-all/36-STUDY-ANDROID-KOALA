import java.util.StringTokenizer

private val br = System.`in`.bufferedReader()

fun main() = with(System.`out`.bufferedWriter()) {
    repeat(br.readLine().toInt()) {
//        val token = StringTokenizer(br.readLine())
//        val sum = (token.nextToken().toInt() + token.nextToken().toInt()).toString()
        val sum = br.readLine().split(" ").map { it.toInt() }.sum()
        write("$sum\n")
    }
    close()
}
