package com.teamdelicious.appadvc2223.t.services.impl;

import com.teamdelicious.appadvc2223.t.dto.UserDTO;
import com.teamdelicious.appadvc2223.t.model.User;
import com.teamdelicious.appadvc2223.t.repository.UserRepository;
import com.teamdelicious.appadvc2223.t.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * For this demo app, we are not yet connected to a database.
 * We manage the data here in the service layer.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<UserDTO> list() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false)
                    .map(UserDTO::new)
                    .collect(Collectors.toList());
    }

    @Override
    public void add(UserDTO userDTO) {
        userRepository.save(new User(userDTO));
    }

    @Override
    public UserDTO get(Long id) {
        return new UserDTO(userRepository.findById(id).get());
    }

    @Override
    public void update(UserDTO updatedUser) {
        userRepository.save(new User(updatedUser));
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

}
