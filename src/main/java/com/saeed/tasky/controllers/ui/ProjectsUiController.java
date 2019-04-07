package com.saeed.tasky.controllers.ui;

import com.saeed.tasky.models.Project;
import com.saeed.tasky.models.Role;
import com.saeed.tasky.models.User;
import com.saeed.tasky.models.dto.ProjectDto;
import com.saeed.tasky.services.ProjectServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/project/ui")
public class ProjectsUiController {

    private ProjectServices services;

    @Autowired
    public ProjectsUiController(ProjectServices services) {
        this.services = services;
    }

    @GetMapping("/all")
    public String showAll(Model model) {
        model.addAttribute("projects", services.getProjectAllInfo());
        return "projects";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        ProjectDto projectForm = new ProjectDto();

        projectForm.setRole(new Role());
        projectForm.setUser(new User());
        projectForm.setProject(new Project());
        projectForm.setName("name");

        model.addAttribute("form1", projectForm);
        return "createProjectsForm";
    }

    @PostMapping("/save")
    public String saveProject(@ModelAttribute ProjectDto form1, Model model) {
        if (services.saveProject(form1))
            return "Saving Failed!";
        model.addAttribute("projects", services.getProjectAllInfo());
        return "redirect:/project/ui/all";
    }
}