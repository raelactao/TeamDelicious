package com.teamdelicious.appadvc2223.t.services.impl;


import com.teamdelicious.appadvc2223.t.dto.CartDetailsDTO;
import com.teamdelicious.appadvc2223.t.dto.MenuItemDTO;
import com.teamdelicious.appadvc2223.t.dto.UserDTO;
import com.teamdelicious.appadvc2223.t.errorhandler.MenuItemAlreadyExists;
import com.teamdelicious.appadvc2223.t.model.CartDetails;
import com.teamdelicious.appadvc2223.t.model.MenuItem;
import com.teamdelicious.appadvc2223.t.model.User;
import com.teamdelicious.appadvc2223.t.repository.CartMenuItemRepository;
import com.teamdelicious.appadvc2223.t.repository.MenuItemRepository;
import com.teamdelicious.appadvc2223.t.services.CartDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.openmbean.KeyAlreadyExistsException;
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

                //cartDetails.setMenuItem(menuItemRepository.findByName(cartDetailsDTO1.getMenuItem()));
                cartDetailsDTO1.setQuantity(cartDetailsDTO1.getQuantity() + 1);
                cartMenuItemRepository.save(new CartDetails(cartDetailsDTO1));
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
