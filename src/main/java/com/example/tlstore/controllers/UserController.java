package com.example.tlstore.controllers;

import com.example.tlstore.dtos.Login;
import com.example.tlstore.dtos.SignUp;
import com.example.tlstore.dtos.UserDto;
import com.example.tlstore.exceptions.NotFoundException;
import com.example.tlstore.repositories.UserRepository;
import com.example.tlstore.services.IUserService;
import com.google.gson.Gson;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
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

    @GetMapping("/check/{username}")
    @ApiOperation(value = "Kiểm tra Username đã tồn tại hay chưa")
    public ResponseEntity<UserDto> checkExistByUsername(@PathVariable("username") String username) {
        UserDto User = iUserService.getUserByUsername(username.trim());
        return new ResponseEntity<>(User, HttpStatus.OK);
    }

    @ApiOperation(value = "Create new User")
    @PostMapping
    public ResponseEntity<UserDto> createUser(SignUp signUp) {
        UserDto savedUser = iUserService.createUser(signUp);
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
        UserDto updatedUser = iUserService.updateUser(UserId, UserDto);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @ApiOperation(value = "Delete User by id")
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long UserId) {
        iUserService.deleteUser(UserId);
        return new ResponseEntity<>("User successfully deleted !!", HttpStatus.OK);
    }

    @ApiOperation(value = "Login by username & password")
    @PostMapping(value = "/login")
    public ResponseEntity<UserDto> login(Login login) {
        UserDto userDto = iUserService.getUserByUserNameAndPassword(login.getUserName(), login.getPassword());
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @PostMapping(value = "/change-password", produces = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<String> changePassword(UserDto userDto,String newPass) throws NoSuchFieldException, IllegalAccessException {
//        if(userDto != null){
        final Gson gson = new Gson();
        UserDto user = iUserService.getUserById(userDto.getId());
        if (user != null) {
            if (!user.getPassword().equals(userDto.getPassword())) {
                return new ResponseEntity<>(gson.toJson("Update Password Fail"), HttpStatus.NON_AUTHORITATIVE_INFORMATION);
            } else {
                user.setPassword(newPass);
                iUserService.updateUser(user.getId(), user);
            }
        }else{
            return new ResponseEntity<>(gson.toJson("Not found User information"), HttpStatus.NON_AUTHORITATIVE_INFORMATION);
        }
        return new ResponseEntity<>(gson.toJson("Update Password Successful"), HttpStatus.OK);
    }
}
