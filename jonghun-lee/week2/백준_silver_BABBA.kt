package week2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val dpA = IntArray(46)
    val dpB = IntArray(46)
    dpA[0] = 1
    dpB[0] = 0
    val k = br.readLine().toInt()
    for (i in 1..k) {
        dpA[i] = dpB[i - 1]
        dpB[i] = dpA[i - 1] + dpB[i - 1]
    }
    bw.write("${dpA[k]} ${dpB[k]}")
    bw.flush()

}