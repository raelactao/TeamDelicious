package com.teamdelicious.appadvc2223.t.model;


import javax.persistence.*;

@Entity
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String Lastname;

    @Column
    private String Firstname;


    /*
    @ManyToOne
    @JoinColumn(name = "cartDetails_id", nullable = false)
    private Car menuItem;
    */

}
