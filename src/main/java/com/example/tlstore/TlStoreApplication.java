package com.example.tlstore;

import com.example.tlstore.entities.Role;
import com.example.tlstore.entities.User;
import com.example.tlstore.services.IUserService;
import com.example.tlstore.services.impl.UserServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;


@SpringBootApplication
public class TlStoreApplication {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(TlStoreApplication.class, args);
        System.out.println("-----------------------------------------------------------");
        System.out.println("🚀 Server ready at http://localhost:8080");
        System.out.println("🚀 Api doc ready at http://localhost:8080/swagger-ui.html ");
    }

    @Bean
    CommandLineRunner run(IUserService iUserService){
        return args -> {
            iUserService.saveRole(new Role(1, "ROLE_ADMIN"));
            iUserService.saveRole(new Role(2, "ROLE_USER"));
            iUserService.saveRole(new Role(3, "ROLE_MANAGER"));

            iUserService.saveUser(new User(1, "Nguyen Sy Hoang Lam", "admin1", "12345", new ArrayList<>()));
            iUserService.saveUser(new User(2, "Vo Hoan Hao", "user1", "12345", new ArrayList<>()));
            iUserService.saveUser(new User(3, "Phan Cong Tu", "master1", "12345", new ArrayList<>()));

            iUserService.addRoleToUser("admin1", "ROLE_ADMIN");
            iUserService.addRoleToUser("user1", "ROLE_USER");
            iUserService.addRoleToUser("master1", "ROLE_USER");
            iUserService.addRoleToUser("master1", "ROLE_ADMIN");
        };
    }

}
