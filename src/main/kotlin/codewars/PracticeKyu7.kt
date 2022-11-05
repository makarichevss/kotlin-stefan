package codewars

import kotlin.math.*

class PracticeKyu7 {

    fun gps(s: Int, x: DoubleArray): Int =
        x.toList()
            .windowed(2) { it[1] - it[0] }
            .maxOfOrNull { 3600 * it / s }
            ?.toInt() ?: 0

    fun nbDig(n: Int, d: Int): Int =
        (0..n)
            .joinToString("") { a -> "${a * a}" }
            .count { c -> "$c" == "$d" }

    fun geometricSequenceElements(a: Int, r: Int, n: Int) =
        generateSequence(a) { r * it }
            .take(n)
            .joinToString(", ")

    fun nbYear(pp0: Int, percent: Double, aug: Int, p: Int) =
        generateSequence(pp0) { (it * (1 + percent / 100) + aug).toInt() }
            .takeWhile { it < p }
            .count()

    fun movie(card: Int, ticket: Int, perc: Double) =
        generateSequence(1) { it + 1 }
            .first {
                it * ticket > ceil(
                    card + ticket * perc * (1 - perc.pow
                        (it)) / (1 - perc)
                )
            }

    fun newAvg(a: DoubleArray, navg: Double): Long {
        val n = navg * (a.size + 1) - a.sum()
        require(n > 0)
        return ceil(n).roundToLong()
    }

    fun makeComplement(dna: String) =
        dna.map {
            when (it) {
                'A' -> 'T'
                'C' -> 'G'
                'G' -> 'C'
                'T' -> 'A'
                else -> it
            }
        }.joinToString("")

    fun containAllRots(str: String, arr: ArrayList<String>): Boolean {
        return arr.containsAll(
            List(str.length) { str.drop(it) + str.take(it) }
        )
    }

    fun highAndLow(numbers: String): String {
        val str = numbers.split(" ").map { it.toInt() }.sortedDescending()
        return "${str.first()} ${str.last()}"
    }

    fun partlist(arr: Array<String>): Array<Array<String>> {
        return (0..(arr.size - 2)).map {
            arrayOf(
                arr.take(it).joinToString(" "),
                arr.drop(it).joinToString(" ")
            )
        }.toTypedArray()
    }

    fun people(busStops: Array<Pair<Int, Int>>) =
        busStops.sumOf { it.first - it.second }

    fun getCount(str: String) = str.count { it in "aeiou" }

    fun findShort(s: String) = s.split(" ").minOf { it.length }

    fun evaporator(content: Double, evapPerDay: Double, threshold: Double):
            Int = generateSequence(content) { it - (it / 100 * evapPerDay) }
        .takeWhile { it > content / 100 * threshold }
        .count()

    fun growingPlant(upSpeed: Int, downSpeed: Int, desiredHeight: Int): Int =
        when {
            upSpeed >= desiredHeight -> 1
            else -> {
                ceil(1.0 * (desiredHeight - upSpeed) / (upSpeed - downSpeed))
                    .toInt() + 1
            }
        }

    fun reverseLetter(str: String) = str.filter(Char::isLetter).reversed()

    fun predictAge(vararg age: Int) =
        age.sumOf { it * it }
            .toDouble()
            .let { sqrt(it).toInt() / 2 }

    fun maxMultiple(d: Int, b: Int) = b / d * d

    fun addLetters(arr: List<Char>) = 'z' - arr.sumOf { 'z' - it } % 26

    fun rowSumOddNumbers(n: Int) = n * n * n

    fun inviteMoreWomen(l: List<Int>) = l.sum() > 0

    fun moveTen(s: String): String =
        s.map { 'a' + (((it - 'a') + 10) % 26) }.joinToString("")

    fun longest(s1: String, s2: String): String =
        (s1 + s2).toSortedSet().joinToString("")

    fun smallEnough(a: IntArray, limit: Int): Boolean =
        a.all { it <= limit }

    fun overTheRoad(address: Int, n: Int): Int =
        n * 2 - address + 1

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

    fun accum(s: String) =
        s.mapIndexed { index, c ->
            c.uppercaseChar() + c.lowercaseChar()
                .toString().repeat(index)
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
        } else
            "Nice Work Champ!"

    fun intRac(n: Long, guess: Long): Long =
        generateSequence(guess) { (it + n / it) / 2 }
            .zipWithNext { x, y -> abs(x - y) }
            .indexOfFirst { it < 1 } + 1L

    fun mxdiflg(a1: Array<String>, a2: Array<String>): Int {
        return a1.flatMap { maxN -> a2.map { abs(maxN.length - it.length) } }
            .maxOrNull() ?: -1
    }
}

