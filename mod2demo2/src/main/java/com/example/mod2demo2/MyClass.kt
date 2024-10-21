package com.example.mod2demo2

//fun main() {
//
//    //conditions
//    val age = 18;
//
//    val message = if (age == 18) {
//        "Majeur"
//    } else {
//        "Mineur"
//    }
//    println(message)
//
//
//
//}
//
//fun main() {
//
//    //when = switch
//    var age = 18;
//
//    when(age) {
//        1,2 -> println("Bébé");
//        in 2..18 -> println("Enfant");
//        is Int -> println("Ce n'est plus un enfant");
//        else -> println("C'est autre chose");
//    }
//
//
//}

fun main() {

    val africanCountries = arrayOf("Nigeria", "Ghana", "Kenya", "South Africa", "Egypt");

    //for each classique
    for (country in africanCountries) {
        println(country);
    }

    //foreach avec clé
    for ((index, country) in africanCountries.withIndex()) {
        print(index);
        println(country);
    }

    //for classique

    for (i in 0..10) {
        println(i);
    }

    //decrementation
    for (j in 10 downTo 0) {
        println(j);
    }

    //decrementation de deux en deux (modification du pas)
    for (j in 10 downTo 0 step 2) {
        println(j);
    }


    //mutableListOf -> liste modifiable, listOf -> liste non modifiable
    var asianCountries = mutableListOf("China", "Japan", "India", "South Korea", "Indonesia");



    var list = List(10) { id ->
        "Item $id"
    }

    for (item in list) {
        println(item);
    }
}