package com.saeed.tasky.models.dto.mapper

import com.saeed.tasky.models.ProjectRoots
import com.saeed.tasky.models.dto.ProjectDto
import com.saeed.tasky.models.dto.ProjectRootsDto

object ProjectRootsMapper {

    fun dtoMapToProjectRoots(dto: ProjectRootsDto): ProjectRoots {
        val roots = ProjectRoots()
        roots.projectId = dto.projectId
        roots.projectName = dto.projectName
        roots.userId = dto.userId
        roots.userName = dto.userName
        roots.roleId = dto.roleId
        roots.roleName = dto.roleName
        return roots
    }

    fun dtoMapToProjectRoots(dto: ProjectDto, projectId: Long): ProjectRoots {
        val roots = ProjectRoots()
        roots.projectId = projectId
        roots.projectName = dto.projectName
        roots.userId = dto.user!!.id
        roots.userName = dto.user!!.firstName
        roots.roleId = dto.role!!.id
        roots.roleName = dto.role!!.name
        return roots
    }

}