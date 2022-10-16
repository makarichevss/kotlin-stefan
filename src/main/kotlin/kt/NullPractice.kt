package kt

fun main() {
    val a: String? = null
    val b: String? = "1234235"
    val c: String? = ""
    val result = (a?.length ?: 0) + (b?.length ?: 0) + (c?.length ?: 0)
    println(result)
}