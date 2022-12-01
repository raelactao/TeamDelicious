package com.teamdelicious.appadvc2223.t.dto;

import com.teamdelicious.appadvc2223.t.model.Address;
import com.teamdelicious.appadvc2223.t.model.CartDetails;

public class CartDetailsDTO {

    private Long id;

    private String menuItem;

    private Integer quantity;


    private double total;

    //private Long orderId;

    public CartDetailsDTO() {}

    public CartDetailsDTO(CartDetails cartDetails) {
        this.id = cartDetails.getId();
        this.menuItem = cartDetails.getMenuItem().getName();
        this.quantity = cartDetails.getQuantity();
        this.total = cartDetails.getTotal();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMenuItem() { return menuItem; }

    public void setMenuItem(String menuItem) {
        this.menuItem = menuItem;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public double getTotal() { return total; }

    public void setTotal(double total) { this.quantity = quantity; }

}
