package com.saeed.tasky.models

import javax.persistence.*

@Entity
data class ProjectRoots(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = 0,
        var projectId: Long? = 0,
        var projectName: String? = null,
        var userId: Long? = 0,
        var userName: String? = null,
        var roleId: Long? = 0,
        var roleName: String? = null

)