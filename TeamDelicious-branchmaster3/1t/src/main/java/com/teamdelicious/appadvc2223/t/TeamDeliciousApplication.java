package com.teamdelicious.appadvc2223.t;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class TeamDeliciousApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeamDeliciousApplication.class, args);
	}

}
