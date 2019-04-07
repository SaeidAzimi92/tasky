package com.saeed.tasky.models.dto.mapper

import com.saeed.tasky.models.Project
import com.saeed.tasky.models.dto.ProjectDto

object ProjectMapper {

    fun mapProjectToDto(project: Project): ProjectDto {
        val dto = ProjectDto()
        dto.name = project.name
        dto.project = project
        return dto
    }

    fun mapDtoToProject(dto: ProjectDto): Project {
        val project = Project()
        project.name = dto.name
        project.icon = dto.project?.icon
        return project
    }
}