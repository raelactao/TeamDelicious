package com.teamdelicious.appadvc2223.t.repository;

import com.teamdelicious.appadvc2223.t.model.Address;
import org.springframework.data.repository.CrudRepository;

public interface UserAddressRepository extends CrudRepository<Address, Long> {
}
