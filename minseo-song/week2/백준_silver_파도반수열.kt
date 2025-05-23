package week2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    val p = LongArray(101) // IntArray로 했다가 틀렸었음 ..
    p[1] = 1
    p[2] = 1
    p[3] = 1

    for (i in 4..100) {
        p[i] = p[i - 2] + p[i - 3]
    }

    repeat(bufferedReader.readLine().toInt()) {
        val n = bufferedReader.readLine().toInt()
        bufferedWriter.write(p[n].toString() + "\n")
    }

    bufferedReader.close()
    bufferedWriter.close()
}