package week1

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var queue = LinkedList<Int>()// queue는 stack과 달리 인터페이스 구현체 사용 필요
    val num = br.readLine().toInt()
    for (i in 0..num-1){
        val input = br.readLine().split(" ")
        when(input[0]){
            "push" ->{
                queue.add(input[1].toInt())
            }
            "pop" ->{
                if (queue.isNotEmpty()) bw.write("${queue.poll()}")
                else bw.write("-1")
                bw.newLine()
            }
            "size" ->{
                bw.write("${queue.size}")
                bw.newLine()
            }
            "empty" ->{
                if (queue.isEmpty()) bw.write("1")
                else bw.write("0")
                bw.newLine()
            }
            "front" ->{
                if (queue.isNotEmpty()) bw.write("${queue.first}")
                else bw.write("-1")
                bw.newLine()
            }
            "back" ->{
                if (queue.isNotEmpty()) bw.write("${queue.last}")
                else bw.write("-1")
                bw.newLine()
            }

        }
    }
    bw.flush()
}