package com.saeed.tasky.models.dto

data class ProjectRootsDto(
        var userId: Long? = 0,
        var userName: String? = null,
        var projectId: Long? = 0,
        var projectName: String? = null,
        var roleId: Long? = 0,
        var roleName: String? = null
)