package com.peartedio.lab2.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.peartedio.lab2.databinding.TaskListItemBinding
import com.peartedio.lab2.models.Task

interface TasksAdapterDelegate {
    fun onClickTask(task: Task)
    fun onChangeCompleted(task: Task, completed: Boolean)
    fun onAddNew()
}

class TasksAdapter(private var tasks: List<Task>, private val delegate: TasksAdapterDelegate) :
    RecyclerView.Adapter<TasksAdapter.TaskViewHolder>() {

    fun update(task: Task, index: Int) {
        tasks.toMutableList().apply {
            this[index] = task
            tasks = this
            notifyItemChanged(index)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val binding = TaskListItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return TaskViewHolder(binding)
    }

    override fun getItemCount() = tasks.size + 1

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        with(holder) {
            if (position < tasks.count()) {
                with(tasks[position]) {
                    binding.title.text = name
                    binding.description.text = description
                    binding.completed.isChecked = completed
                    binding.deadline.text = deadline?.toString("dd MMMM yyyy HH:mm") ?: ""
                    binding.addNewContainer.visibility = View.GONE
                    binding.itemContainer.visibility = View.VISIBLE
                    binding.itemContainer.setOnClickListener {
                        delegate.onClickTask(tasks[position])
                    }
                    binding.completed.setOnCheckedChangeListener { _, completed ->
                        delegate.onChangeCompleted(tasks[position], completed)
                    }
                }
            } else {
                binding.addNewContainer.visibility = View.VISIBLE
                binding.itemContainer.visibility = View.GONE
                binding.addNewContainer.setOnClickListener {
                    delegate.onAddNew()
                }
            }
        }
    }

    inner class TaskViewHolder(val binding: TaskListItemBinding) :
        RecyclerView.ViewHolder(binding.root)

}