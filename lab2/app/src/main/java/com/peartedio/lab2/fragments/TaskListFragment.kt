package com.peartedio.lab2.fragments

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.peartedio.lab2.R
import com.peartedio.lab2.adapters.TasksAdapter
import com.peartedio.lab2.adapters.TasksAdapterDelegate
import com.peartedio.lab2.databinding.TaskListFragmentBinding
import com.peartedio.lab2.models.Task
import com.peartedio.lab2.presenters.TaskListPresenter

class TaskListFragment : BaseFragment<TaskListFragmentBinding>(TaskListFragmentBinding::inflate),
    TaskListPresenter.View, TasksAdapterDelegate {
    private var presenter: TaskListPresenter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = TaskListPresenter(this)
    }

    override fun updateAllList(list: List<Task>) {
        binding.listView.adapter = TasksAdapter(list, this)
    }

    override fun onResume() {
        super.onResume()
        presenter?.refresh()
    }

    override fun updateTask(task: Task, index: Int) {
        (binding.listView.adapter as? TasksAdapter)?.apply {
            update(task, index)
        }
    }

    override fun onClickTask(task: Task) {
        findNavController().navigate(
            TaskListFragmentDirections.actionTaskListFragmentToTaskEditFragment(
                id = task.id
            )
        )
    }

    override fun onChangeCompleted(task: Task, completed: Boolean) {
        presenter?.setCompleted(task, completed)
    }

    override fun onAddNew() {
        findNavController().navigate(
            TaskListFragmentDirections.actionTaskListFragmentToTaskEditFragment(
                id = 0
            )
        )
    }
}