package com.teamdelicious.appadvc2223.t.controllers;

import com.teamdelicious.appadvc2223.t.dto.ReservationDTO;
import com.teamdelicious.appadvc2223.t.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller("reserve/customer")
public class CustomerReserveController {



    @Autowired
    private ReservationService reservationService;

    @GetMapping("/")
    private String getHome(Model model) {
        return "index";
    }

    @GetMapping("create")
    private String getReservationAddForm(Model model) {
        model.addAttribute("reservation", new ReservationDTO());
        return "reserve/customer/create";
    }

    @PostMapping
    private String addReservation(ReservationDTO reservationDTO, Model model) {
        reservationService.add(reservationDTO);
        return "reserve/customer/create";
    }

}
