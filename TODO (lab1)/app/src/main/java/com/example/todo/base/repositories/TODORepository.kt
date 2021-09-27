package com.example.todo.base.repositories

import com.example.todo.TODOItem

interface TODORepository {

  fun loadItems(): ArrayList<TODOItem>
}
