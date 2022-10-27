package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    val rightPositions = secret.zip(guess).count { it.first == it.second }
    val commonLetters = "ABCDEF".sumOf { ch ->
        Math.min(secret.count { it == ch }, guess.count { it == ch })
    }
    return Evaluation(rightPositions, commonLetters - rightPositions)
}

fun main() {
    val result = Evaluation(rightPosition = 1, wrongPosition = 1)
    println(evaluateGuess("BCDF", "ACEB") == result)
    println(evaluateGuess("AAAF", "ABCA") == result)
    println(evaluateGuess("ABCA", "AAAF") == result)
}