package week2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main(){
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    val st = StringTokenizer(bufferedReader.readLine())
    val t = st.nextToken().toInt()
    val w = st.nextToken().toInt()

    val tree = IntArray(t+1)
    for (i in 1..t){
        tree[i] = bufferedReader.readLine().toInt()
    }

    val dp = Array(t+1){ IntArray(w+1) }

    for (t in 1..t){
        for (w in 0..w) {
            val currentPos = if (w%2 ==0) 1 else 2
            val gain = if (tree[t] == currentPos) 1 else 0

            dp[t][w] = dp[t-1][w] + gain

            if (w>0){
                dp[t][w] = maxOf(dp[t][w], dp[t - 1][w - 1] + gain)
            }
        }
    }

    bufferedWriter.write((0..w).maxOf { dp[t][it] }.toString())
    bufferedReader.close()
    bufferedWriter.close()
}