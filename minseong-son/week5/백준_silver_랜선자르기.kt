val br = System.`in`.bufferedReader()

fun main() {
    val (k,n) = br.readLine().split(" ").map {it.toInt()}

    //전선용
    val arr = LongArray(k) { br.readLine().toLong() }

    //이분 탐색의 상한 방법 upperbound
    //상한 = 찾고자 하는 특정 값을 초과하는 첫 위치

    //랜선 최소 길이
    var low = 1L
    //랜선의 가장 긴 길이
    var high = arr.maxOrNull()!!

    while (low <= high) {
        val mid = (low + high) / 2
        //현재 mid 길이로 자르면 만들 수 있는 총 랜선 개수
        val p = arr.sumOf { it / mid }

        //mid길이로 잘랐을 때 개수가 만들고자 하는 랜선의 개수보다 작다면
        //자르고자 하는 길이를 줄이기 위해 최대 길이를 줄인다
        //그 외에는 자르고자 하는 길이를 늘려야 하므로 최소길이를 늘린다.
        //필요 개수보다 적게ㅏㄴ오면
        if (p < n) {
            high = mid - 1 //길이를 줄여야함 mid로 줄임
        } else {
            //개수가 충분히 많이 나온다면
            low = mid + 1 //길이를 늘려 최대길이를 찾을 수 있도록 low증가
        }
    }
    //이분탐색으로 얻어진 값에 -1이 최대 길이
    println(low - 1)
}