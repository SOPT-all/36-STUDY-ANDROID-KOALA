package week1

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.Stack

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val stack = Stack<Int>()
    val num = br.readLine().toInt()
    for (i in 0..num-1){
        val input = br.readLine().split(" ")
        when(input[0]){
            "push" ->{
                stack.add(input[1].toInt())
            }
            "pop" ->{
                if (stack.isNotEmpty()) bw.write("${stack.removeAt(stack.size-1)}")
                else bw.write("-1")
                bw.newLine()
            }
            "size" ->{
                bw.write("${stack.size}")
                bw.newLine()
            }
            "empty" ->{
                if (stack.isEmpty()) bw.write("1")
                else bw.write("0")
                bw.newLine()
            }
            "top" ->{
                if (stack.isNotEmpty()) bw.write("${stack[stack.size-1]}")
                else bw.write("-1")
                bw.newLine()
            }

        }
    }
    bw.flush()
}