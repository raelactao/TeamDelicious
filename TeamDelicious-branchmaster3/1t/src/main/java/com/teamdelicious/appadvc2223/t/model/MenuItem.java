package com.teamdelicious.appadvc2223.t.model;


import com.teamdelicious.appadvc2223.t.dto.CartDetailsDTO;
import com.teamdelicious.appadvc2223.t.dto.MenuItemDTO;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "menuItem")
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min=2, max=70, message = "Name needs to be between 2 to 70 characters" )
    @NotNull(message = "Please enter a name")
    @Column(nullable = false)
    private String name;

    //@Column(nullable = false)
    //private String category;

    @Column
    private String description;

    @NotNull(message = "Please enter a price.")
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
