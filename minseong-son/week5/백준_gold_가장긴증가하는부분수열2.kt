val br = System.`in`.bufferedReader()

fun main() {
    val a = br.readLine().toInt()
    val input = br.readLine().split(" ").map { it.toInt() }

    val arr = IntArray(a) {0}

    for (i in 0 until input.size) {
        arr[i] = input[i]
    }

    //가장 긴 증가하는 수열 저장할 곳
    val temp = mutableListOf<Int>()

    for (n in arr) {
        //지정된 범위 내에 목록에 요소가 포함되어 있으면 요소의 인덱스를 반환하고,
        //그렇지 않으면 삽입해야 할 위치의 값(-삽입 지점 - 1)을 반환
        val pos = temp.binarySearch(n)

        //temp안에 없다는 뜻이니 기존의 수열이 바뀔 가능성존재
        if (pos < 0) {
            val insert = -(pos + 1) //=(-삽입지점 - 1) = 원래라면 위치할 곳
            //n이 가장 커서 temp에 추가
            if (insert == temp.size) {
                temp.add(n)
            } else {
                //기존 값보다 작은 거로 대체,
                // 10 20 15일때 20을 15로 바꿔서 뒤에 올 수의 가능성을 넓힘
                temp[insert] = n
            }
        }
    }

    println(temp.size)
}