package com.joolbite.incognito;

import com.joolbite.incognito.controller.UtilisateurController;
import com.joolbite.incognito.model.User;
import com.joolbite.incognito.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
//import org.springframework.security.core.userdetails.UserDetails;

@SpringBootApplication
public class IncognitoApplication {

	public static void main(String[] args) {
		SpringApplication.run(IncognitoApplication.class, args);
	}
}


