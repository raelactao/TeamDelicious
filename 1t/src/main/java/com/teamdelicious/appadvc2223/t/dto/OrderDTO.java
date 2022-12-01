package com.teamdelicious.appadvc2223.t.dto;

import java.util.Set;

public class OrderDTO {

    private Long id;

    private Long userId;

    private Set<CartDetailsDTO> cartDetailsList;

    private double amountPayable;

    public OrderDTO () {}

    /*
    public OrderDTO(Order order) {
        this.id = order.getId();

        this.amountPayable = order.getAmountPayable();
    }


     */


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Set<CartDetailsDTO> getCartDetailsList() {
        return cartDetailsList;
    }

    public void setCartDetailsList(Set<CartDetailsDTO> cartDetailsList) {
        this.cartDetailsList = cartDetailsList;
    }

    public double getAmountPayable() {
        return amountPayable;
    }

    public void setAmountPayable(double amountPayable) {
        this.amountPayable = amountPayable;
    }


}
