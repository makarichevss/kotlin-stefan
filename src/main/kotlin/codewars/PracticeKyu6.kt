package codewars

import java.lang.ArithmeticException
import java.util.*
import javax.swing.Box
import kotlin.math.atan2
import kotlin.math.ln
import kotlin.math.sqrt

class PracticeKyu6 {

    operator fun Int.Companion.invoke(s: String) = s.toInt()
    operator fun Long.Companion.invoke(s: String) = s.toLong()
    operator fun Double.Companion.invoke(s: String) = s.toDouble()

    operator fun <T> String.invoke(arg: T) = arg

    fun unless(cond: Boolean, func: () -> Unit) = if (!cond) func() else Unit
    fun until(cond: () -> Boolean, func: () -> Unit) =
        run { while (!cond()) func() }

    fun forceRun(func: () -> Unit) = try {
        func()
    } catch (_: Exception) {
    }

    var concatString = String::plus

    fun log(complex: DoubleArray): DoubleArray {
        val (a, b) = complex
        if (a == 0.0 && b == 0.0) {
            throw ArithmeticException()
        }

        return doubleArrayOf(
            ln(sqrt(a * a + b * b)), atan2(b, a)
        )
    }

    fun loop(random: Random, int: Int): Int {
        repeat(int) {
            random.nextInt()
        }
        return random.nextInt()
    }

    operator fun Box.invoke(x: Box.() -> Unit) = x(this)

    fun decomposeDoubleStrand(doubleStrand: String): String {
        val reverseSeq = doubleStrand.map {
            when (it) {
                'A' -> 'T'
                'G' -> 'C'
                'T' -> 'A'
                'C' -> 'G'
                else -> '0'
            }
        }.reversed().joinToString("")

        val f1 = "Frame 1: ${doubleStrand.chunked(3).joinToString(" ")}"
        val f2 = "Frame 2: ${doubleStrand.take(1)} ${
            doubleStrand.drop(1).chunked(3).joinToString(" ")
        }"
        val f3 = "Frame 3: ${doubleStrand.take(2)} ${
            doubleStrand.drop(2).chunked(3).joinToString(" ")
        }"
        val rf1 = "Reverse Frame 1: ${
            reverseSeq.chunked(3).joinToString(" ")
        }"
        val rf2 = "Reverse Frame 2: ${reverseSeq.take(1)} ${
            reverseSeq.drop(1).chunked(3).joinToString(" ")
        }"
        val rf3 = "Reverse Frame 3: ${reverseSeq.take(2)} ${
            reverseSeq.drop(2).chunked(3).joinToString(" ")
        }"
        return "$f1\n$f2\n$f3\n\n$rf1\n$rf2\n$rf3"
    }

    fun decode(input: String?): String {
        return input!!
            .split("\\u")
            .filter { it.isNotEmpty() }
            .map { it.toInt(16).toChar() }
            .joinToString("")
    }

    fun encode(input: String?): String {
        return input!!
            .map { "\\u%04x".format(it.code) }
            .joinToString("")
    }

    fun extractFileName(dirtyFileName: String): String {
        return dirtyFileName
            .substringAfter("_")
            .substringBeforeLast(".")
    }

    fun jumping(arr: IntArray): Boolean {
        var minJump = arr.size - 1
        for (i in minJump - 1 downTo 0) {
            if (i + arr[i] >= minJump)
                minJump = i
        }
        return minJump == 0
    }

    fun findLast(n: Int, m: Int): IntArray {
        var firstPos = (m - 1) % n
        val players = (1..n).toMutableList()

        while (players.size > 1) {
            players.removeAt(firstPos)
            firstPos = (firstPos + m - 1) % players.size
        }

        return intArrayOf(
            players.first(),
            (n + 1) * (n - m).coerceAtLeast(0) +
                    m * (m - 1).coerceAtMost(n - 1)
        )
    }

    fun numberAndIPaddress(s: String): String =
        if (s.contains("."))
            s.split(".").joinToString("") {
                it.toInt().toString(2).padStart(8, '0')
            }
                .toLong(2).toString()
        else
            s.toLong().toString(2)
                .padStart(32, '0').chunked(8)
                .joinToString(".") { "${it.toInt(2)}" }

    fun winChecker(board: String): Boolean {
        val rgxFirst =
            "XXX......|...XXX...|......XXX|X..X..X|X...X...X|..X.X.X..".toRegex()
        val rgxSecond =
            "OOO......|...OOO...|......OOO|O..O..O|O...O...O|..O.O.O..".toRegex()
        return rgxFirst.containsMatchIn(board) || rgxSecond.containsMatchIn(
            board
        )
    }

    fun findNb(m: Long): Long {
        var a = 0L
        var cube = 0L

        while (cube < m) {
            cube += a * a * a
            a++
        }
        return if (cube == m)
            a - 1
        else
            -1
    }

    fun solution(number: Int): Int {
        return (1 until number).filter {
            it % 3 == 0 || it % 5 == 0
        }.sum()
    }

    fun longestRepetition(s: String): Pair<Char?, Int> {
        if (s.isEmpty()) return Pair(null, 0)
        var a = Pair(s[0], 1)
        var b = a

        s.windowed(2).forEach {
            b = if (it[1] == it[0])
                Pair(it[1], b.second + 1)
            else
                Pair(it[1], 1)

            if (b.second > a.second) {
                a = b
            }
        }
        return a
    }

    fun findEvenIndex(arr: IntArray): Int =
        arr.indices.indexOfFirst {
            arr.take(it).sum() == arr.drop(it + 1).sum()
        }

    fun blackOrWhiteKey(keyPressCount: Int): String {
        return when ((keyPressCount - 1) % 88 % 12) {
            1, 4, 6, 9, 11 -> "black"
            else -> "white"
        }
    }

}

class Leetspeak : Encoder() {

    override fun encode(source: String?): String {
        return (source ?: "").map {
            when (it.toLowerCase()) {
                'a' -> "4"
                'e' -> "3"
                'l' -> "1"
                'm' -> "/^^\\"
                'o' -> "0"
                'u' -> "(_)"
                else -> it
            }
        }.joinToString("")
    }
}

abstract class Encoder {
    abstract fun encode(source: String?): String
}
