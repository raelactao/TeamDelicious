package com.teamdelicious.appadvc2223.t.services.impl;

import com.teamdelicious.appadvc2223.t.dto.ReservationDTO;
import com.teamdelicious.appadvc2223.t.model.Reservation;
import com.teamdelicious.appadvc2223.t.repository.ReservationRepository;
import com.teamdelicious.appadvc2223.t.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.validation.FieldError;


import javax.swing.text.html.HTML;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    ReservationRepository reservationRepository;



    @Override
    public List<ReservationDTO> list() {
        return StreamSupport.stream(reservationRepository.findAll().spliterator(), false)
                .map(ReservationDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public void add(ReservationDTO reservationDTO) {

        Reservation reservation = new Reservation(reservationDTO);

        reservationRepository.save(reservation);
        /*
        boolean isAvailable = true;
        for (ReservationDTO reservationDTO1 : list())
        {
            if (reservationDTO1.getReservedDateTime().equals(reservation.getReservedDateTime()))
            {
                isAvailable = false;
            }
        }

        if (!isAvailable)
        {
            String msg = "Reservation is already taken";

            new FieldError("reservation", "reservedDateTime", msg);

        }
        else
        {
            reservationRepository.save(reservation);
        }

        /*
        Set<ConstraintViolation<ReservationDTO>> violations = validator.validate(reservationDTO);

        if (!violations.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<ReservationDTO> constraintViolation : violations) {
                sb.append(constraintViolation.getMessage());
            }
            throw new ConstraintViolationException("Error occurred: " + sb.toString(), violations);
        }
        else {
            reservationRepository.save(new Reservation(reservationDTO));
        }
         */



    }

    @Override
    public ReservationDTO get(Long id) {
        return new ReservationDTO(reservationRepository.findById(id).get());
    }

    @Override
    public void update(ReservationDTO updatedReservation) {
        reservationRepository.save(new Reservation(updatedReservation));
    }

    @Override
    public void delete(Long id) {

        /*
        Long count = menuItemRepository.countById(id);
        if (count == null || count==0){
            throw new MenuItemNotFoundException("Could not find any user with ID" + id);
        }
        */

        reservationRepository.deleteById(id);
    }


    //enter unique reservation logic so it does not add if date/time has already been added
    public String validateReservedDateTime(ReservationDTO reservationDTO) {
        String message = "";

        for (ReservationDTO reservationDTO1 : list())
        {
            if (reservationDTO1.getReservedDateTime().equals(reservationDTO.getReservedDateTime()))
            {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, MMM dd yyyy 'at' H:mm a");
                message = reservationDTO.getReservedDateTime().format(formatter) +
                        " has already been reserved. Please select another time.";

            }
        }
        return message;
    }





}
