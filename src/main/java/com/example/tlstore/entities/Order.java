package com.example.tlstore.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Date;

@Entity
@Data
@Table(name = "order")
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    private String address;

    private String phoneNumber;

    private int status = 0;

    private double total;

    private Date createAt = new Date(new java.util.Date().getTime());

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToMany(
            mappedBy = "order",
            cascade = CascadeType.ALL
    )
    private List<OrderItem> orderItems;
}
