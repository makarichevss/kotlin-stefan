package codewars

import kotlin.math.ceil
import kotlin.math.pow
import kotlin.math.roundToLong

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
        .takeWhile {it > content / 100 * threshold}
        .count()

    fun growingPlant(upSpeed: Int, downSpeed: Int, desiredHeight: Int): Int =
        when {
            upSpeed >= desiredHeight -> 1
            else -> {
                ceil(1.0 * (desiredHeight - upSpeed) / (upSpeed - downSpeed))
                    .toInt() + 1
            }
        }
}