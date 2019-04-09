package com.saeed.tasky.controllers;

import com.saeed.tasky.models.dto.ProjectRootsDto;
import com.saeed.tasky.models.dto.ProjectDto;
import com.saeed.tasky.services.ProjectServices;
import com.saeed.tasky.utils.Commands;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/project")
public class ProjectController {

    private ProjectServices services;

    @Autowired
    public ProjectController(ProjectServices services) {
        this.services = services;
    }

    @PostMapping(value = "/add/{userId}/{projectName}")
    public HttpStatus addProject(@PathVariable("userId") long userId, @PathVariable("projectName") String projectName) {
        ProjectDto dto = new ProjectDto();
        dto.setProjectName(projectName);
        dto.setUser(services.getUser(userId));
        dto.setRole(services.getRoleByName(Commands.RolesName.ADMIN.getValue()));
        services.addProject(dto);
        return HttpStatus.OK;
    }

    @GetMapping(value = "/members/{projectId}")
    public List getMembers(@PathVariable("projectId") long projectId) {
        return services.getProjectMembers(projectId);
    }

    @PostMapping(value = "/add/member")
    public HttpStatus addUserToProjects(@RequestBody ProjectRootsDto dto) {
        if (dto != null)
            return services.addMemberToProject(dto) ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        else return HttpStatus.BAD_REQUEST;
    }

    @GetMapping(value = "")
    public List getProjects() {
        return services.getAllProjects();
    }
}