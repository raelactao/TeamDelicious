package com.teamdelicious.appadvc2223.t.services.impl;

import com.teamdelicious.appadvc2223.t.dto.AddressDTO;
import com.teamdelicious.appadvc2223.t.model.Address;
import com.teamdelicious.appadvc2223.t.repository.UserAddressRepository;
import com.teamdelicious.appadvc2223.t.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    UserAddressRepository userAddressRepository;

    @Override
    public void add(AddressDTO address) {
        userAddressRepository.save(new Address(address));
    }

}
