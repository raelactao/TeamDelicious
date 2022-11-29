package com.teamdelicious.appadvc2223.t.services.impl;


import com.teamdelicious.appadvc2223.t.dto.CartDetailsDTO;
import com.teamdelicious.appadvc2223.t.model.CartDetails;
import com.teamdelicious.appadvc2223.t.model.MenuItem;
import com.teamdelicious.appadvc2223.t.repository.CartMenuItemRepository;
import com.teamdelicious.appadvc2223.t.repository.MenuItemRepository;
import com.teamdelicious.appadvc2223.t.services.CartDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CartDetailsServiceImpl implements CartDetailsService {

    @Autowired
    CartMenuItemRepository cartMenuItemRepository;

    @Autowired
    MenuItemRepository menuItemRepository;

    @Override
    public List<CartDetailsDTO> list() {
        return StreamSupport.stream(cartMenuItemRepository.findAll().spliterator(), false)
                .map(CartDetailsDTO::new)
                .collect(Collectors.toList());
    }


    @Override
    public void add(CartDetailsDTO cartDetailsDTO) {

        CartDetails cartDetails = new CartDetails(cartDetailsDTO);
        cartDetails.setQuantity(1);
        MenuItem menuItem = menuItemRepository.findByName(cartDetailsDTO.getMenuItem());

        boolean isExistingInCart = false;

        for(CartDetailsDTO cartDetailsDTO1 : list()) {
            if (menuItem.getId() == menuItemRepository.findByName(cartDetailsDTO1.getMenuItem()).getId()) {

                CartDetails cartDetails1 = new CartDetails(cartDetailsDTO1);
                MenuItem menuItem1 = cartMenuItemRepository.findById(cartDetailsDTO1.getId()).get().getMenuItem();
                cartDetails1.setMenuItem(menuItem1);
                cartDetails1.setQuantity(cartDetails1.getQuantity() + 1);
                cartDetails1.setTotal(cartDetails1.getQuantity() * menuItem1.getPrice());
                cartMenuItemRepository.save(cartDetails1);
                isExistingInCart = true;
            }
        }

        if (!isExistingInCart)
        {
            cartDetails.setMenuItem(menuItem);
            cartDetails.setTotal(cartDetails.getQuantity() * menuItem.getPrice());
            cartMenuItemRepository.save(cartDetails);
        }



    }

    @Override
    public CartDetailsDTO get(Long id) {
        return new CartDetailsDTO(cartMenuItemRepository.findById(id).get());
    }

    @Override
    public void update(CartDetailsDTO updatedCartDetails) {
        CartDetails cartDetails = new CartDetails(updatedCartDetails);
        //MenuItem menuItem = menuItemRepository.findByName(updatedCartDetails.getMenuItem());
        MenuItem menuItem = cartMenuItemRepository.findById(updatedCartDetails.getId()).get().getMenuItem();
        double total = cartDetails.getQuantity() * menuItem.getPrice();
        cartDetails.setMenuItem(menuItem);
        cartDetails.setTotal(total);
        cartMenuItemRepository.save(cartDetails);
    }

    @Override
    public void delete(Long id) {

        /*
        Long count = menuItemRepository.countById(id);
        if (count == null || count==0){
            throw new MenuItemNotFoundException("Could not find any user with ID" + id);
        }
        */

        cartMenuItemRepository.deleteById(id);
    }



}
