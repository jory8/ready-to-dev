package com.joolbite.incognito;

import com.joolbite.incognito.model.User;
import com.joolbite.incognito.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
//import org.springframework.security.core.userdetails.UserDetails;

@SpringBootApplication
public class IncognitoApplication {

	@Autowired
	static
	UserService userDetailsService;

	public static void main(String[] args) {

		SpringApplication.run(IncognitoApplication.class, args);
		System.out.println("<html>Bonjour <br /> J'aime les biscuits</html>");
//		User lepetit =  userDetailsService.loadUserByUsername("Admin");
//		System.out.println("user et pwd ===> " + lepetit.getUsername() + " " + lepetit.getPassword());
	}
}
