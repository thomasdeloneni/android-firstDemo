package com.example.mod2demo3

//fun main() {
//
//    //fonction d'extension
//    fun String.sayHello() {
//        println("Hello $this")
//    }
//
//    var michel = "Michel";
//    michel.sayHello()
//
//
//}

fun main() {

    val listOfList = mutableListOf("Alphabet", "Liste de courses", "Décimales de Pi", "Notes")

    listOfList.add("Le nom des doigts")
    listOfList += "Les jours de la semaine"

    val count = listOfList.filter {
        it.contains('a')
    }.forEach(::println)

    print(count)
}