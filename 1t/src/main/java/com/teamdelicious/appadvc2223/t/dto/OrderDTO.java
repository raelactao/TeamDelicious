package com.teamdelicious.appadvc2223.t.dto;

import com.teamdelicious.appadvc2223.t.model.Order;

public class OrderDTO {

    public Long id;

    public String firstName;

    public String lastName;

    public String emailAddress;

    public String address;

    //public Long cartDetails;

    public double amountPayable;

    public OrderDTO () {}

    public OrderDTO(Order order) {
        this.id = order.getId();
        this.firstName = order.getFirstname();
        this.lastName = order.getLastname();
        this.emailAddress = order.getEmailAddress();
        this.address = order.getAddress();
        this.amountPayable = order.getAmountPayable();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    /*
    public Long getCartDetails() {
        return cartDetails;
    }

    public void setCartDetails(Long cartDetails) {
        this.cartDetails = cartDetails;
    }


     */
}
