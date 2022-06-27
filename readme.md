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

### Companion Object

- Kotlin does not support for the **static** keyword
- **Companion Object** can be used to introduce static functions and variables
that are tied to a class
- Static items in a companion object do not need an instance of that class to be invoked
- Variables inside a companion object are recommended to have the `const` keyword

```kotlin
class Student(name: String, override val age: Int = 0) : User(name, age) {
    
    companion object {
        const val noOfEnrolledCourses = 10
      
      fun country(): String {
          return "USA"
      }
    }
}
```

## Interfaces

- Defines the contract which has some abstract methods
  - Interface abstract functions do not have any logic in them
    - Any class that implements the interface handles the logic
- Similar to Java, but Kotlin interfaces can have abstract and non-abstract
methods in them
  - Still have the opportunity to override a non-abstract method from an interface
in the implementing class
- Interfaces cannot contain any state
- A class can inherit from multiple interfaces, but cannot extend more than one class

```kotlin
interface CourseRepository {
    fun getById(id: Int): Course
}

//implementation
class SqlCourseRepository: CourseRepository {
    override fun getById(id: Int): Course{
        return Course(
          id = id,
          "Programming using Spring and Kotlin",
          "bob"
        )
    }
}

//interface with abstract and non-abstract methods
interface CourseRepository {
    fun getById(id: Int): Course
    
    fun save(course: Course): Int {
        println("course: $course")
        return course.id
    }
}
```

### Handling conflicting functions

Handling conflicting functions can be handled with some Generics

```kotlin
override fun doSomething() {
        super<A>.doSomething()
        super<B>.doSomething()
        println("do something in AB")
    }
```

### Defining and Overriding Variables

Can persist variables in an interface

## Visibility Modifiers

4 modifiers in Kotlin:
- public
  - Default modifier, applied if none are explicitly added
- protected
  - Visible in the class and any subclasses
- private
  - Marks the function or variable accessibly only to that class
- internal
  - New to Kotlin
  - Private to the module that's published using Gradle or Maven

## Type Checking, Casting, and Smart Cast

### is

- Check a particular value is of a certain type
  - Same as `instance of` operator in Java
- Returns a boolean

```kotlin
val name = "bob"
val result = name is String
```

### as

- Cast a value to a certain type
- If cast is not possible, throws `java.lang.ClassCastException`

```kotlin
val name = "bob" as String
```

#### as?

Will only perform the casting if it is possible

### Manual Casting

In Kotlin, have to be explicit about manually casting a type in order to avoid
a `ClassCastException`

### Smart Casting

Once Kotlin has identified the type through an **as** or **is**, then no longer
needs a type assignment to that object

## Enum

## Nullable and Non-nullable types

### Nulls in Kotlin

- Kotlin handles nulls differently than Java
- Kotlin has the concept of **Nullable** and *Non-nullable** types
- These can be assigned to variables or properties in a class

#### Nullable Type

- A variable or property can hold a null value, or a valid value for its type
- noted with a `?` symbol after the variable or property

```kotlin
val nameNullable: String? = null

//or

val nameNullable: String? = "bob"
```

#### Non-nullable type

- A variable or property can hold only a non-null value
- By default types are non-nullable whenever declared without a `?`
- Null value is not allowed, and will thrown an exception at compilation

### Dealing with Null Values

Could wrap around a if (value != null), but that's Java

#### Safe Call

- `?`
- Use the safe call operator to invoke functions safely on it
- perform this operation, only if value is not null, or return null

#### Elvis Operator

- `?:`
- Return a default value if null
- use the value, or perform the following if null


#### Non Null Assertion

- `!!`
- Making sure the value is not null after some updates or operations

### Assigning a nullable type to a non nullable type

## Collections

Kotlin reuses the collections from Java

Added a lot to default collections through extension functions

Kotlin can still infer types in the collections

Two types of collections: Mutable and Immutable

### Immutable

- Not modified once created

```kotlin
val names = listOf("bob", "bill", "susan")

hashMapOf("bob" to 33, "susan" to 38)
```

### Mutable

- Modifying the data in the collection is allowed

```kotlin
val namesMutableList = mutableListOf("bob", "bill", "susan")

mutableMapOf("doug" to 33, "Kathy" to 28)
```

## Lambda Expressions

A small piece of code that can be passed to other functions

```
{ x: Int -> x * x }
Lambda      Lambda
Input       Body
Argument
```

- You can assign the behavior to a variable
- Have to assign a type; there is no type inference in lambdas

### Lambdas and High Order Functions

High order functions accept other functions in their parameters, or returns another function

If you have the lambda as the last parameter in a Kotlin High Order Function, can move it out of the
parenthesis

## Filters and operations on collections

### Filter

```kotlin 
val numList = listOf(1, 2, 3, 4, 5, 6)

val result = numList.filter {
  it >= 5
}
```

## map operations

- Used to transfer the elements from one form into another form

```kotlin
val numList = listOf(1, 2, 3, 4, 5, 6)

numList.map{
    it.toDouble()
}
```

### flatMap

- used if the collection has another collection
- Used to flatten the list of lists that is being operated on and
returns a single list

### hashmaps

### getOrElse()

- if the value is not present, can set the value

```kotlin
val something = mutableMapOf("mary" to 33)
val value = something.getOrElse("bob") {"abc"}
```

### .containsKey

- will return a boolean on if the given key is present in the collection

### Lazy Evaluation of Collections using Sequences

- An alternative API to work with collections
- Operations on elements of the collection are evaluated lazily
- Sequences perform better when dealing with collections that are
extremely big
  - Does not create intermediate collection for each operator
  - Sequences are lazy, does not apply the operations for all the elements
in the collection
  - Also requires a terminal operator to transform away from a sequence

```kotlin
val namesListUsingSequence = listOf("bob", "mary")
  .asSequence()
  .filter { it.lengty >= 4 }
  .map { it.uppercase() }
  .toList() // Terminal Operator for pipeline
```

### nullability in collections

## Exceptions in Kotlin

- All exceptions in Kotlin extends the Throwable class
- Kotlin does not have checked exceptions
- try/catch blocks work much like in Java
  - the try/catch block in Kotlin is an expression

### Nothing type

A type that has no instances. a function that returns a Nothing type
will always throw an exception

## Scope Functions

https://kotlinlang.org/docs/scope-functions.html

- These functions are an enhancement from Kotlin
- They execute a piece of code within the context of the object
- These functions form a **temporary scope**
- Accepts a lambda and has access to the value of the object
- **let**, **run**, **with**, **apply**, and **also**
- Can chain multiple scoping functions together

### **_apply_** and **_also_**

- both return the context object, and is an extension function
- **_apply_** is used for object configuration
- **_also_** is used for additional effects

### _this_ and _it_

- both are the context object in the scope function lambda
- _this_ is used as a lambda receiver
  - Usually don't have to provide the _this_ reference
  - Example: `$length` instead of `$this.length`
- _it_ is used as a lambda argument

### let

- the context object is available as an argument `it`
- the return value is the lambda result
- _**let**_ can be used to invoke one or more functions on results
of call chains

### _with_ and _run_

- These two scoping functions are not extension functions
- context object is passed as an argument
  - but inside the lambda it's available as a receiver
- return value is the lambda result
- **_with_** is best for operating on the context object itself
- _**run**_ invokes as `let` - an extension function of the context object
  - But can be ran like a `when` without applying directly to a specific object
- **_run_** is useful when your lambda contains both the object initialization and the
computation of the return value


