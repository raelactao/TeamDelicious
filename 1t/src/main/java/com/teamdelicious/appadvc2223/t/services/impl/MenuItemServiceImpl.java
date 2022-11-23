package com.teamdelicious.appadvc2223.t.services.impl;

import com.teamdelicious.appadvc2223.t.dto.MenuItemDTO;
import com.teamdelicious.appadvc2223.t.dto.UserDTO;
import com.teamdelicious.appadvc2223.t.model.MenuItem;
import com.teamdelicious.appadvc2223.t.model.User;
import com.teamdelicious.appadvc2223.t.repository.MenuItemRepository;
import com.teamdelicious.appadvc2223.t.services.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MenuItemServiceImpl implements MenuItemService {

    @Autowired
    MenuItemRepository menuItemRepository;

    @Override
    public List<MenuItemDTO> list() {
        return StreamSupport.stream(menuItemRepository.findAll().spliterator(), false)
                .map(MenuItemDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public void add(MenuItemDTO menuItemDTO) {
        //MenuItem menuItem = new MenuItem(menuItemDTO);
        //menuItemRepository.save(menuItem);

        menuItemRepository.save(new MenuItem(menuItemDTO));
    }

    @Override
    public MenuItemDTO get(Long id) {
        return new MenuItemDTO(menuItemRepository.findById(id).get());
    }

    @Override
    public void update(MenuItemDTO updatedMenuItem) {
        menuItemRepository.save(new MenuItem(updatedMenuItem));
    }

    @Override
    public void delete(Long id) throws MenuItemNotFoundException {
        Long count = menuItemRepository.countById(id);
        if (count == null || count==0){
            throw new MenuItemNotFoundException("Could not find any user with ID" + id);
        }
        menuItemRepository.deleteById(id);
    }



}
