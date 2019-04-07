package com.saeed.tasky.services;

import com.saeed.tasky.models.Role;
import com.saeed.tasky.models.User;
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

    @Autowired
    public UserServices(UserRepository repository, UserRoleProjectRepository userRoleProjectRepository,
                        RoleServices roleServices) {
        this.repository = repository;
        this.userRoleProjectRepository = userRoleProjectRepository;
        this.roleServices = roleServices;
    }

    public boolean addUser(UserDto userDto) {
        try {
            repository.save(UserMapper.INSTANCE.mapDtoToUser(userDto));
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