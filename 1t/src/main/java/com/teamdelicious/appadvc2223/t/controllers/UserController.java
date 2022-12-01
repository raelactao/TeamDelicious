package com.teamdelicious.appadvc2223.t.controllers;



import com.teamdelicious.appadvc2223.t.dto.AddressDTO;
import com.teamdelicious.appadvc2223.t.dto.ReservationDTO;
import com.teamdelicious.appadvc2223.t.dto.UserDTO;
import com.teamdelicious.appadvc2223.t.services.AddressService;
import com.teamdelicious.appadvc2223.t.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AddressService addressService;




    @GetMapping()
    private String list(Model model) {
        model.addAttribute("users", userService.list());
        return "user/index";
    }

    @GetMapping("/add")
    private String getUserAddForm(Model model) {
        model.addAttribute("user", new UserDTO());
        return "user/add-user";
    }

    @PostMapping
    private String add(UserDTO user, Model model) {
        userService.add(user);
        return list(model);
    }

    @GetMapping("/{id}")
    private String getUser(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.get(id));
        model.addAttribute("address", new AddressDTO());
        return "user/view-user";
    }

    @PutMapping
    private String updateUser(UserDTO user, Model model) {
        userService.update(user);
        return list(model);
    }

    @DeleteMapping
    private String deleteUser(UserDTO user, Model model) {
        userService.delete(user.getId());
        return list(model);
    }

    @PostMapping("/{userId}/address")
    private String addUserAddress(@PathVariable Long userId, AddressDTO addressDTO, Model model) {
        addressDTO.setUserId(userId);
        addressService.add(addressDTO);
        return getUser(userId, model);
    }

}

