package com.example.mod6demo3.bo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Tree(
    @PrimaryKey(autoGenerate = true)
    var id : Long = 0,
    var name : String,
    var lifeExpectancy : Int,
    @ColumnInfo(name = "donne_des_fruits")
    var fruitful : Boolean
)
