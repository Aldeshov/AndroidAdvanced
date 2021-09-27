package com.example.todo

import com.example.todo.base.repositories.TODORepository
import kotlin.random.Random

class TODORepositoryImpl : TODORepository {
  private var todoItems: ArrayList<TODOItem> = ArrayList()

  private fun rand(start: Int = 1, end: Int = 5): Int {
    require(!(start > end || end - start + 1 > Int.MAX_VALUE)) { "Illegal Argument" }
    return Random(System.nanoTime()).nextInt(end - start + 1) + start
  }

  override fun loadItems(): ArrayList<TODOItem> {
    for (i: Int in 1..10) {
      val c = rand()
      val item = TODOItem(i)
      item.title = "Title$i"
      item.category = "Category$c"
      todoItems.add(item)
    }
    return todoItems
  }
}