package randomTasks

class A {
    private lateinit var value: String

    fun setUp() {
        value = "value"
    }

    fun display() {
        println(value)
    }
}

fun main() {
    val a = A()
    a.setUp()
    a.display()
}