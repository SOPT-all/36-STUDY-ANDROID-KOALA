package Koala.Week1


fun main() = with(System.`in`.bufferedReader()) {


    val stack = arrayListOf<Int>()
    val num = readLine().toInt()
    val output = StringBuilder()

    for (i in 1..num) {

        val tmp = readLine().split(" ")

        when (tmp[0]) {

            "push" -> {
                stack.add(tmp[1].toInt())
            }

            "pop" -> {
                if (stack.isNotEmpty()) output.appendLine(stack.removeAt(stack.size - 1))
                else output.appendLine("-1")
            }

            "size" -> {
                output.appendLine(stack.size)
            }

            "empty" -> {
                if (stack.isEmpty()) output.appendLine("1")
                else output.appendLine("0")
            }

            "top" -> {
                if (stack.isNotEmpty()) output.appendLine(stack[stack.size - 1])
                else output.appendLine("-1")
            }
        }
    }

    print(output)

}
