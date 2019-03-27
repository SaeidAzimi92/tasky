package com.saeed.tasky.services;


import com.saeed.tasky.models.Role;
import com.saeed.tasky.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServices {

    private RoleRepository repository;

    @Autowired
    public RoleServices(RoleRepository repository) {
        this.repository = repository;
    }

    public boolean addRole(String name) {
        try {
            Role role = new Role();
            role.setName(name);
            repository.save(role);
            return true;
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }

    public List getRoles() {
        return (List) repository.findAll();
    }

    public boolean removeRole(long id) {
        try {
            repository.deleteById(id);
            return true;
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }
}