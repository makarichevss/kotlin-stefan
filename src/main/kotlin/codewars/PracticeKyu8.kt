package codewars

import java.util.*
import java.util.Collections.max
import kotlin.math.abs

class PracticeKyu8 {

    fun makeNegative(x: Int) = abs(x)

    fun twiceAsOld(dadYearsOld: Int, sonYearsOld: Int): Int =
        abs(
            dadYearsOld - (sonYearsOld * 2)
        )

    fun maps(x: IntArray): IntArray = x.map { it * 2 }.toIntArray()

    fun century(number: Int): Int = (number + 99) / 100

    fun makeUpperCase(str: String) = str.uppercase(Locale.getDefault())

    fun oddCount(n: Int) = n / 2

    fun doubleInteger(i: Int) = i * 2

    fun countPositivesSumNegatives(input: Array<Int>?): Array<Int> {
        if (input.isNullOrEmpty())
            return emptyArray()
        val (pos, neg) = input.partition { it > 0 }
        return arrayOf(pos.count(), neg.sum())
    }

    fun include(arr: IntArray, item: Int) = item in arr

    fun points(games: List<String>): Int {
        var result = 0
        games.map {
            if (it[0] > it[2]) result += 3
            if (it[0] == it[2]) result += 1
        }
        return result
    }

    fun areaOrPerimeter(l: Int, w: Int) =
        when {
            l == w -> l * w
            else -> (l + w) * 2
        }

    fun summation(n: Int) = (1..n).sum()

    fun feast(beast: String, dish: String) =
        beast.first() == dish.first() &&
                beast.last() == dish.last()

    fun expressionsMatter(a: Int, b: Int, c: Int) =
        max(listOf(a * b * c, a * (b + c), (a + b) * c, a + b + c))

    fun move(pos: Int, roll: Int) =
        pos + roll * 2

    fun simpleMultiplication(n: Int) =
        if (n % 2 == 0) {
            n * 8
        } else {
            n * 9
        }

    fun abbrevName(name: String) =
        name.split(" ").joinToString(".") { it.take(1).uppercase() }

    fun noSpace(x: String) =
        x.replace(" ", "")

    fun greet(name: String) =
        "Hello, $name how are you doing today?"

    fun repeatStr(r: Int, str: String) = str.repeat(r)

    fun reverseWords(str: String) = str.split(" ").reversed().joinToString(" ")

    fun removeChar(str: String) = str.subSequence(1, str.lastIndex)

    fun isDivisible(n: Int, x: Int, y: Int) = listOf(n % x, n % y)
        .all { it == 0 }

    fun seatsInTheater(nCols: Int, nRows: Int, col: Int, row: Int) =
        (nRows - row) * (nCols - col + 1)

    fun checkForFactor(base: Int, factor: Int) = base % factor == 0

    fun grow(arr: IntArray) = arr.reduce(Int::times)

    fun opposite(number: Int) = -number

    fun past(h: Int, m: Int, s: Int) =
        (h * 3600 + m * 60 + s) * 1000

    fun multiply(x: Double, y: Double) = x * y

    fun digitize(n: Long) =
        n.toString().reversed().map { it.digitToInt() }.toIntArray()

    fun subtractSum(n: Int) = "apple"

    fun evenOrOdd(number: Int) = if (number % 2 == 0) {
        "Even"
    } else {
        "Odd"
    }

    fun numberToString(num: Int) = num.toString()

    fun reverseSeq(n: Int) = (n downTo 1).toList()

    fun sum(numbers: IntArray) = numbers.filter { it > 0 }.sum()

    fun sum(mixed: List<Any>): Int =
        mixed.sumOf {
            when (it) {
                is Int -> it
                is String -> it.toInt()
                else -> 0
            }
        }

    fun loveFun(flowerA: Int, flowerB: Int) =
        (flowerA + flowerB) % 2 == 1

    fun findSmallestInt(nums: List<Int>) = nums.minOrNull()

    fun stringToNumber(str: String) = str.toInt()

    fun greet() = "hello world!"

    fun litres(time: Double) = time.toInt() / 2

    fun invert(arr: IntArray) = arr.map { -it }.toIntArray()

    fun calculateYears(years: Int) =
        when (years) {
            1 -> arrayOf(1, 15, 15)
            2 -> arrayOf(years, 24, 24)
            else -> arrayOf(years, 24 + 4 * (years - 2), 24 + 5 * (years - 2))
        }

    fun getAge(yearsOld: String) = yearsOld.take(1).toInt()

    fun replace(s: String) = s.replace(Regex("[aeiouAEIUO]"), "!")
}