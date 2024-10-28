
package com.example.mod4demo3

class CandyRepository {

    private val candies = listOf("Roudoudou", "Malabar", "Carambar", "Dragibus", "Stoptou")

    fun getAllCandies(): List<String> {
        return candies
    }

}
