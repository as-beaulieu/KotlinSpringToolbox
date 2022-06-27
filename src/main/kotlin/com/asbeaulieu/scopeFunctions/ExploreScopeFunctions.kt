package com.asbeaulieu.scopeFunctions

import com.asbeaulieu.classes.Course
import com.asbeaulieu.classes.CourseCategory

fun main() {
    exploreApply()
    exploreAlso()
    exploreLet()
    exploreWith()
    exploreRun()
}

fun exploreRun() {
    var numbers: MutableList<Int>? = null
    val result = numbers.run {
        numbers = mutableListOf(1, 2, 3, 4, 5)
        numbers?.sum()
    }
    println("result is $result")

    val resultLength = run {
        val name = "bob"
        println(name)
        name.length
    }

    println("run length is $resultLength")
}

fun exploreWith() {
    val numbers = mutableListOf(1, 2, 3, 4, 5)
    val result = with(numbers) {
        println("size is $size") //remember with this, don't have to call it to use the .size function on it
        val list = plus(4)
        list.sum()
    }

    println("result is $result")
}

fun exploreLet() {
    val numbers = mutableListOf(1, 2, 3, 4, 5)
    val result = numbers.map {
        it * 2
    }.filter {
        it > 5
    }.let {
        println(it)
        it.sum()
    }
    println(result)

    var name: String? = null
    var result1 = name?.let {
        println(it)
        it.uppercase()
    }
    println(result1)

}

fun exploreAlso() {
    val course = Course(
        id = 6,
        name = "Introduction to scoping functions",
        author = "bob"
    ).also {
        it.courseCategory = CourseCategory.DESIGN //Have to explicitly call it
        println("course: $it") //But also is encouraged for additional effects, such as calling the print inside
    }
}

fun exploreApply() {
    val course = Course(
        id = 6,
        name = "Introduction to scoping functions",
        author = "bob"
    ).apply {
        courseCategory = CourseCategory.DESIGN
    }.also {
        println("course: $it")
    }
}
