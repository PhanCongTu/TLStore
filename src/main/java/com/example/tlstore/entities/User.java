package com.example.tlstore.entities;

import com.example.tlstore.utils.Role;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
@Data
@Table(name = "user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String passWord;

    private String avatar;

    @Column(length = 10)
    private String phoneNumber;

    @Email
    private String email;

    @Column
    private Date createAt= new Date(new java.util.Date().getTime());

    @Column
    private Date updateAt= new Date(new java.util.Date().getTime());

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL
    )
    private Collection<Cart> carts;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL
    )
    private Collection<Order> orders;
}
