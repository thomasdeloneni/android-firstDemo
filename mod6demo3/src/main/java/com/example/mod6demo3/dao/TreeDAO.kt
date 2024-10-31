package com.example.mod6demo3.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.mod6demo3.bo.Tree

@Dao
interface TreeDAO {

    @Insert
    fun insert(tree: Tree) : Long

    @Update
    fun update(tree: Tree)

    @Query("SELECT * FROM Tree")
    fun findAllTree(): List<Tree>

    @Delete
    fun delete(tree: Tree)

    @Query("DELETE FROM Tree WHERE id = :id")
    fun delete2(id: Long)

    @Query("SELECT * FROM Tree WHERE id = :id")
    fun findById(id: Long): Tree
}