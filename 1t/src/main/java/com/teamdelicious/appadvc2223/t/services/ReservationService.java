package com.teamdelicious.appadvc2223.t.services;


import com.teamdelicious.appadvc2223.t.dto.ReservationDTO;

import java.util.List;

public interface ReservationService {

    List<ReservationDTO> list();

    void add(ReservationDTO menuItemDTO);

    ReservationDTO get(Long id);

    void update(ReservationDTO updatedMenuItem);

    void delete(Long id);
}
