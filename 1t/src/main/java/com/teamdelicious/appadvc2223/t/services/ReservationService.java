package com.teamdelicious.appadvc2223.t.services;


import com.teamdelicious.appadvc2223.t.dto.ReservationDTO;
import com.teamdelicious.appadvc2223.t.model.Reservation;

import java.util.List;

public interface ReservationService {

    List<ReservationDTO> list();

    void add(ReservationDTO reservationDTO);

    ReservationDTO get(Long id);

    void update(ReservationDTO updatedReservation);

    void delete(Long id);

    String validateReservedDateTime(Reservation reservation);
}
