package com.asbeaulieu.classes

class Person(
    val name: String = "",
    val age: Int = 0
) {
    var email: String = ""
    var nameLength: Int = 0
    init {
        println("Inside Init Block")
        nameLength = name.length
    }


    constructor(
        _email: String,
        _name: String = "",
        _age: Int = 0
    ): this(_name, _age) {
        email = _email
    }


    fun action() {
        println("Do something")
    }

}

fun main() {
    val person = Person("bob", 33)
    person.action()
    println("Name: ${person.name}, Age: ${person.age}")

    val person1 = Person()
    println("Name: ${person1.name}, Age: ${person1.age}")

    val person2 = Person(_email = "abc@test.com", "bob", 33)
    println("Name: ${person2.name}, Age: ${person2.age}, Email: ${person2.email}, name length: ${person2.nameLength}")
}