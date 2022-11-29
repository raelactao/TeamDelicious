package com.teamdelicious.appadvc2223.t.services.impl;

import com.teamdelicious.appadvc2223.t.dto.MenuItemDTO;
import com.teamdelicious.appadvc2223.t.dto.ReservationDTO;
import com.teamdelicious.appadvc2223.t.model.MenuItem;
import com.teamdelicious.appadvc2223.t.model.Reservation;
import com.teamdelicious.appadvc2223.t.repository.MenuItemRepository;
import com.teamdelicious.appadvc2223.t.repository.ReservationRepository;
import com.teamdelicious.appadvc2223.t.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

        reservationRepository.save(new Reservation(reservationDTO));
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
}
