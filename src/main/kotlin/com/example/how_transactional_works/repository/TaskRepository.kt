package com.example.how_transactional_works.repository

import com.example.how_transactional_works.Task
import org.springframework.data.jpa.repository.JpaRepository

interface TaskRepository : JpaRepository<Task, Long>
