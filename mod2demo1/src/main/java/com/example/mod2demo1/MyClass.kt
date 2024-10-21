package com.example.mod2demo1

//fun main() {
//    println("Hello, world!")
//}

fun main() {
    var word = "World";

    val message by lazy {
        "Hello, $word!"
    }

    word = "Michel"

    println(message)
}