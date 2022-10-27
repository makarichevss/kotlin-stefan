package mastermind

fun List<Int>.summ(): Int {
    var result = 0
    for (i in this) {
        result += i
    }
    return result
}

fun main() {
    val summ = listOf(1, 2, 3).summ()
    println(summ)
}