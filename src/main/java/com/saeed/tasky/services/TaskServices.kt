package com.saeed.tasky.services

import com.saeed.tasky.models.Task
import com.saeed.tasky.repositories.TaskRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TaskServices @Autowired
constructor(private val repository: TaskRepository) {

    fun add(task: Task): Boolean {
        return try {
            repository.save(task)
            true
        } catch (e: IllegalArgumentException){
            false
        }
    }

    fun deleteTask(id: Long): Boolean {
        return try {
            repository.deleteById(id)
            true
        } catch (e: Exception) {
            false
        }
    }

    fun assignTaskToUser(taskId: Long, userId: Long) {
        repository.updateUserId(taskId, userId)
    }

    fun changeTaskStatus(taskId: Long, taskStatusId: Long) {
        repository.updateUserId(taskId, taskStatusId)
    }



}