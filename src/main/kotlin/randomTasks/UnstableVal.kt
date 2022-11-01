package randomTasks

import kotlin.random.Random

var counter = 0

val foo: Int
    get() = Random.nextInt()

fun main() {
    println(foo)
    println(foo)
    println(foo)
}