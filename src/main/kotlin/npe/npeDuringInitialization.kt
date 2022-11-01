package npe

open class A(val value: String) {
    init {
        value.length
    }
}

class B(value: String) : A(value)

fun main() {
    val b = B("a")
    println(b.value)
}