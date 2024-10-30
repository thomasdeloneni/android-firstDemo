package com.example.mod6demo2

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class CoffeeVarietyDbHelper(context: Context) : SQLiteOpenHelper (
    context,
    CoffeeVarietyContract.DATABASE_NAME,
    null,
    CoffeeVarietyContract.DATABASE_VERSION
){


    override fun onCreate(p0: SQLiteDatabase?) {
       p0?.execSQL(CoffeeVarietyContract.CREATE_TABLE_QUERY)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL(CoffeeVarietyContract.DROP_TABLE_QUERY)
        onCreate(p0)
    }
}