package com.example.tlstore.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
@Data
@Table(name = "cart")
public class Cart implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    @Column(nullable = false)
    private Date createAt = new Date(new java.util.Date().getTime());

    @OneToMany(
            mappedBy = "cart",
            cascade = CascadeType.ALL
    )
    private Collection<CartItem> cartItems;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public double getTotalPrice() {
        double total = 0;
        for (CartItem cartItem : this.cartItems) {
            total += (cartItem.getQuantity() * cartItem.getProduct().getPrice());
        }
        return total;
    }
}
