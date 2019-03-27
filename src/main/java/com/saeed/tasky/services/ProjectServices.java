package com.saeed.tasky.services;

import com.saeed.tasky.models.Project;
import com.saeed.tasky.models.UserRoleProject;
import com.saeed.tasky.models.dto.ProjectDto;
import com.saeed.tasky.models.dto.mapper.ProjectMapper;
import com.saeed.tasky.repositories.ProjectRepository;
import com.saeed.tasky.repositories.UserRoleProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServices {

    private ProjectRepository projectRepository;
    private UserRoleProjectRepository userRoleProjectRepository;
    private ProjectMapper mapper;

    @Autowired
    public ProjectServices(ProjectRepository projectRepository, UserRoleProjectRepository userRoleProjectRepository,
                           ProjectMapper mapper) {
        this.projectRepository = projectRepository;
        this.userRoleProjectRepository = userRoleProjectRepository;
        this.mapper = mapper;
    }

    public List getAllProjects() {
        return (List<Project>) projectRepository.findAll();
    }

    public Project getProjectById(long id) {
        return projectRepository.findProjectById(id);
    }

    public boolean addProject(ProjectDto projectDto) {
        projectRepository.save(mapper.mapDtoToProject(projectDto));
        UserRoleProject userRoleProject = new UserRoleProject(mapper.mapDtoToProject(projectDto),
                projectDto.getUser(), projectDto.getRole());
        userRoleProjectRepository.save(userRoleProject);
        return true;
    }

    public List getProjectMembers(long projectId) {
        return userRoleProjectRepository.findAllByProjectId(projectId);
    }

}
