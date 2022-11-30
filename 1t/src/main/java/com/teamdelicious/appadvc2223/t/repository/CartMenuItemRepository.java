package com.teamdelicious.appadvc2223.t.repository;

import com.teamdelicious.appadvc2223.t.model.CartDetails;
import org.springframework.data.repository.CrudRepository;

public interface CartMenuItemRepository extends CrudRepository<CartDetails, Long> {


}
