package com.teamdelicious.appadvc2223.t.controllers;


import com.teamdelicious.appadvc2223.t.dto.ReservationDTO;
import com.teamdelicious.appadvc2223.t.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping()
    private String list(Model model) {
        model.addAttribute("reservations", reservationService.list());
        return "reservation/index";
    }


    @GetMapping("/create")
    private String getReservationAddForm(Model model) {
        model.addAttribute("reservation", new ReservationDTO());
        return "reservation/create";
    }

    @PostMapping
    private String addReservation(@Valid ReservationDTO reservationDTO, Model model) {
        reservationService.add(reservationDTO);
        return list(model);
    }

    @GetMapping("/{id}")
    private String getReservation(@PathVariable Long id, Model model) {
        model.addAttribute("reservation", reservationService.get(id));
        return "reservation/view-reserve";
    }

    @PutMapping
    private String updateReservation(@Valid ReservationDTO menuItemDTO, Model model) {
        reservationService.update(menuItemDTO);
        return list(model);
    }


    @GetMapping("/delete/{id}")
    private String deleteReservation(@PathVariable Long id, Model model) {

        /*
        try {
            menuItemService.delete(id);
            ra.addFlashAttribute("message", "The menu item ID: " + id + " has been deleted.");
        } catch (MenuItemNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/users";
         */
        reservationService.delete(id);
        return list(model);


    }


}
