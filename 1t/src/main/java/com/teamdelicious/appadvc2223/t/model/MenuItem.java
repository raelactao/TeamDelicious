package com.teamdelicious.appadvc2223.t.model;


import com.teamdelicious.appadvc2223.t.dto.CartDetailsDTO;
import com.teamdelicious.appadvc2223.t.dto.MenuItemDTO;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "menuItem")
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    //@Column(nullable = false)
    //private String category;

    @Column
    private String description;

    @Column
    private double price;


    @OneToOne(mappedBy = "menuItem", cascade = CascadeType.REMOVE)
    private CartDetails cartDetails;

    public MenuItem() {}

    public MenuItem(Long id) {
        this.id = id;
    }

    public MenuItem(MenuItemDTO menuItemDTO) {
        this.id = menuItemDTO.getId();
        this.name = menuItemDTO.getName();
        this.description = menuItemDTO.getDescription();
        this.price = menuItemDTO.getPrice();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }



}
