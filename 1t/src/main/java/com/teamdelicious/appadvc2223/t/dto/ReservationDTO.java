package com.teamdelicious.appadvc2223.t.dto;

import com.teamdelicious.appadvc2223.t.model.Reservation;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class ReservationDTO {
    private Long id;




    @NotNull(message = "Please input a date and time.")
    private LocalDateTime reservedDateTime;

    @NotEmpty(message = "Please enter a first name.")
    private String firstName;

    @NotEmpty(message = "Please enter a last name.")
    private String lastName;

    @NotEmpty(message = "Please enter a contact number.")
    private String contactNumber;

    @NotEmpty(message = "Please enter an email address.")
    @Email
    private String emailAddress;


    private String paxNumber;

    public ReservationDTO() {}

    public ReservationDTO(Long id, LocalDateTime dateTime, String firstName, String lastName, String contactNumber, String emailAddress, String paxNumber) {
        this.id = id;
        this.setReservedDateTime(dateTime);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setContactNumber(contactNumber);
        this.setEmailAddress(emailAddress);
        this.setPaxNumber(paxNumber);
    }



    public ReservationDTO(Reservation reservation) {
        this.setId(reservation.getId());
        this.setReservedDateTime(reservation.getReservedDateTime());
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

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    public LocalDateTime getReservedDateTime() {
        return reservedDateTime;
    }

    public void setReservedDateTime(LocalDateTime reservedDateTime) {
        this.reservedDateTime = reservedDateTime;
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
