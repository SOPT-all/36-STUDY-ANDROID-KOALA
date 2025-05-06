package week1

fun main(){
    val progresses = intArrayOf(93, 30, 55)
    val speeds = intArrayOf(1, 30, 5)
    println(solution(progresses, speeds).toList())
}

fun solution(progresses: IntArray, speeds: IntArray): IntArray {
    val answer = mutableListOf<Int>()
    var cnt = 0
    var time = 1

    val progressesQueue = progresses.toMutableList()
    val speedsQueue = speeds.toMutableList()

    while (progressesQueue.isNotEmpty()) {
        if (progressesQueue.first() + time * speedsQueue.first() >= 100) {
            progressesQueue.removeAt(0)
            speedsQueue.removeAt(0)
            cnt++
        } else {
            if (cnt > 0) {
                answer.add(cnt)
                cnt = 0
            }
            time++
        }
    }

    if (cnt > 0) answer.add(cnt)

    return answer.toIntArray()
}
