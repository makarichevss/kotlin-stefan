package codewars

import kotlin.math.ceil
import kotlin.math.pow

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
            .first {it * ticket > ceil(card + ticket * perc * (1 - perc.pow
                (it)) / (1 - perc))
            }
}