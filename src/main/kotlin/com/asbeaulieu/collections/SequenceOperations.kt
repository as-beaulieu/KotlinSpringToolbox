package com.asbeaulieu.collections

import com.asbeaulieu.dataset.Course
import com.asbeaulieu.dataset.CourseCategory
import com.asbeaulieu.dataset.courseList

fun main() {
    val namesListUsingSequence = listOf("bob", "mary", "joe")
        .asSequence()
        .filter { it.length >= 4 }
        .map { it.uppercase() }
        .toList()

    println(namesListUsingSequence)

    val devPredicate = { c: Course -> c.category == CourseCategory.DEVELOPMENT }
    exploreFilterUserSequence(courseList(), devPredicate)

    val range = 1 .. 1000000000
    //range.map { it.toDouble() }.forEach{ println("Value is $it") } Will run out of heap memory because the map is
    //also trying to save it in an intermediate list before converting toDouble()
    range
        .asSequence()//This is manageable because will take items one by one
        .take(48) //but we'll only take the first 48
        .map { it.toDouble() }
        .forEach{ println("Value is $it") }
}

fun exploreFilterUserSequence(
    courses: MutableList<Course>,
    predicate: (Course) -> Boolean
) {
    courses
        .asSequence()
        .filter { predicate.invoke(it) }
        .forEach { println(it) }
}