package com.example.mod6demo2

class CoffeeRepository(private val coffeeVarietyDao: CoffeeVarietyDAO) {

    fun insert(coffeeVariety: CoffeeVariety) : Long {
        return coffeeVarietyDao.insertCoffeeVariety( coffeeVariety)
    }

    fun findAll(): List<CoffeeVariety> {
        return coffeeVarietyDao.findAllCoffeeVariety()
    }
}