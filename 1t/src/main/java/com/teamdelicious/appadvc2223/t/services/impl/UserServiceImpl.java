package com.teamdelicious.appadvc2223.t.services.impl;

import com.teamdelicious.appadvc2223.t.dto.UserDTO;
import com.teamdelicious.appadvc2223.t.model.User;
import com.teamdelicious.appadvc2223.t.repository.RoleRepository;
import com.teamdelicious.appadvc2223.t.repository.UserRepository;
import com.teamdelicious.appadvc2223.t.security.CommonBeanConfiguration;
import com.teamdelicious.appadvc2223.t.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<UserDTO> list() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false)
                    .map(UserDTO::new)
                    .collect(Collectors.toList());
    }

    @Override
    public void add(UserDTO userDTO) {
        User user = new User(userDTO);
        user.setRole(roleRepository.findByName(userDTO.getRole()));
        user.setPasswordHash(passwordEncoder.encode(userDTO.getPassword()));
        userRepository.save(user);

        //userRepository.save(new User(userDTO));
    }

    @Override
    public UserDTO get(Long id) {
        return new UserDTO(userRepository.findById(id).get());
    }

    @Override
    public void update(UserDTO updatedUser) {
        User user = new User(updatedUser);
        userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDTO validateUser(String emailAddress, String password) throws UsernameNotFoundException {
        User user = userRepository.findByEmailAddress(emailAddress);

        if (passwordEncoder.matches(password, user.getPasswordHash()))
        {
            return new UserDTO(user);
        }
        else
        {
            return null;
        }

    }


}
