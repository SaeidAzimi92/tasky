package com.saeed.tasky.models

import javax.persistence.*

@Entity
data class Task(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long,
        var name: String?,
        var description: String?,
        @OneToOne(mappedBy="task_status",cascade=[CascadeType.ALL],orphanRemoval=true)
        var taskStatus: TaskStatus?,
        @OneToOne(mappedBy="users",cascade=[CascadeType.ALL],orphanRemoval=true)
        var user: User?

)