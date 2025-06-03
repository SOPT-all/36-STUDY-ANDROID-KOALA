import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    val a = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    val lis = mutableListOf<Int>()

    for (num in a) {
        val pos = Collections.binarySearch(lis, num)
        if (pos < 0) {
            val insertPos = -(pos + 1)
            if (insertPos == lis.size) {
                lis.add(num)
            } else {
                lis[insertPos] = num
            }
        }
    }

    println(lis.size)
}