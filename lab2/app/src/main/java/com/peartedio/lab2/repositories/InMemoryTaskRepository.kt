package com.peartedio.lab2.repositories

import com.peartedio.lab2.models.Task
import org.joda.time.DateTime

interface TaskRepository {
    fun getAll(): List<Task>
    fun getById(id: Int): Task?
    fun createTask(task: Task): Task
    fun updateTask(task: Task)
}

class InMemoryTaskRepository : TaskRepository {
    companion object {
        val shared = InMemoryTaskRepository()
    }

    private val tasks = mutableListOf<Task>(
        Task(
            id = 1,
            name = "Test task #2",
            description = "Looooooœong description",
            completed = true,
            deadline = DateTime.now().minusDays(1),
        ),
        Task(
            id = 2,
            name = "Test task",
            description = "Short description",
            completed = false,
            deadline = DateTime.now().plusDays(1),
        ),
    )

    override fun getAll(): List<Task> = tasks

    override fun getById(id: Int): Task? = tasks.firstOrNull { it.id == id }

    override fun createTask(task: Task): Task {
        val id = tasks.maxOfOrNull { it.id } ?: 0
        val newTask = task.copy(id = id + 1)
        tasks.add(newTask)
        return newTask
    }

    override fun updateTask(task: Task) {
        tasks.removeAll { it.id == task.id }
        tasks.add(task)
    }
}