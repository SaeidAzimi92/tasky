package com.saeed.tasky.models.dto

import com.saeed.tasky.models.Project
import com.saeed.tasky.models.Role
import com.saeed.tasky.models.User

data class ProjectDto (
    var user: User? = null,
    var role: Role? = null,
    var project: Project? = null,
    var name: String? = null
)