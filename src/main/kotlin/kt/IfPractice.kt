package kt

fun main() {
    var count = 600
    val food = if (count > 500) {
        count -= 500
        "Pizza"
    } else if (count > 300) {
        count -= 300
        "Shaurma"
    } else {
        count -= 30
        "Doshirak"
    }
    println("Купить: $food, осталось $count")
}