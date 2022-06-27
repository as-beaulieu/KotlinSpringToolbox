package com.asbeaulieu.collections

//High order function
fun calculate(x: Int, y: Int, operation: (x: Int, y: Int) -> Int): Int {
    return operation(x,y)
}

fun main() {
    val addLambda = {x: Int-> x + x}

    val addResult = addLambda(3)
    println("addResult: $addResult")

    val multiplyLambda = {x: Int, y: Int -> x * y}
    val multiplyResult = multiplyLambda(2, 6)
    println("multiply result: $multiplyResult")

    val result = calculate(2, 3, {a, b -> a * b})
    println("result is $result")

    val result1 = calculate(4, 5) { a, b -> a + b }
    println("result is $result1")
}