package com.asbeaulieu.functions

import java.time.LocalDate

fun main() {
//    printName("bob")
//    val result = addition_approach1(1, 2)
//    println("result is $result")

    printPersonalDetails("bob", "test@test.com", LocalDate.parse("2000-01-01"))
    printPersonalDetails("bob")
}

// function_name(input paramaters): return type {}
fun addition_approach1(x: Int, y: Int): Int {
    return x + y
}

//using type inference
fun addition_approach2(x: Int, y: Int) = x + y

fun printPersonalDetails(name: String, email: String = "", dob: LocalDate = LocalDate.now()) {
    println("Name is $name, email is $email, and dob is $dob")
}

fun printName(name: String) {
    println("name is: $name")
}
