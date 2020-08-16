package com.joolbite.incognito.service;


import com.joolbite.incognito.model.User;
import com.joolbite.incognito.repo.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService implements UserDetailsService{

    @Autowired
    private final IUserRepository IUserRepository;

    @Autowired
    public UserService(IUserRepository IUserRepository) {
        this.IUserRepository = IUserRepository;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Objects.requireNonNull(username);
        User user = IUserRepository.findUserWithName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return user;
    }

}