package com.teamdelicious.appadvc2223.t.repository;

import com.teamdelicious.appadvc2223.t.model.Reservation;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;


public interface ReservationRepository extends CrudRepository<Reservation, Long> {

    Reservation findByReservedDateTime(LocalDateTime reservedTime);


}
