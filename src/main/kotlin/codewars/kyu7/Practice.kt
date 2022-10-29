package codewars.kyu7

class Practice {

    fun gps(s:Int, x:DoubleArray): Int =
        x.toList()
            .windowed(2) { it[1] - it[0] }
            .maxOfOrNull { 3600 * it / s }
            ?.toInt() ?: 0
}