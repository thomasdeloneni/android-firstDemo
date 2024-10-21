package com.example.mod2demo4

interface Interfacable {

    var number  : Int;

    fun truc(machin: String) : String;

    fun bidule() : Int{
        return (0..10).random()
    }
}

class Class() : Interfacable {
    override var number: Int = 45
    override fun truc(machin: String): String {
        return "Hello $machin"
    }

    override fun bidule() : Int {
        return super.bidule() + 10
    }
}

fun main() {
    val c = Class()
    println(c.truc(machin = "Michel"))
    println(c.bidule())
}