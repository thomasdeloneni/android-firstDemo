package com.example.mod6demo2

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class CoffeeVarietyDAO(
    val dbw: SQLiteDatabase,
    val dbr: SQLiteDatabase
) {

    fun insertCoffeeVariety(coffeeVariety: CoffeeVariety): Long {
        val values = ContentValues()
        values.put(CoffeeVarietyContract.COLUMN_NAME, coffeeVariety.name)
        values.put(CoffeeVarietyContract.COLUMN_ORIGIN, coffeeVariety.origin)
        values.put(CoffeeVarietyContract.COLUMN_TYPE, coffeeVariety.type.toString())


        val id = dbw.insert(CoffeeVarietyContract.TABLE_NAME, null, values)

        return id
    }

    fun findAllCoffeeVariety(): List<CoffeeVariety> {

        val coffeeVarieties = mutableListOf<CoffeeVariety>()

        val projection = arrayOf(
            BaseColumns._ID,
            CoffeeVarietyContract.COLUMN_NAME,
            CoffeeVarietyContract.COLUMN_ORIGIN,
            CoffeeVarietyContract.COLUMN_TYPE
        )

        val cursor = dbr.query(
            CoffeeVarietyContract.TABLE_NAME,
            projection,
            null,
            null,
            null,
            null,
            null
        )
        with(cursor) {
            while (moveToNext()) {
                val cf = CoffeeVariety(
                    id = getLong(getColumnIndexOrThrow(BaseColumns._ID)),
                    name = getString(getColumnIndexOrThrow(CoffeeVarietyContract.COLUMN_NAME)),
                    origin = getString(getColumnIndexOrThrow(CoffeeVarietyContract.COLUMN_ORIGIN)),
                    type = CoffeeType.valueOf(getString(getColumnIndexOrThrow(CoffeeVarietyContract.COLUMN_TYPE)))
                )

                coffeeVarieties.add(cf)
            }
        }
        cursor.close()
        return coffeeVarieties
    }
}