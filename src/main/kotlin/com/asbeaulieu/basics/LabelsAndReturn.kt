package com.asbeaulieu.basics

fun main() {
    for (i in 1..5) {
        println("i in $i")
        if (i==3) break
    }

    label()

    for (i in 1 ..5){
        println("i in $i")
        if (i==3) return
    }

    //Will not run because of return
    println("End of program")
}

fun label() {
    //A label is a name followed by the @ annotation
    loop@ for (i in 1..5) {
        println("i in label $i")
        //A label is called with the @ annotation followed by the label name
//        if (i==3) break@loop
        innerloop@ for (j in 1..5) {
            println("j in label $j")
            if (j==2) break@innerloop
        }
    }

}
