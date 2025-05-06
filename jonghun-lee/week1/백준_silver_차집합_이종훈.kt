package week1

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (n1, n2) = br.readLine().split(" ").map { it.toInt() }
    // TODO: n1과 n2로 집합의 크기를 제한시키는 방법에 대해서는 고민

    val setA = br.readLine().split(" ").map { it.toInt() }.toSet()
    val setB = br.readLine().split(" ").map { it.toInt() }.toSet()

    val result = setA - setB

    bw.write("${result.size}\n") //어차피 원소가 없으면 0 출력
    if (result.isNotEmpty()) {
        bw.write(result.sorted().joinToString(" "))
    }

    bw.flush()
}
