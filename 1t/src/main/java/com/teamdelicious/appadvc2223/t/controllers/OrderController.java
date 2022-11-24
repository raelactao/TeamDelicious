package com.teamdelicious.appadvc2223.t.controllers;


import com.teamdelicious.appadvc2223.t.services.CartDetailsService;
import com.teamdelicious.appadvc2223.t.services.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("order")
public class OrderController {

    //@Autowired
    //private CartDetailsService cartDetailsService;
    @Autowired
    private MenuItemService menuItemService;

    @GetMapping("/menu")
    private String list(Model model) {
        model.addAttribute("menuItems", menuItemService.list());
        return "order/index";
    }

}
