package com.teamdelicious.appadvc2223.t.controllers;

import com.teamdelicious.appadvc2223.t.dto.ReservationDTO;
import com.teamdelicious.appadvc2223.t.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("reserve/customer")
public class CustomerReserveController {



    @Autowired
    private ReservationService reservationService;


    @GetMapping()
    private String getReservationAddForm(Model model) {
        model.addAttribute("reservation", new ReservationDTO());
        return "reserve/customer/create";
    }

    @PostMapping
    private String addReservation(@Valid @ModelAttribute("reservation") ReservationDTO reservationDTO,
                                  BindingResult result, Model model) {
        String err = reservationService.validateReservedDateTime(reservationDTO);
        if (!err.isEmpty()) {
            ObjectError error = new ObjectError("globalError", err);
            result.addError(error);
        }
        if (result.hasErrors()) {
            return "reserve/customer/create";
        }
        else {
            model.addAttribute("success", "Reservation added successfully.");
        }
        reservationService.add(reservationDTO);
        return "reserve/customer/create";
    }

}
