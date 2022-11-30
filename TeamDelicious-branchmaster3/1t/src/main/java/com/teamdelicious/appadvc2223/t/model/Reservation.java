package com.teamdelicious.appadvc2223.t.model;

import com.teamdelicious.appadvc2223.t.dto.ReservationDTO;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Please input a date and time.")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Column(nullable = false)
    private LocalDateTime reservedDateTime;

    @NotEmpty(message = "Please enter a first name.")
    @Column(nullable = false)
    private String firstName;

    @NotEmpty(message = "Please enter a last name.")
    @Column(nullable = false)
    private String lastName;

    @NotEmpty(message = "Please enter a contact number.")
    @Column(nullable = false)
    private String contactNumber;

    @NotEmpty(message = "Please enter an email address.")
    @Email
    @Column(nullable = false)
    private String emailAddress;

    @Column
    private String paxNumber;

    public Reservation() {}

    public Reservation(Long id) {
        this.id = id;
    }

    public Reservation(ReservationDTO reservationDTO) {
        this.id = reservationDTO.getId();
        this.reservedDateTime = reservationDTO.getReservedDateTime();
        this.firstName = reservationDTO.getFirstName();
        this.lastName = reservationDTO.getLastName();
        this.contactNumber = reservationDTO.getContactNumber();
        this.emailAddress = reservationDTO.getEmailAddress();
        this.paxNumber = reservationDTO.getPaxNumber();
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getReservedDateTime() {
        return reservedDateTime;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPaxNumber() {
        return paxNumber;
    }

    public String getContactNumber() {
        return contactNumber;
    }

}
