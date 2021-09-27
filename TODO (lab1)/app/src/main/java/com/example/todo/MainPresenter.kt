package com.example.todo

import com.example.todo.base.DependencyInjector
import com.example.todo.base.repositories.TODORepository

class MainPresenter(
    view: MainContract.View,
    dependencyInjector: DependencyInjector
) : MainContract.Presenter {

    private val todoRepository: TODORepository = dependencyInjector.todoRepository()
    private var view: MainContract.View? = view

    override fun onDestroy() {
        this.view = null
    }

    override fun onViewCreated() {
        loadTODO()
    }

    private fun loadTODO() {
        val items = todoRepository.loadItems()

        // Make sure to call the displayTODOList on the view
        view?.displayTODOList(items)
    }
}
