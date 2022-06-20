package com.asbeaulieu.classes

open class User(var name: String) {
    open var isLoggedIn: Boolean = false
    open fun login() {
        println("inside user login")
    }
}

class Student(name: String): User(name) {
    override var isLoggedIn: Boolean = false
    override fun login() {
        println("inside student login")
        super.login()
        isLoggedIn = true
    }
}

class Instructor(name: String) : User(name)

fun main() {

    val student = Student("alex")
    println("Student's name is: ${student.name}")
    student.login()
    println("Student logged in: ${student.isLoggedIn}")

    val instructor = Instructor("bob")
    println("Instructor's name is: ${instructor.name}")
    instructor.login()
}

