package com.teamdelicious.appadvc2223.t.services;

import com.teamdelicious.appadvc2223.t.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

public interface UserService {

    List<UserDTO> list();

    void add(UserDTO user);

    UserDTO get(Long id);

    void update(UserDTO updatedUser);

    void delete(Long id);

    UserDTO validateUser(String emailAddress, String password);

}
