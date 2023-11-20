package com.peartedio.lab2.fragments

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.View
import androidx.core.widget.doOnTextChanged
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.peartedio.lab2.R
import com.peartedio.lab2.databinding.TaskEditFragmentBinding
import com.peartedio.lab2.models.Task
import com.peartedio.lab2.presenters.TaskEditPresenter
import org.joda.time.DateTime

class TaskEditFragment : BaseFragment<TaskEditFragmentBinding>(TaskEditFragmentBinding::inflate),
    TaskEditPresenter.View {
    private var presenter: TaskEditPresenter? = null

    private val args by navArgs<TaskEditFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.primaryButton.setOnClickListener {
            presenter?.save()
        }
        presenter = TaskEditPresenter(args.id.takeIf { it > 0 }, this)
    }

    override fun updateData(task: Task) {
        with(binding) {
            name.setText(task.name)
            name.doOnTextChanged { text, _, _, _ ->
                presenter?.updateName(text.toString())
            }
            description.setText(task.description)
            description.doOnTextChanged { text, _, _, _ ->
                presenter?.updateDescription(text.toString())
            }
            completed.isChecked = task.completed
            completed.setOnCheckedChangeListener { _, completed ->
                presenter?.updateCompleted(completed)
            }
            deadline.text = task.deadline?.toString("dd MMMM yyyy HH:mm")
                ?: getString(R.string.task_edit_no_deadline)
            var date = task.deadline ?: DateTime.now()
            deadline.setOnClickListener {
                DatePickerDialog(requireContext(), { _, year, month, day ->
                    TimePickerDialog(requireContext(), { _, hour, minutes ->
                        date = DateTime(year, month + 1, day, hour, minutes)
                        presenter?.updateDeadline(date)
                        deadline.text = date.toString("dd MMMM yyyy HH:mm")
                    }, date.hourOfDay, date.minuteOfHour, true).show()
                }, date.year, date.monthOfYear - 1, date.dayOfMonth).show()
            }
        }
    }

    override fun close() {
        findNavController().popBackStack()
    }
}