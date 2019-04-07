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
    public UserServices userServices;

    @Autowired
    public ProjectServices(ProjectRepository projectRepository, UserRoleProjectRepository userRoleProjectRepository,
                           UserServices userServices) {
        this.projectRepository = projectRepository;
        this.userRoleProjectRepository = userRoleProjectRepository;
        this.userServices = userServices;
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

    public UserRoleProject addProject(ProjectDto projectDto) {
        Project project = projectRepository.save(ProjectMapper.INSTANCE.mapDtoToProject(projectDto));
        UserRoleProject userRoleProject = new UserRoleProject();
        userRoleProject.setProject(project);
        userRoleProject.setUser(projectDto.getUser());
        userRoleProject.setRole(projectDto.getRole());
        UserRoleProject result = userRoleProjectRepository.save(userRoleProject);
        return result;
    }

    public List getProjectMembers(long projectId) {
        return userRoleProjectRepository.findAllByProjectId(projectId);
    }

    public User getUser(long userId) {
        return userServices.findUserById(userId);
    }

    public boolean addMemberToProject(MembersAddedDto membersAddedDto) {
        UserRoleProject userRoleProject = new UserRoleProject();
        if (membersAddedDto.getProjectId() != null)
            userRoleProject.setProject(getProjectById(membersAddedDto.getProjectId()));
        if (membersAddedDto.getUserId() != null)
            userRoleProject.setUser(getUser(membersAddedDto.getUserId()));
        userRoleProject.setRole(getRoleById(membersAddedDto.getRoleId()));

        userRoleProjectRepository.save(userRoleProject);
        return true;
    }

    public Role getRoleByName(String value) {
        return userServices.getProjectOwnerRole(value);
    }

    private Role getRoleById(Long roleId) {
        return userServices.getRoleById(roleId);
    }

    public boolean saveProject(ProjectDto form) {
        if (form.getProject() == null)
            return false;
        projectRepository.save(form.getProject());

        UserRoleProject userRoleProject = new UserRoleProject();
        userRoleProject.setProject(ProjectMapper.INSTANCE.mapDtoToProject(form));
        if (form.getUser() == null)
            return false;
        userRoleProject.setUser(getUser(form.getUser().getId()));
        if (form.getRole() == null)
            return false;
        userRoleProject.setRole(getRoleById(form.getRole().getId()));

        userRoleProjectRepository.save(userRoleProject);
        return true;
    }
}