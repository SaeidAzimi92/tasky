package com.saeed.tasky.controllers;

import com.saeed.tasky.models.dto.ProjectDto;
import com.saeed.tasky.services.ProjectServices;
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

    @PostMapping(value = "/add/{userId}/{name}")
    public HttpStatus addProject(@PathVariable("userId") long userId, @PathVariable("name") String name) {
        ProjectDto dto = new ProjectDto();
        dto.setName(name);
        dto.setUser(services.getUser(userId));
        dto.setRole(services.getAdminRole());
        services.addProject(dto);
        return HttpStatus.OK;
    }

    @GetMapping(value = "/members/{projectId}")
    public List getMembers(@PathVariable("projectId") long projectId) {
        return services.getProjectMembers(projectId);
    }

    @GetMapping(value = "")
    public List getProjects() {
        return services.getAllProjects();
    }
}