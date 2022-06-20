package com.asbeaulieu.classes

data class Course(
    val id: Int,
    val name: String,
    val author: String
)

fun main() {
    val course = Course(1, "Programming", "bob")
    println(course)

    val course1 = Course(1, "Programming", "bob")
    println("Checking Object Equality: ${course == course1}")

    val course3 = course1.copy(
        id = 2,
        author = "bill"
    )

    println(course3)
}