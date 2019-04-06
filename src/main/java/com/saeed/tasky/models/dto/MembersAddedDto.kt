package com.saeed.tasky.models.dto

data class MembersAddedDto(
        var userId: Long? = 0,
        var projectId: Long? = 0,
        var roleId: Long? = 0
)