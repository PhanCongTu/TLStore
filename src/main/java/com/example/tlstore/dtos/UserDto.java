package com.example.tlstore.dtos;

import com.example.tlstore.utils.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private long id;

    private String name;

    private String userName;

    private String password;

    private String avatar;

    private String phoneNumber;

    private String email;

    private List<Role> roles;

    private Boolean isActive;
}
