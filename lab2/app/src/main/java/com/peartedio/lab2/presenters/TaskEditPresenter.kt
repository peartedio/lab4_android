package com.peartedio.lab2.presenters

import com.peartedio.lab2.models.Task
import com.peartedio.lab2.repositories.InMemoryTaskRepository
import org.joda.time.DateTime

class TaskEditPresenter(id: Int?, private val delegate: View) {

    private var isNewTask: Boolean
    private var task: Task
    private val repository = InMemoryTaskRepository.shared

    interface View {
        fun updateData(task: Task)
        fun close()
    }

    init {
        isNewTask = id == null
        task = id?.run {
            repository.getById(this)
        } ?: Task()
        delegate.updateData(task)
    }

    fun updateName(name: String) {
        task = task.copy(name = name)
    }

    fun updateDescription(description: String) {
        task = task.copy(description = description)
    }

    fun updateCompleted(completed: Boolean) {
        task = task.copy(completed = completed)
    }

    fun updateDeadline(deadline: DateTime) {
        task = task.copy(deadline = deadline)
    }

    fun save() {
        if (isNewTask) {
            repository.createTask(task)
        } else {
            repository.updateTask(task)
        }
        delegate.close()
    }
}