package com.teamdelicious.appadvc2223.t.controllers;


import com.teamdelicious.appadvc2223.t.dto.CartDetailsDTO;
import com.teamdelicious.appadvc2223.t.services.CartDetailsService;
import com.teamdelicious.appadvc2223.t.services.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("order/customer")
public class CartDetailController {


    @Autowired
    private CartDetailsService cartDetailsService;
    @Autowired
    private MenuItemService menuItemService;


    @GetMapping
    private String list(Model model) {

        model.addAttribute("menuItems", menuItemService.list());
        model.addAttribute("cartDetails", cartDetailsService.list());
        return "cart/index";

    }

    /*
    @GetMapping("admin")
    private String listOrders(Model model) {

        model.addAttribute("cartDetails", cartDetailsService.list());
        return "order/admin-index";

    }


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

    @GetMapping("/{id}")
    private String getCartItem(@PathVariable Long id, Model model) {
        model.addAttribute("cartDetail", cartDetailsService.get(id));
        //model.addAttribute("menuItem", menuItemService.get(menuId));
        return "cart/view-cart-item";
    }

    @PutMapping
    private String updateCartItem(CartDetailsDTO cartDetailsDTO, Model model) {
        cartDetailsService.update(cartDetailsDTO);
        return list(model);
    }

    @GetMapping("/delete/{id}")
    private String deleteCartItem(@PathVariable Long id, Model model) {

        cartDetailsService.delete(id);
        return list(model);

    }

}
