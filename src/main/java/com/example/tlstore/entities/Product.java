package com.example.tlstore.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "product")
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    @Column(nullable = false)
    private String productName;
    @Column(nullable = false)
    private int quantity;
    @Column(nullable = false)
    private int sold = 0;
    @Column(length = 1000)
    private String description;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private Boolean isActive = true;

    private Date createAt = new Date(new java.util.Date().getTime());
    private Date updateAt= new Date(new java.util.Date().getTime());

    @ManyToOne(fetch = FetchType.LAZY)
    // sử dụng FetchType.LAZY vì nếu không chúng ta sẽ quay lại việc tìm nạp EAGER
    private Category category;

}
