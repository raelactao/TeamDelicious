package com.teamdelicious.appadvc2223.t.dto;

import com.teamdelicious.appadvc2223.t.model.Reservation;

public class ReservationDTO {
    private Long id;

    private String firstName;

    private String lastName;

    private String contactNumber;

    private String emailAddress;

    private String paxNumber;

    public ReservationDTO() {}

    public ReservationDTO(Long id, String firstName, String lastName, String contactNumber, String emailAddress, String paxNumber) {
        this.id = id;
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setContactNumber(contactNumber);
        this.setEmailAddress(emailAddress);
        this.setPaxNumber(paxNumber);
    }



    public ReservationDTO(Reservation reservation) {
        this.setId(reservation.getId());
        this.setFirstName(reservation.getFirstName());
        this.setLastName(reservation.getLastName());
        this.setContactNumber(reservation.getContactNumber());
        this.setEmailAddress(reservation.getEmailAddress());
        this.setPaxNumber(reservation.getPaxNumber());
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

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPaxNumber() {
        return paxNumber;
    }

    public void setPaxNumber(String paxNumber) {
        this.paxNumber = paxNumber;
    }
}
