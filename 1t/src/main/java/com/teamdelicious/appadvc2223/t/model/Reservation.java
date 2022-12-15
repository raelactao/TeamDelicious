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


    @Column(nullable = false)
    private LocalDateTime reservedDateTime;


    @Column(nullable = false)
    private String firstName;


    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String contactNumber;

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
