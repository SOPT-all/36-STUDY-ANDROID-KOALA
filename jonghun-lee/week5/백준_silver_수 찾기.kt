package week5

import java.io.BufferedReader
import java.io.InputStreamReader


fun main(){
    val br= BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var nArr = br.readLine().split(" ").map { it.toInt() }
    val m = br.readLine().toInt()
    val mArr = br.readLine().split(" ").map { it.toInt() }
    nArr = nArr.sorted().toList()

    for (i in 0 until m){
        val value = mArr[i]
        val result = binarySearch(nArr,value,0,n-1)
        println(result)
    }

}

fun binarySearch(arr: List<Int>, value: Int, low: Int, high: Int): Int{
    var low = low
    var high = high
    while (low<=high){
        val mid = (low+high)/2
        if(arr[mid] == value){
            return 1
        }
        else if(arr[mid]>value){
            high = mid -1
        }
        else{
            low = mid+1
        }
    }
    return 0

}