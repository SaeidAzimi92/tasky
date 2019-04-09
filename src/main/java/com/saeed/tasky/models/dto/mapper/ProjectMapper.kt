package com.saeed.tasky.models.dto.mapper

import com.saeed.tasky.models.Project
import com.saeed.tasky.models.dto.ProjectDto

object ProjectMapper {

    fun mapProjectToDto(project: Project): ProjectDto {
        val dto = ProjectDto()
        dto.projectName = project.name
        return dto
    }

    fun mapDtoToProject(dto: ProjectDto): Project {
        val project = Project()
        project.name = dto.projectName
        project.icon = dto.projectIcon
        return project
    }
}