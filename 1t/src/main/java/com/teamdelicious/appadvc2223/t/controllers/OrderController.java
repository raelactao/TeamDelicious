package com.teamdelicious.appadvc2223.t.controllers;


import com.teamdelicious.appadvc2223.t.dto.CartDetailsDTO;
import com.teamdelicious.appadvc2223.t.dto.MenuItemDTO;
import com.teamdelicious.appadvc2223.t.services.CartDetailsService;
import com.teamdelicious.appadvc2223.t.services.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@Controller
@RequestMapping("order")
public class OrderController {


    @Autowired
    private CartDetailsService cartDetailsService;
    @Autowired
    private MenuItemService menuItemService;


    @GetMapping
    private String list(Model model) {

        model.addAttribute("menuItems", menuItemService.list());
        model.addAttribute("cartDetails", cartDetailsService.list());
        return "order/index";

    }


    /*

    @PostMapping()
    private MenuItemDTO addItemToCart(List<MenuItemDTO> menuList) {
        menuItemService.add(menuItemDTO);
        return list(model);
    }
    */


    @PostMapping
    private String addToCart(@RequestParam(value = "menuItemId") Long id, CartDetailsDTO cartDetailsDTO, Model model) {
        cartDetailsDTO.setMenuItem(menuItemService.get(id).getName());
        cartDetailsService.add(cartDetailsDTO);
        return list(model);
    }


    /*

    @PostMapping("/{orderId}/cart")
    private String addCartDetails(@PathVariable Long orderId, CartDetailsDTO cartDetailsDTO, Model model) {
        cartDetailsDTO.setId(orderId);
        cartDetailsService.add(cartDetailsDTO);
        return getCartDetails(orderId, model);
    }


     */


}
