package com.asbeaulieu.classes

object Authenticate {
    fun authenticate(userName: String, password: String) {
        println("User Authenticated for username: $userName")
    }
}

fun main() {
    Authenticate.authenticate("bob", "12345")
}