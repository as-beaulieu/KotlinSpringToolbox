package com.asbeaulieu.cast

import com.asbeaulieu.classes.Course

fun main() {
    val course = Course(1, "Programming", "bob")

    checkType(course)
    checkType("BOB")
    
    //manual casting
    castNumber(1.0)
//    castNumber(1) //Won't work
    safeCastNumber(1)
}

fun castNumber(input: Any) {
    when(input) {
        input as Double -> println("Value is double")
    }
}

fun safeCastNumber(input: Any) {
    when(input) {
        input as? Double -> println("Value is double")
        input as? Int -> println("value is integer")
    }
}

fun checkType(type: Any) {
    when(type) {
        // Once it is determined to be true on an is, it is smart casted to that type
        is Course -> println(type.copy(id = 6))
        is String -> println(type.lowercase())
        else -> println("Bad Type!")
    }
}
