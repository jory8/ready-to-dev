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

    public User loadUserByUsername(String username) throws UsernameNotFoundException {

        Objects.requireNonNull(username);
        User user = IUserRepository.findUserWithName(username);

        return user;
    }

    public User loadUserByMailAndPassword(User user) throws UsernameNotFoundException {

        Objects.requireNonNull(user.getMail());
        Objects.requireNonNull(user.getPassword());

        return IUserRepository.findUserByMailAndPassword(user.getMail(), user.getPassword());
    }

}