package week1

import java.util.LinkedList

fun solution(priorities: IntArray, location: Int): Int {
    var answer = 0
    val readyQueue = LinkedList<Pair<Int, Int>>().apply {
        addAll(priorities.mapIndexed { index, priority -> priority to index })
    }
    val jobQueue = LinkedList<Int>().apply { addAll(priorities.sortedDescending()) }

    while (readyQueue.isNotEmpty()) {
        val cur = readyQueue.poll()
        if (cur.first != jobQueue.peek()) readyQueue.offer(cur)
        else {
            jobQueue.poll()
            answer++
            if (location == cur.second) break
        }
    }
    return answer
}
