package com.saeed.tasky.services;

import com.saeed.tasky.models.Role;
import com.saeed.tasky.models.User;
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
    private RoleServices roleServices;
    private final UserMapper userMapper;

    @Autowired
    public UserServices(UserRepository repository, UserRoleProjectRepository userRoleProjectRepository,
                        RoleServices roleServices, UserMapper userMapper) {
        this.repository = repository;
        this.userRoleProjectRepository = userRoleProjectRepository;
        this.roleServices = roleServices;
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

        return userRoleProjectRepository.findAllByUserId(userId);
    }

    public User findUserById(long userId) {
        return repository.findById(userId);
    }

    public Role getProjectOwnerRole(String value) {
        return roleServices.getRoleByName(value);
    }

    public Role getRoleById(Long roleId) {
        return roleServices.getRoleById(roleId);
    }
}