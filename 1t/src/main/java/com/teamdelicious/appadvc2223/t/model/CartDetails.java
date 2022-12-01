package com.teamdelicious.appadvc2223.t.model;

import com.teamdelicious.appadvc2223.t.dto.AddressDTO;
import com.teamdelicious.appadvc2223.t.dto.CartDetailsDTO;
import com.teamdelicious.appadvc2223.t.dto.MenuItemDTO;

import javax.persistence.*;
import java.util.Set;

@Entity
public class CartDetails {

    @Id
    @GeneratedValue
    private Long id;


    @OneToOne
    @JoinColumn(name = "menuItem_id", nullable = false)
    private MenuItem menuItem;

    @Column
    private Integer quantity;

    @Column
    private double total;

    public Long getId() {
        return id;
    }

    /*
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;


     */

    public CartDetails() {}

    public CartDetails(Long id) { this.id = id; }

    public CartDetails(CartDetailsDTO cartDetailsDTO) {

        this.id = cartDetailsDTO.getId();
        this.quantity = cartDetailsDTO.getQuantity();
        this.total = cartDetailsDTO.getTotal();

    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public Integer getQuantity() {
        return quantity;
    }


    public double getTotal() { return total; };

    public void setMenuItem(MenuItem menuItem) { this.menuItem = menuItem; }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    public void setTotal( double total ) { this.total = total; }


}
