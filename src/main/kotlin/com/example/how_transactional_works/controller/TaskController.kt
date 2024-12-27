package com.example.how_transactional_works.controller

import com.example.how_transactional_works.Task
import com.example.how_transactional_works.service.TaskService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/tasks")
class TaskController(
    private val taskService: TaskService,
) {

    @PostMapping
    fun saveTask(
        @RequestBody request: TaskRequest,
    ) {
        taskService.createTask(request.title, request.content)
    }

    data class TaskRequest(
        val title: String,
        val content: String,
    )

    @GetMapping
    fun getTasks(): List<Task> {
        return taskService.getTasks()
    }
}
