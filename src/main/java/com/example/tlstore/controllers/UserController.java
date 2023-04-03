package com.example.tlstore.controllers;

import com.example.tlstore.dtos.Login;
import com.example.tlstore.dtos.UserDto;
import com.example.tlstore.exceptions.NotFoundException;
import com.example.tlstore.repositories.UserRepository;
import com.example.tlstore.services.IUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController{
    @Autowired
    IUserService iUserService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    @ApiOperation(value = "Get all User")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> listUser = iUserService.getAllUsers();
        if (listUser.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listUser, HttpStatus.OK);
    }
//    @GetMapping("/pagination")
//    public ResponseEntity<List<UserDto>> getAllUsersPagination() {
//        List<UserDto> listUser = iUserService.getAllPagingUsers();
//        if (listUser.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(listUser, HttpStatus.OK);
//    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get User by id")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") long id) {
        UserDto User = iUserService.getUserById(id);
        return new ResponseEntity<>(User, HttpStatus.OK);
    }

    @ApiOperation(value = "Create new User")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto savedUser = iUserService.createUser(userDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

//    @PatchMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<UserDto> patchUser(@PathVariable("id") Long UserId,
//                                                     @RequestBody Map<Object, Object> UserDto) {
//        UserDto updatedUser = iUserService.patchUser(UserId , UserDto);
//        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
//    }

    @ApiOperation(value = "Update User by id (Update only the fields you want to change)")
    @PatchMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long UserId,
                                                      @RequestBody UserDto UserDto) throws NoSuchFieldException, IllegalAccessException {
        UserDto updatedUser = iUserService.updateUser(UserId , UserDto);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @ApiOperation(value = "Delete User by id")
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long UserId){
        iUserService.deleteUser(UserId);
        return new ResponseEntity<>("User successfully deleted !!", HttpStatus.OK);
    }

    @ApiOperation(value = "Login by username & password")
    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody Login login){
        UserDto userDto =iUserService.getUserByUserNameAndPassword(login.getUserName(), login.getPassword());
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }
}
