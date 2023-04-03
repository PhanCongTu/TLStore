package com.example.tlstore.dtos;

import com.example.tlstore.utils.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Login {
    private String userName;
    private String password;
}
