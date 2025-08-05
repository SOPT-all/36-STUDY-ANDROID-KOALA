package week5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(){
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    val n = bufferedReader.readLine().toInt()
    val a = bufferedReader.readLine().split(" ").map { it.toInt() }.sorted()
    val m = bufferedReader.readLine().toInt()
    val queries = bufferedReader.readLine().split(" ").map { it.toInt() }

    for (q in queries) {
        if (binarySearch(a, q)) {
            bufferedWriter.write("1\n")
        } else {
            bufferedWriter.write("0\n")
        }
    }

    bufferedWriter.close()
    bufferedReader.close()
}

fun binarySearch(arr: List<Int>, target: Int): Boolean{
    var left = 0
    var right = arr.size -1

    while (left<=right){
        val mid = (left+right)/2
        when{
            arr[mid] == target -> return true
            arr[mid] < target -> left = mid +1
            else -> right = mid -1
        }
    }

    return false
}