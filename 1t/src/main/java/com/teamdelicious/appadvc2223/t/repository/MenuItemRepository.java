package com.teamdelicious.appadvc2223.t.repository;

import com.teamdelicious.appadvc2223.t.model.MenuItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface MenuItemRepository extends CrudRepository<MenuItem, Long> {

    //MenuItem findByName(String name);
    Long countById(Long id);

}
