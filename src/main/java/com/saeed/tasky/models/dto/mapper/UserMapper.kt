package com.saeed.tasky.models.dto.mapper

import com.saeed.tasky.models.User
import com.saeed.tasky.models.dto.UserDto

object UserMapper {
    fun mapUserToDto(user: User): UserDto {
        val dto = UserDto()
        dto.copy(firstName = user.firstName, lastName = user.lastName,
                avatar = user.avatar, email = user.email, password = user.password)
        return dto
    }
    fun mapDtoToUser(dto: UserDto): User {
        val user = User()
        user.copy(firstName = dto.firstName, lastName = dto.lastName,
                avatar = dto.avatar, email = dto.email, password = dto.password)
        return user
    }
}