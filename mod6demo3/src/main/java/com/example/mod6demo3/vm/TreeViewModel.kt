package com.example.mod6demo3.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.mod6demo3.bo.Tree
import com.example.mod6demo3.db.TreeDatabase
import com.example.mod6demo3.repository.TreeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TreeViewModel(private val treeRepository: TreeRepository) : ViewModel() {

    private val _trees = MutableStateFlow<List<Tree>>(emptyList())
    var trees = _trees.asStateFlow()

    init {
        addTree()
        getTrees()
    }

    fun addTree() {
        viewModelScope.launch(Dispatchers.IO) {
            val a = async {
                treeRepository.addTree(
                    Tree(
                        name = "Pommier",
                        lifeExpectancy = 10,
                        fruitful = false
                    )
                )
                treeRepository.addTree(
                    Tree(
                        name = "Test",
                        lifeExpectancy = 10,
                        fruitful = false
                    )
                )
                treeRepository.addTree(
                    Tree(
                        name = "Test",
                        lifeExpectancy = 10,
                        fruitful = false
                    )
                )
            }.await()
        }
    }

    fun getTrees() {
        viewModelScope.launch(Dispatchers.IO) {
            _trees.value = treeRepository.getAllTrees()
        }
    }

    companion object {

        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                val application = checkNotNull(extras[APPLICATION_KEY])

                return TreeViewModel(
                    TreeRepository(
                        TreeDatabase.getInstance(application.applicationContext).getTreeDao()
                    )
                ) as T
            }
        }
    }
}