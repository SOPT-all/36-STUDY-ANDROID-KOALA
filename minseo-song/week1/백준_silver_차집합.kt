package week1

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    val st = StringTokenizer(bufferedReader.readLine())
    val nA = st.nextToken().toInt()
    val nB = st.nextToken().toInt()

    val setA = mutableSetOf<Int>()
    val stA = StringTokenizer(bufferedReader.readLine())
    repeat(nA) {
        setA.add(stA.nextToken().toInt())
    }

    val setB = mutableSetOf<Int>()
    val stB = StringTokenizer(bufferedReader.readLine())
    repeat(nB) {
        setB.add(stB.nextToken().toInt())
    }

    val result = setA.filter { it !in setB }.sorted()

    bufferedWriter.write(result.size.toString() + "\n")
    if (result.isNotEmpty()){
        repeat(result.size){
            bufferedWriter.write(result[it].toString() + " ")
        }
    }
    bufferedReader.close()
    bufferedWriter.flush()
}