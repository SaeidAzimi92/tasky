package com.saeed.tasky.models

import javax.persistence.*
import java.sql.Timestamp
import java.time.LocalDateTime

@Entity(name = "projects")
data class Project(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id")
        var id: Long? = 0,
        @Column(name = "projectName")
        var name: String? = null,
        @Column(name = "icon")
        var icon: String? = null,
        @Column(name = "created_at")
        var createdAt: LocalDateTime = LocalDateTime.now(),
        @Column(name = "modified_at")
        var modifiedAt: Timestamp? = null
)