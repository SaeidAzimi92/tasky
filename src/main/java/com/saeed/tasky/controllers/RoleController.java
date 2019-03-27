package com.saeed.tasky.controllers;

import com.saeed.tasky.services.RoleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/role")
public class RoleController {

    private RoleServices services;

    @Autowired
    public RoleController(RoleServices services) {
        this.services = services;
    }

    @PostMapping(value = "/add/{name}")

    public HttpStatus addRole(@PathVariable("name") String name) {
        return services.addRole(name) ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
    }

    @PostMapping(value = "/delete/{id}")
    public HttpStatus removeRole(@PathVariable("id") long id) {
        return services.removeRole(id) ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
    }

    @GetMapping(value = "")
    public List getRole() {
        return services.getRoles();
    }
}