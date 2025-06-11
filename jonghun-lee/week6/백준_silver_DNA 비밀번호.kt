package week6

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val (S,P) = br.readLine().split(" ").map { it.toInt() }

    val totalDna = br.readLine()

    //요구 알파벳
    val required = br.readLine().split(" ").map { it.toInt() }
    val requiredA = required[0]
    val requiredC = required[1]
    val requiredG = required[2]
    val requiredT = required[3]

    //가진 알파벳
    val hasCount = IntArray(4)

    var validPasswordCount = 0


    for (i in 0 until P){
        val index  = indexCount(totalDna[i])
        hasCount[index]++
    }

    if (isValid(hasCount, requiredA, requiredC, requiredG, requiredT)) {
        validPasswordCount++
    }


    //슬라이딩 윈도우
    for (i in P until S){
        val addIndex = indexCount(totalDna[i])
        val removeIndex = indexCount(totalDna[i- P])

        hasCount[addIndex]++
        hasCount[removeIndex]--

        if (isValid(hasCount,requiredA,requiredC,requiredG,requiredT)){
            validPasswordCount++
        }
    }

    bw.write("$validPasswordCount\n")
    bw.flush()
    bw.close()

}

fun indexCount(ch: Char): Int{
    return when (ch){
        'A' -> 0
        'C' -> 1
        'G' -> 2
        'T' -> 3
        else -> -1
    }
}

fun isValid(hasCount: IntArray, a: Int, c: Int, g: Int, t: Int): Boolean{
    return hasCount[0] >= a &&
            hasCount[1] >= c &&
            hasCount[2] >= g &&
            hasCount[3] >= t
}

