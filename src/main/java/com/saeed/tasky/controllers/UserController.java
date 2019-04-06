package com.saeed.tasky.controllers;

import com.saeed.tasky.models.dto.UserDto;
import com.saeed.tasky.services.UserServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private UserServices userServices;

    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @PostMapping(value = "/add")
    public HttpStatus addUser(@RequestBody UserDto userDto){
        if (userDto == null)
            return HttpStatus.BAD_REQUEST;
        userServices.addUser(userDto);
        return HttpStatus.OK;
    }

    @GetMapping(value = "")
    public List getAllUsers() {
        return userServices.getUsers();
    }

    @GetMapping(value = "/{userId}/projects")
    public List getAllProjects(@PathVariable("userId") long userId) {
        return userServices.getUserProjects(userId);
    }

    @PostMapping(value = "/remove/{userId}")
    public HttpStatus removeUser(@PathVariable("userId") long userId) {
            return userServices.removeUser(userId)? HttpStatus.OK : HttpStatus.BAD_REQUEST;
    }
}