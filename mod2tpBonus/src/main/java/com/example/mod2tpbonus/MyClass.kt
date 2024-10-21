package com.example.mod2tpbonus

@Suppress("DefaultLocale")
fun moyenneNbrValeurs(){

    println("Entrez le nombre de valeurs à saisir : ")
    val n = readln().toInt()
    var total:Float = 0.0f
    for(item in 1..n){
        println("Valeur: ")
        total += readln().toFloat()
    }
    val moyenne = String.format("%.2f", total / n)
    println("La moyenne des valeurs saisies est $moyenne")
}


fun moyenneWhile() {

    println("Note (-1 pour terminer) : ")
    var total = 0
    var moyenne: Int
    var counter = 0
    var note = readln().toInt()
    while(note != -1){
        val enteredNote = note
        total += enteredNote

        counter++
        println("Note (-1 pour terminer) : ")
        note = readln().toInt()
    }
    moyenne = total / counter
    println("La moyenne des notes est : $moyenne")
}

fun doWhile() {
    var note : Float = 0f
    var totalNote : Float = 0.0f
    var cpt : Int = 0
    do {
        println("Note (-1 pour terminer) : ")
        note = readln().toFloat()
        if(note != -1f){
            totalNote += note
            cpt++
        }
    } while (note != -1f)

    val moyenne = String.format("%.2f", totalNote / cpt)
    println("La moyenne des valeurs saisies est $moyenne")

}

fun main() {
    doWhile()
}