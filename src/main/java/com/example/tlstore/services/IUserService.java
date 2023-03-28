package com.example.tlstore.services;

import com.example.tlstore.entities.Role;
import com.example.tlstore.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IUserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String userName, String roleName);
    User getUser(String userName);
    List<User> getUsers();
}
