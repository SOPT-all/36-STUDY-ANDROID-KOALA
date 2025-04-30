package week1

import kotlin.math.ceil

fun solution(progresses: IntArray, speeds: IntArray): IntArray {
    var answer = intArrayOf()
    val list = mutableListOf<Int>()

    progresses.forEachIndexed { index, progress ->
        val timeTaken = ceil((100 - progress).toFloat() / speeds[index]).toInt()
        list.add(timeTaken)
    }

    var count = 0
    var current = list[0]

    list.forEach {
        if (it <= current) count++
        else {
            answer += count
            current = it
            count = 1
        }
    }
    answer += count
    return answer
}
