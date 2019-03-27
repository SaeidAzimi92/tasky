package com.saeed.tasky.controllers;

import com.saeed.tasky.models.dto.UserDto;
import com.saeed.tasky.services.UserServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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



}
