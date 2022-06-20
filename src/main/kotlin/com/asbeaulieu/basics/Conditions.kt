package com.asbeaulieu.basics

fun main() {
    val name = "bob"
    val result = if (name.length === 3) {
        println("Name is three characters")
        //In Kotlin, if/else is also an expression which means this will always return a value
        name.length
    } else {
        println("name is not three characters")
        name.length
    }

    println("result: $result")

    //1 -> GOLD, 2 -> SILVER, 3 -> BRONZE
    var position = 1
    var medal = if (position == 1){
        "GOLD"
    } else if(position == 2){
        "SILVER"
    } else if (position == 3) {
        "BRONZE"
    } else {
        "NO MEDAL"
    }

    println(medal)

    position = 2
    medal = when (position) {
        1 -> "GOLD"
        2 -> "SILVER"
        3 -> {
            println("Inside position 3")
            "BRONZE"
        }
        else -> "NO MEDAL"
    }
    println(medal)
}