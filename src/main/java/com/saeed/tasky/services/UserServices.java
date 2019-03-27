package com.saeed.tasky.services;

import com.saeed.tasky.models.UserRoleProject;
import com.saeed.tasky.models.dto.UserDto;
import com.saeed.tasky.models.dto.mapper.UserMapper;
import com.saeed.tasky.repositories.UserRepository;
import com.saeed.tasky.repositories.UserRoleProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@Service
public class UserServices {

    private UserRepository repository;
    private UserRoleProjectRepository userRoleProjectRepository;
    private ProjectServices projectServices;
    private final UserMapper userMapper;

    @Autowired
    public UserServices(UserRepository repository, UserRoleProjectRepository userRoleProjectRepository,
                        ProjectServices projectServices, UserMapper userMapper) {
        this.repository = repository;
        this.userRoleProjectRepository = userRoleProjectRepository;
        this.projectServices = projectServices;
        this.userMapper = userMapper;
    }

    public boolean addUser(UserDto userDto) {
        try {
            repository.save(userMapper.mapDtoToUser(userDto));
            return true;
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }

    public List getUsers() {
        return (List) repository.findAll();
    }

    public boolean removeUser(long id) {
        try {
            repository.deleteById(id);
            return true;
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }

    public List getUserProjects(long userId) {
        List<UserRoleProject> list = userRoleProjectRepository.findAllByUserId(userId);
//        List<Project> projects = new ArrayList<>();
//        for (UserRoleProject item : list) {
//            projects.add(item)
//        }
        return list;
    }
}