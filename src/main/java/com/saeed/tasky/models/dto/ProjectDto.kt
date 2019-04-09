package com.saeed.tasky.models.dto

import com.saeed.tasky.models.Role
import com.saeed.tasky.models.User

data class ProjectDto (
    var user: User? = null,
    var role: Role? = null,
    var projectName: String? = null,
    var projectIcon: String? = null,
    var projectId: Long? = null
)