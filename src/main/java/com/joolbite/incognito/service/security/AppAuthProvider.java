package com.joolbite.incognito.service.security;

import com.joolbite.incognito.model.User;
import com.joolbite.incognito.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

public class AppAuthProvider extends DaoAuthenticationProvider {

    @Autowired
    UserService userDetailsService;

    public Authentication authenticate(User user) throws AuthenticationException {

        String name = user.getMail();
        String password = user.getPassword();

        User userExistant = userDetailsService.loadUserByUsername(name);

        if (userExistant == null) {
            throw new BadCredentialsException("Username/Password does not match");
        }

        return new UsernamePasswordAuthenticationToken(userExistant, null, userExistant.getAuthorities());

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;

    }
}