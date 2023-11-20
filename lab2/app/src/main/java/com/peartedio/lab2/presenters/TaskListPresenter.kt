package com.peartedio.lab2.presenters

import com.peartedio.lab2.models.Task
import com.peartedio.lab2.repositories.InMemoryTaskRepository

class TaskListPresenter(private val delegate: View) {

    private val repository = InMemoryTaskRepository.shared
    private var tasks = repository.getAll().toMutableList()

    interface View {
        fun updateAllList(list: List<Task>)
        fun updateTask(task: Task, index: Int)
    }

    init {
        delegate.updateAllList(tasks)
    }

    fun setCompleted(task: Task, completed: Boolean) {
        repository.updateTask(task.copy(completed = completed))
        tasks.indexOfFirst { it.id == task.id }.takeIf { it >= 0 }?.also {index ->
            repository.getById(task.id)?.apply {
                tasks[index] = this
                delegate.updateTask(this, index = index)
            }
        }
    }

    fun refresh() {
        tasks = repository.getAll().toMutableList()
        delegate.updateAllList(tasks)
    }

}