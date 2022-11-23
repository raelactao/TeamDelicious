package com.teamdelicious.appadvc2223.t.services.impl;


import com.teamdelicious.appadvc2223.t.dto.CartDetailsDTO;
import com.teamdelicious.appadvc2223.t.dto.MenuItemDTO;
import com.teamdelicious.appadvc2223.t.dto.UserDTO;
import com.teamdelicious.appadvc2223.t.model.CartDetails;
import com.teamdelicious.appadvc2223.t.model.MenuItem;
import com.teamdelicious.appadvc2223.t.repository.CartMenuItemRepository;
import com.teamdelicious.appadvc2223.t.services.CartDetailsService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


public class CartDetailsServiceImpl implements CartDetailsService {

    @Autowired
    CartMenuItemRepository cartMenuItemRepository;

    @Override
    public List<CartDetailsDTO> list() {
        return StreamSupport.stream(cartMenuItemRepository.findAll().spliterator(), false)
                .map(CartDetailsDTO::new)
                .collect(Collectors.toList());
    }


    @Override
    public void add(CartDetailsDTO cartDetailsDTO) {
        cartMenuItemRepository.save(new CartDetails(cartDetailsDTO));
    }

    @Override
    public CartDetailsDTO get(Long id) {
        return new CartDetailsDTO(cartMenuItemRepository.findById(id).get());
    }

    @Override
    public void update(CartDetailsDTO updatedCartDetails) {
        cartMenuItemRepository.save(new CartDetails(updatedCartDetails));
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
