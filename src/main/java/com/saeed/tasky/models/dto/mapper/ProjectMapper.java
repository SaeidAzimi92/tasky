package com.saeed.tasky.models.dto.mapper;

import com.saeed.tasky.models.Project;
import com.saeed.tasky.models.User;
import com.saeed.tasky.models.dto.ProjectDto;
import com.saeed.tasky.models.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProjectMapper {

    ProjectDto mapProjectToDto(Project project);

    Project mapDtoToProject(ProjectDto projectDto);
}