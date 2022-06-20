package com.asbeaulieu.classes

open class User(var name: String) {
    open var isLoggedIn: Boolean = false
    open fun login() {
        println("inside user login")
    }

    private fun secret() {
        println("secret")
    }

    protected open fun logout() {
        println("logout")
    }
}

class Student(name: String): User(name) {
    override var isLoggedIn: Boolean = false
    override fun login() {
        println("inside student login")
        super.login()
        isLoggedIn = true
    }

    override fun logout() {
        super.logout()
        println("$name has logged out")
    }

    fun goodbye() {
        logout()
    }

     companion object {
        const val noOfEnrolledCourses = 10
         fun country() = "USA"
     }
}

class Instructor(name: String) : User(name)

fun main() {

    val student = Student("alex")
    println("Student's name is: ${student.name}")
    student.login()
    println("Student logged in: ${student.isLoggedIn}")

    val country = Student.country()
    println(country)
    println("Number of enrolled courses: ${Student.noOfEnrolledCourses}")

    val instructor = Instructor("bob")
    println("Instructor's name is: ${instructor.name}")
    instructor.login()

    val user = User("bond")
//    user.secret() <-- can't be called here
//    user.logout() <-- Also can't be used here, only in class or subclasses

    val newStudent = Student("joe")
    newStudent.goodbye()
}

