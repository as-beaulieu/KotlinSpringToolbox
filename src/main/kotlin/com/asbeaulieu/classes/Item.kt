package com.asbeaulieu.classes

class Item() {
    var name: String = ""
    var price: Double = 0.0
//    get() = field
    get(){
        println("inside getter with backing field")
        return field
    } //<-- verbose syntax
    set(value) {
        if (value >= 0.0) {
            println("inside setter")
            field = value
        } else {
            throw IllegalArgumentException("Negative price is not allowed!")
        }
    }

    constructor(_name: String) : this(){
        name = _name
    }
}

fun main() {
    val item = Item("Box")
    println("Item name is ${item.name}")
    item.name = "Big box"
    println("Item name is ${item.name}")

    item.price = 10.0
    println(item.price)
}