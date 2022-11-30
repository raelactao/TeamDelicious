package com.teamdelicious.appadvc2223.t.services;

import com.teamdelicious.appadvc2223.t.dto.ReservationDTO;
import com.teamdelicious.appadvc2223.t.model.Reservation;
import com.teamdelicious.appadvc2223.t.services.ReservationDateTimeConstraint;
import com.teamdelicious.appadvc2223.t.services.ReservationService;
import net.bytebuddy.asm.Advice;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReservationValidation implements ConstraintValidator<ReservationDateTimeConstraint, String> {

    @Autowired
    ReservationService reservationService;

    @Override
    public void initialize(ReservationDateTimeConstraint contactNumber) {
    }

    @Override
    public boolean isValid(String reservationField,
                           ConstraintValidatorContext cxt) {
        boolean reservationTaken = false;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime reservedDate = LocalDateTime.parse(reservationField, formatter);

        for (ReservationDTO reservationDTO1 : reservationService.list())
        {
            if (reservationDTO1.getReservedDateTime().equals(reservedDate))
            {
                //message = reservation.getReservedDateTime() + "has already been reserved. Please select another time.";
                reservationTaken = true;
            }
        }

        return reservationField != null && !reservationTaken;
    }

}
