package kt

fun main() {
    val month = "Март"
    val season: String = when (month) {
        "Декабрь", "Январь", "Февраль" -> {
            "Зима"
        }
        "Март", "Апрель", "Май" -> {
            "Весна"
        }
        else -> {
            "Нет такого месяца"
        }
    }
    println(season)

    val month2 = 3
    val season2: String = when (month2) {
        in 4..6 -> {
            "Зима"
        }
        8, 4, 1 -> {
            "Весна"
        }
        else -> {
            "Нет такого месяца"
        }
    }
    println(season2)

    val time = 23
    val isFineWeather = true
    val result = when {
        time in 6..22 && isFineWeather -> {
            "Гулять"
        }
        time in 6..22 && !isFineWeather -> {
            "Читать книгу"
        }
        else -> {
            "Спать"
        }
    }
    println(result)
}