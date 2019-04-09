package com.saeed.tasky.models.dto.mapper

import com.saeed.tasky.models.User
import com.saeed.tasky.models.dto.UserDto

object UserMapper {
    fun mapUserToDto(user: User): UserDto {
        val dto = UserDto()
        dto.firstName = user.firstName
        dto.lastName = user.lastName
        dto.avatar = user.avatar
        dto.email = user.email
        dto.password = user.password
        return dto
    }

    fun mapDtoToUser(dto: UserDto): User {
        val user = User()
        user.firstName = dto.firstName
        user.lastName = dto.lastName
        user.avatar = dto.avatar
        user.email = dto.email
        user.password = dto.password
        return user
    }
}