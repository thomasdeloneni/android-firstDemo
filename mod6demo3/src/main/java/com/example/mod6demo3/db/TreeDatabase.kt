package com.example.mod6demo3.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mod6demo3.bo.Tree
import com.example.mod6demo3.dao.TreeDAO

@Database(entities = [Tree::class], version = 1)
abstract class TreeDatabase : RoomDatabase() {

    abstract fun getTreeDao(): TreeDAO

    companion object {

        private var instance: TreeDatabase? = null

        fun getInstance(context: Context): TreeDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context = context,
                    klass = TreeDatabase::class.java,
                    name = "tree.db"
                ).fallbackToDestructiveMigration().build()
            }
            return instance as TreeDatabase
        }
    }
}