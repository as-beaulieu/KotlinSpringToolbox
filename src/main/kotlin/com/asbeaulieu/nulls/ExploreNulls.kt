package com.asbeaulieu.nulls

data class Movie (
    val id: Int?,
    val name: String
)

fun printName(name: String) {
    println("name is $name")
}

fun main() {
    var nameNullable: String?  = null
    nameNullable?.run {
        printName(this)
    }
    println("Value is: ${nameNullable?.length}")  //Safe Operator
//    nameNullable = "bob"
    var length = nameNullable?.length ?: 0 //Elvis operator
    println("length is: $length")

//    var name: String = null //Uncomment to see the error stating about null

    val movie = Movie(null, "Some Movie")
    val savedMovie = saveMovie(movie)
    println(savedMovie.id!!) //Non null assertion
    println(savedMovie)
}

fun saveMovie(movie: Movie): Movie {
    return movie.copy(id = 1)
}
