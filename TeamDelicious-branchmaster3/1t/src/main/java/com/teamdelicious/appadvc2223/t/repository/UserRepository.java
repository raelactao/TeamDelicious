package com.teamdelicious.appadvc2223.t.repository;

import com.teamdelicious.appadvc2223.t.model.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Long> {

    User findByEmailAddress(String emailAddress);
}
