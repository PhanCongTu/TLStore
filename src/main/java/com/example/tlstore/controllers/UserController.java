package com.example.tlstore.controllers;

import com.example.tlstore.dtos.CategoryDto;
import com.example.tlstore.entities.Role;
import com.example.tlstore.entities.User;
import com.example.tlstore.services.ICategoryService;
import com.example.tlstore.services.IUserService;
import com.example.tlstore.services.impl.UserServiceImpl;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
@RequiredArgsConstructor
public class UserController {
    private final IUserService iUserServicel;

    @GetMapping("")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> listUser = iUserServicel.getUsers();
        if (listUser.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listUser, HttpStatus.OK);
    }

    @PostMapping(value = "/save-user", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User savedUser = iUserServicel.saveUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @PostMapping(value = "/save-role", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        Role savedRole = iUserServicel.saveRole(role);
        return new ResponseEntity<>(savedRole, HttpStatus.CREATED);
    }

    @PostMapping(value = "/addRoleToUser", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm form) {
        iUserServicel.addRoleToUser(form.getUserName(), form.getRoleName());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

@Data
class RoleToUserForm {
    private String userName;
    private String roleName;
}
