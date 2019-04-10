package com.saeed.tasky.services

import com.saeed.tasky.models.TaskStatus
import com.saeed.tasky.repositories.TaskStatusRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TaskStatusServices @Autowired
constructor(private val repository: TaskStatusRepository) {

    fun addStatus(taskStatus: TaskStatus) {
        repository.save(taskStatus)
    }

    fun deleteItem(id: Long) {
        repository.deleteById(id)
    }
}