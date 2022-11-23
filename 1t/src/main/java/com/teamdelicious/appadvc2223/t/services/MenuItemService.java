package com.teamdelicious.appadvc2223.t.services;

import com.teamdelicious.appadvc2223.t.dto.MenuItemDTO;

import java.util.List;

public interface MenuItemService {

    List<MenuItemDTO> list();

    void add(MenuItemDTO menuItemDTO);

    MenuItemDTO get(Long id);

    void update(MenuItemDTO updatedMenuItem);

    void delete(Long id);


}
