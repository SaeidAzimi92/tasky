package com.saeed.tasky.models

import java.time.LocalDateTime
import javax.persistence.*

//todo: add assignment
@Entity
data class Task(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long,
        var name: String?,
        var description: String?,
        @OneToOne(mappedBy="task_status",cascade=[CascadeType.ALL],orphanRemoval=true)
        var taskStatusId: Long?,
        @OneToOne(mappedBy="users",cascade=[CascadeType.ALL],orphanRemoval=true)
        var userId: Long?,
        @OneToOne(mappedBy="projects",cascade=[CascadeType.ALL],orphanRemoval=true)
        var projectId: Long?,
        @Column(name = "created_at")
        var createdAt: LocalDateTime = LocalDateTime.now(),
        @Column(name = "modified_at")
        var modifiedAt: LocalDateTime? = null
)