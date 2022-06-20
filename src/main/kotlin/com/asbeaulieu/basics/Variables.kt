package com.asbeaulieu.basics

import com.asbeaulieu.functions.courseName
import com.asbeaulieu.functions.topLevelFunction

fun main() {
    val name : String = "bob"
    println(name)

    var age : Int = 34
    println(age)
    age = 37
    println(age)

    //Kotlin has Type Inference
    val salary = 30000L
    println(salary)

    //String Interpolation
    val course = "Kotlin Spring"
    println("course: $course")
    //String Interpolation with a function
    println("course: $course and the course length is ${course.length}")

    val multiline = "ABC \n DEF"
    println(multiline)
    //Kotlin Triple Quote Strings
    val multiLine1 = """
        ABC
        DEF
    """.trimIndent()
    println(multiLine1)

    //From Top Level Functions and Parameters
    val num = topLevelFunction()
    println("Num is $num")
    println("course name: $courseName")
}