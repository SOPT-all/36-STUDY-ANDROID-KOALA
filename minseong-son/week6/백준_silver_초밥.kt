import kotlin.math.max

val br = System.`in`.bufferedReader()

fun main() {
    val (N, d, k, c) = br.readLine().split(" ").map { it.toInt() }

    val belt = IntArray(N) { br.readLine().toInt() }
    val count = IntArray(d + 1)

    //현재 슬라이딩 초밥 종류
    var currentKinds = 0
    var maxCnt = 0

    //초기 슬라이딩 윈도우 세팅
    for (i in 0 until k) {
        //중복 제거용 처음 초밥 종류가 등장 시 값추가
        if (count[belt[i]] == 0) {
            currentKinds += 1
        }
        count[belt[i]] += 1
    }

    //쿠폰 사용 확인
    maxCnt = if (count[c] == 0) {
        currentKinds + 1
    } else {
        currentKinds
    }

    for (i in 1 until N) {
        val outSushi = belt[(i - 1) % N]
        count[outSushi] -= 1
        if (count[outSushi] == 0) currentKinds -= 1

        val newSushi = belt[(i + k - 1) % N]
        if (count[newSushi] == 0) currentKinds += 1
        count[newSushi] += 1

        val total = if (count[c] == 0) {
            currentKinds + 1
        } else {
            currentKinds
        }

        maxCnt = max(maxCnt, total)
    }

    println(maxCnt)
}