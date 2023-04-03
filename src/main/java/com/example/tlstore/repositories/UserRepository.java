package com.example.tlstore.repositories;

import com.example.tlstore.entities.User;
import com.example.tlstore.utils.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//    User findByUserNameAndPasswordAndRoles(String userName, String password, Collection<Role> roles);
    User findByUserNameAndPassword(String userName, String password);
    User findByUserName(String userName);
}
