package week2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    var aCount = 1
    var bCount = 0

    repeat(bufferedReader.readLine().toInt()) {
        val nextA = bCount
        val nextB = aCount + bCount
        aCount = nextA
        bCount = nextB
    }

    bufferedWriter.write("$aCount $bCount")
    bufferedReader.close()
    bufferedWriter.close()
}