package com.asbeaulieu.collections

import com.asbeaulieu.dataset.Course
import com.asbeaulieu.dataset.CourseCategory
import com.asbeaulieu.dataset.KAFKA
import com.asbeaulieu.dataset.courseList

fun main() {
    val courses = courseList()

    val developmentFilter = { course: Course -> course.category == CourseCategory.DEVELOPMENT}
    val busnessFilter = { course: Course -> course.category == CourseCategory.BUSINESS}
    val designFilter = { course: Course -> course.category == CourseCategory.DESIGN}

    exploreFilter(courses, developmentFilter)
    exploreFilter(courses, designFilter)

    exploreMap(courses)

    exploreAdvancedMap(courses, developmentFilter)

    val listOfList = listOf(listOf(1, 2, 3), listOf(4, 5, 6))
    val flatMapList = listOfList

    listOfList.map { outer ->
        outer.map {
            it.toDouble()
        }
    }.let {
        println(it)
    }

    flatMapList.flatMap { outer ->
        outer.map {
            it.toDouble()
        }
    }.let { println(it) }

    println(exploreFlatMapFiltering(courses, KAFKA))

    exploreHashMap()

    collections_nullability()
}

fun collections_nullability() {
    var list: MutableList<String>? = null
    list = mutableListOf() //Initializing the list eliminates nullable ?. in working on a nullable list
    list.add("bob")
    list.forEach {
        println("Value is $it")
    }

    var list1 : List<String?> = listOf("bob", null, "mary")
    list1.forEach {
        println("Value is ${it?.length}")
    }
}

fun exploreHashMap() {
    val nameAgeMutableMap = mutableMapOf("Bob" to 33, "Mary" to 34)
    nameAgeMutableMap.forEach {(k, v) ->
        println("Key: $k's value is $v")
    }

    println("Bob's value is ${nameAgeMutableMap.get("Bob")}")

    val valueOrElse = nameAgeMutableMap.getOrElse("Bobby") {"abc"}
    println(valueOrElse)
}

fun exploreFlatMapFiltering(courses: MutableList<Course>, search: String): List<String> {
    return courses.flatMap { course ->
        val courseName = course.name
        course.topicsCovered.filter {
            it.equals(search)
        }.map {
            courseName
        }
    }
}

fun exploreMap(courses: MutableList<Course>) {
//    val courseNames = courses.map { it.name }
    courses
        .map { "${it.name} - ${it.category}" }
        .forEach { println(it) }
}

fun exploreAdvancedMap(courses: MutableList<Course>, predicate: (Course) -> Boolean) {
    courses
        .filter{ predicate.invoke(it)}
        .map { "${it.name} - ${it.topicsCovered}" }
        .forEach { println(it) }
}

fun exploreFilter(courses: MutableList<Course>,
                  predicate: (Course) -> Boolean
) {
    courses
//        .filter { course.category == CourseCategory.DEVELOPMENT}
        .filter { predicate.invoke(it) }
        .forEach { println(" courses: $it") }

}
