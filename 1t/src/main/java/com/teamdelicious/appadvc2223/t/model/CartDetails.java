package com.teamdelicious.appadvc2223.t.model;

import com.teamdelicious.appadvc2223.t.dto.AddressDTO;
import com.teamdelicious.appadvc2223.t.dto.CartDetailsDTO;

import javax.persistence.*;
import java.util.Set;

@Entity
public class CartDetails {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "menuItem_id", nullable = false)
    private MenuItem menuItem;

    @Column
    private Integer quantity;

    public Long getId() {
        return id;
    }

    public CartDetails() {}

    public CartDetails(CartDetailsDTO cartDetailsDTO) {
        this.menuItem = new MenuItem(cartDetailsDTO.getMenuItemId());
        this.quantity = cartDetailsDTO.getQuantity();

    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public Integer getQuantity() {
        return quantity;
    }



}
