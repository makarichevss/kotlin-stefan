package codewars.kyu8

import java.util.*
import kotlin.math.abs

class Practice {

    fun makeNegative(x: Int) = abs(x)

    fun twiceAsOld(dadYearsOld: Int, sonYearsOld: Int): Int = abs(dadYearsOld
            - (sonYearsOld * 2))

    fun maps(x: IntArray): IntArray = x.map { it * 2}.toIntArray()

    fun century(number: Int): Int = (number + 99) / 100

    fun makeUpperCase(str: String) = str.uppercase(Locale.getDefault())
}