package com.teamdelicious.appadvc2223.t.controllers;


import com.teamdelicious.appadvc2223.t.dto.MenuItemDTO;
import com.teamdelicious.appadvc2223.t.services.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("menu")
public class MenuController {

    @Autowired
    private MenuItemService menuItemService;

    @GetMapping()
    private String list(Model model) {
        model.addAttribute("menuItems", menuItemService.list());
        return "menu/index";
    }

    @GetMapping("/add")
    private String getMenuItemAddForm(Model model) {
        model.addAttribute("menuItem", new MenuItemDTO());
        return "menu/add-menu";
    }

    @PostMapping
    private String add(@Valid @ModelAttribute("menuItem") MenuItemDTO menuItem, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("menuItem", menuItem);
            return "menu/add-menu";
        }
        menuItemService.add(menuItem);
        return list(model);
    }

    @GetMapping("/{id}")
    private String getMenuItem(@PathVariable Long id, Model model) {
        model.addAttribute("menuItem", menuItemService.get(id));
        return "menu/view-menu";
    }

    @PutMapping
    private String updateMenuItem(MenuItemDTO menuItemDTO, BindingResult result, Model model) {
        menuItemService.update(menuItemDTO);
        return list(model);
    }


    @GetMapping("delete/{id}")
    private String deleteMenuItem(MenuItemDTO menuItemDTO, Model model) {

        /*
        try {
            menuItemService.delete(id);
            ra.addFlashAttribute("message", "The menu item ID: " + id + " has been deleted.");
        } catch (MenuItemNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/users";
         */
        menuItemService.delete(menuItemDTO.getId());
        return list(model);


    }

}
