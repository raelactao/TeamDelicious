package com.teamdelicious.appadvc2223.t.services;

import com.teamdelicious.appadvc2223.t.dto.CartDetailsDTO;
import com.teamdelicious.appadvc2223.t.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartDetailsService {

    List<CartDetailsDTO> list();

    CartDetailsDTO get(Long id);

    void add(CartDetailsDTO cartDetailsDTO);

    void update(CartDetailsDTO cartDetailsDTO);

    void delete(Long id);
}
