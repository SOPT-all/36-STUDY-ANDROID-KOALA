package week1

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    repeat(bufferedReader.readLine().toInt()) {
        val str = StringTokenizer(bufferedReader.readLine())
        bufferedWriter.write((str.nextToken().toInt() + str.nextToken().toInt()).toString() + "\n")
    }
    bufferedReader.close()
    bufferedWriter.flush()
}
