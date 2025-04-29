import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    repeat(br.readLine().toInt()) {
        val sum = br.readLine().split(" ").sumOf { it.toInt() }
        bw.append("$sum\n")
    }

    bw.flush()
    bw.close()
}