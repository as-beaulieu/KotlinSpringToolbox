package com.asbeaulieu.classes

data class Employee (
    val id: String,
    val name: String
)

fun main() {
    val employee = Employee("1", "bob")
    println(employee)

    val employee1 = Employee("1", "bob")
    println("Checking Object Equality: ${employee == employee1}")

    val employee2 = employee1.copy(
        id = "3"
    )
    println(employee2)
}