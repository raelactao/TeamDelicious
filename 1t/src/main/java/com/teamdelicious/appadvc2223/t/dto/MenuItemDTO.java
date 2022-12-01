package com.teamdelicious.appadvc2223.t.dto;


import com.teamdelicious.appadvc2223.t.model.MenuItem;

import javax.validation.constraints.*;

public class MenuItemDTO {

    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Description is required")
    private String description;

    @PositiveOrZero(message = "Price must not be a negative number.")
    private double price;

    public MenuItemDTO() {} ;

    public MenuItemDTO(MenuItem menuItem) {
        this.id = menuItem.getId();
        this.name = menuItem.getName();
        this.description = menuItem.getDescription();
        this.price = (long) menuItem.getPrice();

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}
