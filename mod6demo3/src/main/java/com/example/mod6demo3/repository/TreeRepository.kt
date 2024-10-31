package com.example.mod6demo3.repository

import com.example.mod6demo3.bo.Tree
import com.example.mod6demo3.dao.TreeDAO

class TreeRepository(private val treeDao: TreeDAO) {

   fun getTree(id : Long): Tree {
       return treeDao.findById(id)
   }

    fun getAllTrees(): List<Tree> {
        return treeDao.findAllTree()
    }

    fun addTree(tree: Tree): Long {
        return treeDao.insert(tree)
    }

    fun updateTree(tree: Tree) {
        return treeDao.update(tree)
    }
}