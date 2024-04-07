package org.example

fun main() {
    println("Hello World!")

    val b = B()
}

open class A{
    open fun foo() {
        println("foo extension in A")
    }
}



class B : A(){
    override fun foo() {
        super.foo()
    }
}