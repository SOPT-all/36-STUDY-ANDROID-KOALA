val br = System.`in`.bufferedReader()

fun main() {
    val (n, s) = br.readLine().split(" ").map { it.toInt() }

    val arr = br.readLine().split(" ").map { it.toInt() }

    //arr 길이를 최대
    var minLength = n + 1
    var sum = 0
    var start = 0

    //지렁이 5 1 3 5 10 천천히 증가-> 넘네? ->앞에서 부터 제거
    for (i in arr.indices) {
        sum += arr[i]

        while (sum >= s) {
            minLength = minOf(minLength ,  i - start + 1)
            sum -= arr[start]
            start += 1
        }
    }

    minLength = if (minLength == n+1) {
        0
    } else{
        minLength
    }

    println(minLength)
}