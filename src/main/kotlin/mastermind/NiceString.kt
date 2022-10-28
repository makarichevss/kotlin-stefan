package mastermind

fun String.isNice(): Boolean {
    val noBadSubstring = setOf("ba", "be", "bu").none { this.contains(it) }

    val hasThreeVowels = count { it in "aeiou" } >= 3

    val hasDouble = windowed(2).any { it[0] == it[1] }
//    (0 until lastIndex).any { this[it] == this[it] + 1 }
//    zipWithNext().any { it.first == it.second }

    return listOf(noBadSubstring, hasThreeVowels, hasDouble).count { it } >= 2
}