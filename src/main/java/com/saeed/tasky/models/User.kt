package com.saeed.tasky.models

import javax.persistence.*
import java.sql.Timestamp
import java.time.LocalDateTime

@Entity
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = 0,
        @Column(name = "first_name")
        var firstName: String? = null,
        @Column(name = "last_name")
        var lastName: String? = null,
        @Column(name = "email")
        var email: String? = null,
        @Column(name = "password")
        var password: String? = null,
        @Column(name = "avatar")
        var avatar: String? = null,
        @Column(name = "created_at")
        var createdAt: LocalDateTime = LocalDateTime.now(),
        @Column(name = "modified_at")
        var modifiedAt: Timestamp? = null
)