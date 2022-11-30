package com.teamdelicious.appadvc2223.t.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class CommonBeanConfiguration {

    @Bean
    public PasswordEncoder encoder () { return new BCryptPasswordEncoder(); }

}
