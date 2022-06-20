package com.asbeaulieu.interfaces

import com.asbeaulieu.classes.Course

interface CourseRepository {
    var isCoursePersisted: Boolean

    fun getById(id: Int): Course

    fun save(course: Course): Int {
        println("course: $course")
        return course.id
    }
}

interface Repository {
    fun getAll(): Any
}

class SqlCourseRepository: CourseRepository, Repository {
    override var isCoursePersisted: Boolean = false

    override fun getById(id: Int): Course{
        return Course(
            id = id,
            "Programming using Spring and Kotlin",
            "bob"
        )
    }

    override fun save(course: Course): Int {
        isCoursePersisted = true
        println("Course saved in sql repository: $course")
        return super.save(course)
    }

    override fun getAll(): Any {
        return 1
    }
}

class NoSqlCourseRepository: CourseRepository {
    override var isCoursePersisted: Boolean = false

    override fun getById(id: Int): Course{
        return Course(
            id = id,
            "Programming using Spring and Kotlin",
            "bob"
        )
    }

    override fun save(course: Course): Int {
        println("Course saved in nosql repository: $course")
        return super.save(course)
    }
}

//Conflicting interface functions
interface A {
    fun doSomething() {
        println("Do something in A")
    }
}

interface B {
    fun doSomething() {
        println("Do something in B")
    }
}

class AB: A, B {
    override fun doSomething() {
        super<A>.doSomething()
        super<B>.doSomething()
        println("do something in AB")
    }
}

fun main() {
    val sqlCourseRepository = SqlCourseRepository()
    val course = sqlCourseRepository.getById(1)
    println("Course is $course")
    val course1Id = sqlCourseRepository.save(course)
    println("Saved Id: $course1Id")
    println("Course persisted value is ${sqlCourseRepository.isCoursePersisted}")

    val noSqlCourseRepository = NoSqlCourseRepository()
    val course2 = sqlCourseRepository.getById(2)
    println("Course is $course2")
    val course2Id = noSqlCourseRepository.save(course2)
    println("Saved Id: $course2Id")
    println("Course persisted value is ${noSqlCourseRepository.isCoursePersisted}")

    val ab = AB()
    ab.doSomething()
}