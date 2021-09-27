package com.example.todo

interface MainContract {
  interface Presenter : com.example.todo.base.Presenter {
    fun onViewCreated()
  }

  interface View : com.example.todo.base.View<Presenter> {
    fun displayTODOList(items: ArrayList<TODOItem>)
  }
}
