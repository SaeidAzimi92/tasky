package com.saeed.tasky.services

import com.saeed.tasky.models.ProjectRoots
import com.saeed.tasky.models.Role
import com.saeed.tasky.models.User
import com.saeed.tasky.models.dto.UserDto
import com.saeed.tasky.models.dto.mapper.UserMapper
import com.saeed.tasky.repositories.UserRepository
import com.saeed.tasky.repositories.UserRoleProjectRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@org.springframework.web.bind.annotation.RestController
@Service
class UserServices @Autowired
constructor(private val repository: UserRepository, private val userRoleProjectRepository: UserRoleProjectRepository,
            private val roleServices: RoleServices) {

    val users: List<User>
        get() = repository.findAll() as List<User>

    fun addUser(userDto: UserDto): Boolean {
        return try {
            repository.save(UserMapper.mapDtoToUser(userDto))
            true
        } catch (ex: IllegalArgumentException) {
            false
        }
    }

    fun removeUser(id: Long): Boolean {
        return try {
            repository.deleteById(id)
            true
        } catch (ex: IllegalArgumentException) {
            false
        }
    }

    fun getUserProjects(userId: Long): MutableList<ProjectRoots> = userRoleProjectRepository.findAllByUserId(userId)

    fun findUserById(userId: Long): User = repository.findById(userId).get()

    fun getProjectOwnerRole(value: String): Role = roleServices.getRoleByName(value)

    fun getRoleById(roleId: Long?): Role = roleServices.getRoleById(roleId)
}