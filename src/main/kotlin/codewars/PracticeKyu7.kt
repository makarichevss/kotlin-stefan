package codewars

import java.math.BigInteger
import java.time.LocalDate
import kotlin.math.*

class PracticeKyu7 {

    fun gps(s: Int, x: DoubleArray): Int =
        x.toList().windowed(2) { it[1] - it[0] }.maxOfOrNull { 3600 * it / s }
            ?.toInt() ?: 0

    fun nbDig(n: Int, d: Int): Int =
        (0..n).joinToString("") { a -> "${a * a}" }.count { c -> "$c" == "$d" }

    fun geometricSequenceElements(a: Int, r: Int, n: Int) =
        generateSequence(a) { r * it }.take(n).joinToString(", ")

    fun nbYear(pp0: Int, percent: Double, aug: Int, p: Int) =
        generateSequence(pp0) { (it * (1 + percent / 100) + aug).toInt() }.takeWhile { it < p }
            .count()

    fun movie(card: Int, ticket: Int, perc: Double) =
        generateSequence(1) { it + 1 }.first {
            it * ticket > ceil(
                card + ticket * perc * (1 - perc.pow(it)) / (1 - perc)
            )
        }

    fun newAvg(a: DoubleArray, navg: Double): Long {
        val n = navg * (a.size + 1) - a.sum()
        require(n > 0)
        println("javaClass = $javaClass")
        return ceil(n).roundToLong()
    }

    fun makeComplement(dna: String) = dna.map {
        when (it) {
            'A' -> 'T'
            'C' -> 'G'
            'G' -> 'C'
            'T' -> 'A'
            else -> it
        }
    }.joinToString("")

    fun containAllRots(str: String, arr: ArrayList<String>): Boolean {
        return arr.containsAll(List(str.length) { str.drop(it) + str.take(it) })
    }

    fun highAndLow(numbers: String): String {
        val str = numbers.split(" ").map { it.toInt() }.sortedDescending()
        return "${str.first()} ${str.last()}"
    }

    fun partList(arr: Array<String>): Array<Array<String>> {
        return (0..(arr.size - 2)).map {
            arrayOf(
                arr.take(it).joinToString(" "), arr.drop(it).joinToString(" ")
            )
        }.toTypedArray()
    }

    fun people(busStops: Array<Pair<Int, Int>>) =
        busStops.sumOf { it.first - it.second }

    fun getCount(str: String) = str.count { it in "aeiou" }

    fun findShort(s: String) = s.split(" ").minOf { it.length }

    fun evaporator(
        content: Double,
        evapPerDay: Double,
        threshold: Double
    ): Int =
        generateSequence(content) { it - (it / 100 * evapPerDay) }.takeWhile { it > content / 100 * threshold }
            .count()

    fun growingPlant(upSpeed: Int, downSpeed: Int, desiredHeight: Int): Int =
        when {
            upSpeed >= desiredHeight -> 1
            else -> {
                ceil(1.0 * (desiredHeight - upSpeed) / (upSpeed - downSpeed)).toInt() + 1
            }
        }

    fun reverseLetter(str: String) = str.filter(Char::isLetter).reversed()

    fun predictAge(vararg age: Int) =
        age.sumOf { it * it }.toDouble().let { sqrt(it).toInt() / 2 }

    fun maxMultiple(d: Int, b: Int) = b / d * d

    fun addLetters(arr: List<Char>) = 'z' - arr.sumOf { 'z' - it } % 26

    fun rowSumOddNumbers(n: Int) = n * n * n

    fun inviteMoreWomen(l: List<Int>) = l.sum() > 0

    fun moveTen(s: String): String =
        s.map { 'a' + (((it - 'a') + 10) % 26) }.joinToString("")

    fun longest(s1: String, s2: String): String =
        (s1 + s2).toSortedSet().joinToString(" ")

    fun smallEnough(a: IntArray, limit: Int): Boolean = a.all { it <= limit }

    fun overTheRoad(address: Int, n: Int): Int = n * 2 - address + 1

    fun killKthBit(n: Int, k: Int): Int {
        return n and (1 shl k - 1).inv()
    }

    fun fireFight(s: String) = s.replace("Fire", "~~")

    fun baumSweet(): Iterator<Int> = iterator {
        yield(1)
        var x = 1
        while (true) {
            if (x.toString(2).split("1").any { it.length % 2 == 1 }) yield(0)
            else yield(1)
            x++
        }
    }

    fun printerError(s: String): String {
        return "${s.count { it > 'm' }}/${s.length}"
    }

    fun getMiddle(word: String) =
        word.substring((word.length - 1) / 2..word.length / 2)

    fun accum(s: String) = s.mapIndexed { index, c ->
        c.uppercaseChar() + c.lowercaseChar().toString().repeat(index)
    }.joinToString("-")

    fun makeValley(arr: IntArray): IntArray {
        arr.sortDescending()
        val leftWing = arr.filterIndexed { index, _ -> index % 2 == 0 }
        val rightWing =
            arr.filterIndexed { index, _ -> index % 2 != 0 }.sorted()
        return (leftWing + rightWing).toIntArray()
    }

    fun countRedBeads(nBlue: Int): Int = when {
        nBlue < 2 -> 0
        else -> (nBlue - 1) * 2
    }

    fun maxRot(n: Long): Long {
        var maxN = n
        var str = n.toString()
        for (i in str.indices) {
            str = StringBuilder(str + str[i]).deleteCharAt(i).toString()
            maxN = maxOf(str.toLong(), maxN)
        }
        return maxN
    }

    fun outed(meet: Map<String, Int>, boss: String): String =
        if ((meet.values + (meet[boss] ?: 0)).average() <= 5.0) {
            "Get Out Now!"
        } else "Nice Work Champ!"

    fun intRac(n: Long, guess: Long): Long =
        generateSequence(guess) { (it + n / it) / 2 }.zipWithNext { x, y ->
            abs(x - y)
        }.indexOfFirst { it < 1 } + 1L

    fun mxdiflg(a1: Array<String>, a2: Array<String>): Int {
        return a1.flatMap { maxN -> a2.map { abs(maxN.length - it.length) } }
            .maxOrNull() ?: -1
    }

    fun duplicates(array: IntArray): Int =
        array.groupBy { it }.map { it.value.size / 2 }.sum()

    fun evenNumbers(array: List<Int>, number: Int): List<Int> =
        array.filter { it % 2 == 0 }.takeLast(number)

    fun wallpaper(l: Double, w: Double, h: Double): String {
        val textNum = arrayOf(
            "zero",
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine",
            "ten",
            "eleven",
            "twelve",
            "thirteen",
            "fourteen",
            "fifteen",
            "sixteen",
            "seventeen",
            "eighteen",
            "nineteen",
            "twenty"
        )

        if (l == 0.0 || w == 0.0 || h == 0.0)
            return "zero"

        val roll = ceil((((l + w) * 2.0 * h / 0.52 / 10.0) * 1.15)).toInt()
        return textNum[roll]
    }

    fun dateNbDays(a0: Double, a: Double, p: Double): String {
        val incomeDate =
            generateSequence(a0) { it + it * (p / 100 / 360) }
                .takeWhile { it <= a }.count().toLong()
        return LocalDate.parse("2016-01-01").plusDays(incomeDate).toString()
    }

    fun isLeapYear(year: Int) = (year % 400 == 0) || ((year % 4 == 0) && (year %
            100 != 0))
}

object Opstrings {

    fun vertMirror(strng: String): String = strng.split("\n")
        .joinToString("\n") { it.reversed() }

    fun horMirror(strng: String): String = strng.split("\n")
        .reversed().joinToString("\n")

    fun oper(fn: (String) -> String, s: String): String = fn(s)

    fun count(number: Int): Int {
        val nominal = intArrayOf(500, 200, 100, 50, 20, 10)
        var count = 0
        var remain = number

        while (remain != 0) {
            remain -= nominal.find { it <= remain } ?: return -1
            count++
        }

        return number
    }

    fun potatoes(p0: Int, w0: Int, p1: Int): Int =
        w0 * (100 - p0) / (100 - p1)

    fun seven(n: Long): LongArray {
        var x = n
        var count = 0L
        while (x > 99) {
            x = (x / 10) - (x % 10) * 2
            count++
        }
        return longArrayOf(x, count)
    }

    private fun choose(x: Int, y: Int): BigInteger {
        var num = BigInteger.ONE
        for (i in 0 until y) {
            num = num.multiply(BigInteger.valueOf((x - i).toLong()))
                .divide(BigInteger.valueOf((i + 1).toLong()))
        }
        return num
    }

    fun easyLine(n: Int): BigInteger {
        return choose(2 * n, n)
    }

    tailrec fun prevMultOfThree(n: Int): Int? =
        when {
            n == 0 -> null
            n % 3 == 0 -> n
            else -> prevMultOfThree(n / 10)
        }

    fun twoOldestAges(ages: List<Int>): List<Int> =
        ages.sorted().takeLast(2)

    fun angle(n: Int): Int = 180 * (n - 2)

    fun quadratic(a: Double, b: Double, c: Double): Double = -c / b

    fun infected(s: String): Double {
        val people = s.filter { it != 'X' }.length
        if (people == 0) {
            return 0.0
        }

        val infectedPeople = s.split('X')
            .filter { it.contains('1') }
            .sumOf { it.length }

        return infectedPeople / people.toDouble() * 100
    }

    fun alphabetWar(fight: String): String {
        val res = fight.sumOf { c ->
            (leftLetters.indexOf(c) + 1) -
                    (rightLetters.indexOf(c) + 1)
        }
        return when {
            res > 0 -> "Left side wins!"
            res < 0 -> "Right side wins!"
            else -> "Let's fight again!"
        }
    }

    fun fizzBuzz(n: Int): Array<String> =
        (1..n).map {
            when {
                it % 3 == 0 && it % 5 == 0 -> "FizzBuzz"
                it % 5 == 0 -> "Buzz"
                it % 3 == 0 -> "Fizz"
                else -> "$it"
            }
        }.toTypedArray()

    fun catMouse(s: String): String =
        if (s.length > 5) {
            "Escaped!"
        } else {
            "Caught!"
        }

    fun crap(x: Array<CharArray>, bags: Int, cap: Int): String {
        val garden = x.flatMap { it.toList() }
        return when {
            garden.contains('D') -> "Dog!!"
            garden.count { it == '@' } > (bags * cap) -> "Cr@p"
            else -> "Clean"
        }
    }

    fun squarePi(digits: Int): Int {
        val pi =
            "31415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679"
        return pi.take(digits).map { it.toString().toDouble() }
            .sumOf { it * it }
            .let { ceil(sqrt(it)).toInt() }
    }

    fun argsCount(vararg args: Any): Int = args.size

    fun allRationals(): Iterator<Pair<Int, Int>> = iterator {
        yield(Pair(1, 1))
        allRationals().forEach { (m, n) ->
            yieldAll(
                listOf(
                    Pair(m, m + n),
                    Pair(n + m, n)
                )
            )
        }
    }

    fun capitalize(text: String): List<String> = listOf(
        text.mapIndexed { index, it ->
            if (index % 2 == 0) {
                it.toUpperCase()
            } else {
                it
            }
        }.joinToString(""),
        text.mapIndexed { index, it ->
            if (index % 2 != 0) {
                it.toUpperCase()
            } else {
                it
            }
        }.joinToString("")
    )

    fun catchSignChange(arr: Array<Int>): Int = arr.asSequence()
        .zipWithNext()
        .count { it.first >= 0 != it.second >= 0 }

    fun repeats(arr: IntArray): Int =
        arr.groupBy { it }.filterValues { it.size < 2 }.keys.sum()

    fun nameValue(arr: Array<String>): IntArray =
        arr.indices.map {
            arr[it].replace(" ", "")
                .map { i -> (i.code - 96) * (it + 1) }
                .sum()
        }
            .toIntArray()

    fun leaderBoard(user: String, userScore: Int, yourScore: Int) =
        when {
            userScore == yourScore -> "Only need one!"
            userScore < yourScore -> "Winning!"
            else -> {
                val differ = userScore - yourScore
                val betaK = differ / 3
                val eightK = differ % 3
                "To beat $user's score, I must complete $betaK Beta kata " +
                        "and $eightK 8kyu kata." + if ((betaK + eightK) > 1000)
                    " Dammit!" else ""
            }
        }

    fun findScreenHeight(width: Int, ratio: String): String {
        val (wid, hei) = ratio.split(":")
            .map { it.toInt() }
        return "${width}x${width * hei / wid}"
    }

}

private const val leftLetters = "sbpw"
private const val rightLetters = "zdqm"

object FixStringCase {
    fun solve(s: String): String =
        if (s.count { it.isUpperCase() } > s.length / 2) {
            s.toUpperCase()
        } else {
            s.toLowerCase()
        }
}

object Kata {
    fun grid(n: Int) = when {
        (n < 0) -> null
        else -> (0 until n).joinToString("\n")
        { a ->
            (0 until n).joinToString(" ")
            { b -> 'a' + (a + b) % 26 + "" }
        }
    }
}

class CircularList<T>(private vararg val elements: T) {
    private var el = -1

    init {
        if (elements.isEmpty()) {
            throw Exception()
        }
    }

    fun next(): T {
        el = (el + 1) % elements.size
        return elements[el]
    }

    fun prev(): T {
        el = if (el <= 0) {
            elements.lastIndex
        } else {
            el - 1
        }
        return elements[el]
    }
}

object DoubleSort {
    fun dbSort(a: Array<Any>): Array<Any> {
        val strSort = a.filterIsInstance<String>().sorted()
        val intSort = a.filterIsInstance<Int>().sorted()
        return (intSort + strSort).toTypedArray()
    }
}
