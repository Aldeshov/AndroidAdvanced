package com.example.todo.base

import com.example.todo.base.repositories.TODORepository

interface DependencyInjector {
  fun todoRepository() : TODORepository
}
