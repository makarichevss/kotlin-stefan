package codewars

import java.lang.ArithmeticException
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
    } catch (_: Exception) {}

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

}

