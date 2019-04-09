package com.saeed.tasky.services

import com.saeed.tasky.models.Project
import com.saeed.tasky.models.Role
import com.saeed.tasky.models.User
import com.saeed.tasky.models.ProjectRoots
import com.saeed.tasky.models.dto.ProjectRootsDto
import com.saeed.tasky.models.dto.ProjectDto
import com.saeed.tasky.models.dto.mapper.ProjectMapper
import com.saeed.tasky.models.dto.mapper.ProjectRootsMapper
import com.saeed.tasky.repositories.ProjectRepository
import com.saeed.tasky.repositories.UserRoleProjectRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.persistence.Transient

@Service
class ProjectServices @Autowired
constructor(private val projectRepository: ProjectRepository, private val userRoleProjectRepository: UserRoleProjectRepository,
            var userServices: UserServices) {

    val allProjects: List<Project>
        get() = projectRepository.findAll() as List<Project>

    val projectAllInfo: List<ProjectRoots>
        get() = userRoleProjectRepository.findAll() as List<ProjectRoots>

    @Transient
    fun addProject(projectDto: ProjectDto): ProjectRoots {
        val result = projectRepository.save(ProjectMapper.mapDtoToProject(projectDto))
        return userRoleProjectRepository.save(ProjectRootsMapper.dtoMapToProjectRoots(projectDto, result.id!!))
    }

    fun getProjectMembers(projectId: Long): List<ProjectRoots> {
        return userRoleProjectRepository.findAllByProjectId(projectId)
    }

    fun getUser(userId: Long): User {
        return userServices.findUserById(userId)
    }

    fun addMemberToProject(dto: ProjectRootsDto): Boolean {
        userRoleProjectRepository.save(ProjectRootsMapper.dtoMapToProjectRoots(dto))
        return true
    }

    fun getRoleByName(value: String): Role {
        return userServices.getProjectOwnerRole(value)
    }

    fun getProjectById(id: Long): Project {
        return projectRepository.findProjectById(id)
    }

      fun getRoleById(roleId: Long?): Role {
        return userServices.getRoleById(roleId)
    }
}