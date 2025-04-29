fun solution(clothes: Array<Array<String>>): Int =
    clothes
        .groupBy({ it[1] })
        .values
        .fold(1) { acc, items -> acc * (items.size + 1) } - 1