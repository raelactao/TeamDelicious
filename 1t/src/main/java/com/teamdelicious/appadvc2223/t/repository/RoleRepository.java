package com.teamdelicious.appadvc2223.t.repository;

import com.teamdelicious.appadvc2223.t.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByName(String name);
}
