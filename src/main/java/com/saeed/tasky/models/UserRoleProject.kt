package com.saeed.tasky.models

import javax.persistence.*

@Entity
data class UserRoleProject(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = 0,
        @OneToOne(cascade = [CascadeType.ALL])
        var project: Project? = null,
        @OneToOne(cascade = [CascadeType.ALL])
        var user: User? = null,
        @OneToOne(cascade = [CascadeType.ALL])
        var role: Role? = null
)