package com.example.todo

import com.example.todo.base.DependencyInjector
import com.example.todo.base.repositories.TODORepository

class DependencyInjectorImpl : DependencyInjector {
  override fun todoRepository() : TODORepository {
    return TODORepositoryImpl()
  }
}
