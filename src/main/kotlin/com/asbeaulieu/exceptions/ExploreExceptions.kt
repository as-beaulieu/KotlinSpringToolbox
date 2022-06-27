package com.asbeaulieu.exceptions

fun main() {
    println(nameLength("bob"))
    println(nameLength(null)) //Will cause a NullPointerException

//    returnNothing()
}

fun nameLength(name: String?): Int? {
    return try {
        name!!.length
    } catch (ex: Exception) {
        println("Exception is: $ex")
        null
    }
}

fun returnNothing(): Nothing {
    throw RuntimeException()
}
