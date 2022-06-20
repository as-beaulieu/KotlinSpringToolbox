# Kotlin Spring-boot toolbox

## What is Kotlin?

Kotlin is a __modern object oriented__ and *functional* programming langauge

Kotlin is *statically typed* language like Java

- All types are resolved at compile time

Free and open source language licensed under Apache 2.0

## Why Kotlin

Kotlin is an expressive language and it has a concise syntax

- Improves readability and maintainability

Kotlin is a safe language which prevents un-necessary errors

- Prevents *NullPointerException* using the Nullable and Non-Nullable types

Interoperable with Java

Support with Spring and Micronaut

## How Kotlin works with JVM

Kotlin files have the **.kt* file extension.

Moves to the Kotlin complier, which transforms it to a **.class* file,
and then to a *.jar* file. This allows it to run in a Java Runtime Environment.

- 1 to 1 conversion style with *.java through Java Compiler to *.class

## Basic Types

In Kotlin, there is no distinction between primitives and wrapper types

- All numbers in Kotlin are represented as types
- Integer -        Byte, Short, Int, Long
- Floating-Point - Float, Double
- Character -      Char
- Boolean -        Boolean

### Val (Value)

Values are immutable variables

`val name: String = "bob"`

### Var (Variables)

Variables can be reassigned

### Int

## Functions

Functions are primarily used in Object Oriented Language to express behavior or logic

```
fun printHello() {
    println("Hello")
}
```

### Type inference in functions

Kotlin can infer the type of the return. Often functions with no return will show as `Unit`

### Unit

Unit in Kotlin corresponds with the `void` type in Java

Unit in Kotlin represents `no value`

### Default Value Parameters

Kotlin allows providing a default value to a function when it is not
passed by the caller

```kotlin
fun printPersonDetails(
    name: String, 
    email: String = "",
    dob: LocalDate = LocalDate.now()
) {
    println("Name is $name and email is $email")
}
```

So that caller does not have to know about every input parameter for a function

Also makes default value parameters optional

### Named Arguments

The caller can invoke the function by using the variable name

No particular order

```kotlin
printPersonDetails(
    dob = LocalDate.parse("2000-01-01"),
    name = "bob",
    email = "test@test.com"
)
```

Have to use either named parameters or not, not recommended to mix

`printPersonDetails(name= "bob", abc)` <- this doesn't work

### Top Level Functions

Functions that do not belong to a class

Compared to Java, where functions can only be part of a class

- In Java applications, you can find classes that just have some static methods
which holds some common logic that can be used across the app
- Kotlin avoids this by using top level functions that can be part of a Kotlin file, not a class

### Top Level Properties

In Kotlin, properties that does not belong to class are top-level properties

- In Java, you can only define properties in a class or interface
- Most common use case in a Java application is to have to define static constants in a class
file that can be used across an application
- Kotlin avoids this by allowing the creation of properties that can be part of a Kotlin file, not a class

Declaring a top level property, InteliJ will recommend to make the variable a `const`

- Could still use the parameter across the project, but is recommended

```kotlin
const val courseName = "Kotlin Programming"
```

## Class

Class in object oriented programming is fundamentally the blueprint for creating objects

```kotlin
class Person {
    fun action() {
        println("Walking")
    }
}

//instance of the class
val person = Person()
person.action()
```

### Primary Constructors

Constructors is a concept in object oriented programming through which we can create 
an Object with initial values

```kotlin
//          V ---- Primary Constructor ---V
class Person(val name: String, val age: Int) {
    fun action() {
        println("Walking")
    }
}

//instance of the class

val person = Person("bob", 33)
```

In Java, normally make getters and setters to access these properties

- not the case in Kotlin
  - can access every property of a class in Kotlin as a field

Kotlin also accepts default values concept to make optional constructor parameters

### Secondary Constructors

Alternative ways of defining constructors

```kotlin
class Item() {
    var name: String = ""
    constructor(_name: String) : this(){
        name = _name
    }
}
```

In this case, using the `constructor` keyword, `this()` is mandatory

this() refers to the primary constructor

Use secondary constructors only when necessary

### Initializer

`init` code block can be used to run some initialization logic during the instance creation

```kotlin
init {
    println("Inside Init Block")
}

```

### Data Class

Classes that just hold data

- DTOs, domain classes and value object classes fall under this category
- In Java, these type of classes are also Java Beans
- Kotlin autogenerates additional functionality when the data keyword is used

```kotlin
data class Course(
  val id: Int,
  val name: String,
  val author: String
)
```

A data class needs to have provided one type of constructor

Data classes add additional properties, useful for checking equality between two instances

- alternative would be to check every property 

#### Cloning

`.copy()` is useful for cloning one data class instance to another

While cloning, can specify if you want different values for any properties

## Assignment 1

- Create a data class named Employee
- Add new fields id and nmae as constructor arguements
- Add a main function and create an object of Employee with id and name
  - print the employee object in the console with println()
- Create another Employee object with the same properties values as the first one
  - Compare the objects and print the value as true
-Use the first object and using the copy function create another object using different properties

### Getters and Setters

In kotlin, getters can access a field directly through a backing field

```kotlin
var price: Double = 0.0
get() = field   //<--- Without any operation to the field, IDE flags as redundant
```

Kotlin provides getters and setters by default

Use custom getters and setters when you have to implement the custom logic for setting
or retrieving the properties. Such as validators.

## Inheritance

Kotlin supports inheritance

Kotlin concepts:

- **Any** is the superclass for any class in Kotlin
  - Equivalent to the **Object** class in Java
- All classes in Kotlin are **final**
  - Extending classes are not allowed by default
- Kotlin allows inheritance when **open** modifier is used
  - Without open keyword, IDE error will read: `This type is final, so it cannot be inherited from`
- Kotlin only allows extending one class. A class cannot extend multiple classes

```kotlin
open class User(val name: String) {
    
    open fun login() {
        println("inside user login")
    }
}
```

Subclass extending the **User** class

- Using the colon (:) operator, invoking the User class and it's constructor

```kotlin
class Student(name: String) : User(name)
```

### Overriding Functions and Variables

- Kotlin allows overriding functions with the **open** modifier
  - Just as the open modifier is added to the class

```kotlin
class Student(name: String) : User(name) {
    
    override fun login() {
        super.login()
        println("Inside student login")
    }
}
```

Variables are same principle, using **open** and **override** keywords

### Object keyword

A special keyword in Kotlin that allows the creation of a class and an instance
at the same time

Equivalent to a **singleton** pattern in Java

```kotlin
object Authenticate {
    fun authenticate(userName: String, password: String) {
        println("User Authenticated for username: $userName")
    }
}

//usage
fun main() {
    // Reference the name of the actual object, then invoke the function
    Authenticate.authenticate("bob", "12345")
}
```

Limitations:

- Cannot inject constructor arguments to object classes
  - Can use Spring to handle constructors and use constructor injection