package com.teamdelicious.appadvc2223.t.services.impl;

import com.teamdelicious.appadvc2223.t.dto.ReservationDTO;
import com.teamdelicious.appadvc2223.t.model.Reservation;
import com.teamdelicious.appadvc2223.t.repository.ReservationRepository;
import com.teamdelicious.appadvc2223.t.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.xml.validation.Validator;
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



        /*
        Set<ConstraintViolation<Reservation>> violations = validateReservedDateTime(reservation);

        if (!violations.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<Reservation> constraintViolation : violations) {
                sb.append(constraintViolation.getMessage());
            }
            throw new ConstraintViolationException("Error occurred: " + sb.toString(), violations);
        }
       */

        reservationRepository.save(reservation);
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

    /*
    //enter unique reservation logic so it does not add if date/time has already been added
    public String validateReservedDateTime(Reservation reservation) {
        String message = "";

        for (ReservationDTO reservationDTO1 : list())
        {
            if (reservationDTO1.getReservedDateTime().equals(reservation.getReservedDateTime()))
            {
                message = reservation.getReservedDateTime() + "has already been reserved. Please select another time.";

            }
        }
        return message;
    }

     */



}
