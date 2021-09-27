package com.example.todo.base

interface View<T> {
  fun setPresenter(presenter : T)
}
