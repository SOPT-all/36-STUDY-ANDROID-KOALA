import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (a,b) = br.readLine().split(" ")

    val setA = br.readLine().split(" ").take(a.toInt()).map { it.toInt() }.toHashSet()
    val setB = br.readLine().split(" ").take(b.toInt()).map { it.toInt() }.toHashSet()

    val answer = setA.subtract(setB).sorted()

    if (answer.isNotEmpty()) {
        bw.append("${answer.size}\n")
        bw.append(answer.joinToString(" "))
    } else {
        bw.append("0")
    }

    bw.flush()
    bw.close()
}