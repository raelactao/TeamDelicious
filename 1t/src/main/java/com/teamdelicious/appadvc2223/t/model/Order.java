package com.teamdelicious.appadvc2223.t.model;


import com.teamdelicious.appadvc2223.t.dto.OrderDTO;

import javax.persistence.*;

@Entity
public class Order {

    @Id
    @GeneratedValue
    private Long id;


    @Column
    private String Firstname;

    @Column
    private String Lastname;

    @Column
    private String emailAddress;

    @Column
    private String address;


    /*
    @OneToOne
    @JoinColumn(name = "cartDetails_id", nullable = false)
    private CartDetails cartDetails;


     */

    @Column
    private double amountPayable;

    public Order() {}

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getAddress() {
        return address;
    }

    public Order(OrderDTO orderDTO) {
        this.id = orderDTO.getId();
        this.Firstname = orderDTO.getFirstName();
        this.Lastname = orderDTO.getLastName();
        this.emailAddress = orderDTO.getEmailAddress();
        this.address = orderDTO.getAddress();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    /*
    public CartDetails getCartDetails() {
        //return cartDetails;
    }

    public void setCartDetails(CartDetails cartDetails) {
        //this.cartDetails = cartDetails;
    }


     */

    public double getAmountPayable() {
        return amountPayable;
    }

    public void setAmountPayable(double amountPayable) {
        this.amountPayable = amountPayable;
    }
}
