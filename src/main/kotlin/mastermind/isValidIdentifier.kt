package mastermind

fun isValidIdentifier(s: String): Boolean {
    fun isValidCharacter(ch: Char) =
        ch == '_' || ch in '0'..'9'
                || ch in 'a'..'z' || ch in 'A' ..'Z'
    if (s.isEmpty() || s.first().isDigit()) return false
    for (ch in s) {
        if (!isValidCharacter(ch)) return false
    }
    return true
}

fun main() {
    println(isValidIdentifier("name"))
    println(isValidIdentifier("_name"))
    println(isValidIdentifier("_12"))
    println(isValidIdentifier("12a"))
}