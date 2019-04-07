package com.saeed.tasky.models.dto


data class UserDto(
        var firstName: String? = null,
        var lastName: String? = null,
        var email: String? = null,
        var password: String? = null,
        var avatar: String? = null
)