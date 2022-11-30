package com.teamdelicious.appadvc2223.t.controllers;



import com.teamdelicious.appadvc2223.t.dto.UserDTO;
import com.teamdelicious.appadvc2223.t.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("register")
public class RegistrationController {

    private static final String CUSTOMER_ROLE = "ROLE_CUSTOMER";

    @Autowired
    private UserService userService;

    @GetMapping
    private String index(Model model) {
        model.addAttribute("user", new UserDTO());
        return "register/index";
    }

    @PostMapping
    private String register(UserDTO userDTO, Model model) {
        userDTO.setRole(CUSTOMER_ROLE);
        userService.add(userDTO);
        return "redirect:/login";
    }

}
