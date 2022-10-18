package com.teamdelicious.appadvc2223.t.dto;

import com.teamdelicious.appadvc2223.t.model.Address;

import javax.persistence.Column;

public class AddressDTO {

    private Long id;

    private Long userId;

    private String city;

    private String addressLine1;

    private String addressLine2;

    public AddressDTO() {}

    public AddressDTO(Address address) {
        this.id = address.getId();
        this.userId = address.getUser().getId();
        this.city = address.getCity();
        this.addressLine1 = address.getAddressLine1();
        this.addressLine2 = address.getAddressLine2();
    }

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }
}
