package com.teamdelicious.appadvc2223.t.dto;

import com.teamdelicious.appadvc2223.t.model.Address;
import com.teamdelicious.appadvc2223.t.model.CartDetails;

public class CartDetailsDTO {

    private Long id;

    private Long menuItemId;

    private Integer quantity;


    public CartDetailsDTO() {}

    public CartDetailsDTO(CartDetails cartDetails) {
        this.id = cartDetails.getId();
        this.menuItemId = cartDetails.getMenuItem().getId();
        this.quantity = cartDetails.getQuantity();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMenuItemId() {
        return menuItemId;
    }

    public void setMenuItemId(Long menuItemId) {
        this.menuItemId = menuItemId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
