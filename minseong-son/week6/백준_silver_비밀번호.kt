val br = System.`in`.bufferedReader()

fun main() {
    val (S, P) = br.readLine().split(" ").map { it.toInt() }

    val dna = br.readLine().toString()

    val (A,C,G,T) = br.readLine().split(" ").map { it.toInt() }

    var answer = 0
    val count = IntArray(4)

    //초기 슬라이딩 윈도우 세팅
    for (i in 0 until P) {
        add(dna[i], count)
    }
    if (isValid(count,A,C,G,T)) {
        answer += 1
    }

    //슬라이딩 직접구현
    for (j in P until S) {
        //이미 앞에서 초기화한 거에서 앞내용 빼고
        remove(dna[j - P], count)
        //다시 새거 더해줌
        add(dna[j], count)
        if (isValid(count,A,C,G,T)) {
            answer += 1
        }
    }

    //연속된 부분 문자열의 길이를 구하기 위해 슬라이딩윈도우 기법 사용
    //카운트 하여 최소 갯수 만족하는지 판단
    //메모리초과
    /*val answer = dna.windowed(size = P)
        .count { window ->
            val aCount = window.count { it == 'A' }
            val cCount = window.count { it == 'C' }
            val gCount = window.count { it == 'G' }
            val tCount = window.count { it == 'T' }

            aCount >= A && cCount >= C && gCount >= G && tCount >= T
        }*/



    print(answer)
}

fun add(c: Char, count: IntArray) {
    when (c) {
        'A' -> count[0] += 1
        'C' -> count[1] += 1
        'G' -> count[2] += 1
        'T' -> count[3] += 1
    }
}

fun remove(c: Char, count: IntArray) {
    when (c) {
        'A' -> count[0] -= 1
        'C' -> count[1] -= 1
        'G' -> count[2] -= 1
        'T' -> count[3] -= 1
    }
}

fun isValid(count : IntArray, a : Int, c : Int, g : Int, t : Int) : Boolean {
    return count[0] >= a && count[1] >= c && count[2] >= g && count[3] >= t
}