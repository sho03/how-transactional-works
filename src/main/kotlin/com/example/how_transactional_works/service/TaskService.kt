package com.example.how_transactional_works.service

import com.example.how_transactional_works.Task
import com.example.how_transactional_works.repository.TaskRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TaskService(
    private val taskRepository: TaskRepository,
) {

    @Transactional
    fun createTask(
        title: String,
        content: String
    ) {
        val task = Task(
            title = title,
            content = content
        )
        taskRepository.save(task)
    }

    @Transactional
    fun getTasks(): List<Task> {
        val tasks = taskRepository.findAll()
        return tasks
    }
}
