package com.saeed.tasky.services;

import com.saeed.tasky.models.Project;
import com.saeed.tasky.models.Role;
import com.saeed.tasky.models.User;
import com.saeed.tasky.models.UserRoleProject;
import com.saeed.tasky.models.dto.MembersAddedDto;
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
    private UserServices userServices;
    private ProjectMapper mapper;

    @Autowired
    public ProjectServices(ProjectRepository projectRepository, UserRoleProjectRepository userRoleProjectRepository,
                           UserServices userServices, ProjectMapper mapper) {
        this.projectRepository = projectRepository;
        this.userRoleProjectRepository = userRoleProjectRepository;
        this.userServices = userServices;
        this.mapper = mapper;
    }

    public List getAllProjects() {
        return (List<Project>) projectRepository.findAll();
    }

    public List getProjectAllInfo() {
        return (List) userRoleProjectRepository.findAll();
    }

    private Project getProjectById(long id) {
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

    public User getUser(long userId) {
        return userServices.findUserById(userId);
    }

    public boolean addMemberToProject(MembersAddedDto membersAddedDto) {
        UserRoleProject userRoleProject = new UserRoleProject(getProjectById(membersAddedDto.getProjectId()),
                getUser(membersAddedDto.getUserId()), getRoleById(membersAddedDto.getRoleId()));
        userRoleProjectRepository.save(userRoleProject);
        return true;
    }

    public Role getRoleByName(String value) {
        return userServices.getProjectOwnerRole(value);
    }

    private Role getRoleById(Long roleId) {
        return userServices.getRoleById(roleId);
    }

    public void saveProject(ProjectDto form) {
        projectRepository.save(form.getProject());
        UserRoleProject userRoleProject = new UserRoleProject(form.getProject(),
                getUser(form.getUser().getId()), getRoleById(form.getRole().getId()));
        userRoleProjectRepository.save(userRoleProject);
    }
}