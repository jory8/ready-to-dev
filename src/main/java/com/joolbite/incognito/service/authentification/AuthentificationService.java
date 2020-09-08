package com.joolbite.incognito.service.authentification;

import com.joolbite.incognito.model.User;
import com.joolbite.incognito.repo.IUserRepository;
import com.joolbite.incognito.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
public class AuthentificationService {

    @Autowired
    UserService userService;

     public User rechercherUser(User user){
        User userExistant = userService.loadUserByMailAndPassword(user);
        if(null == userExistant){
            throw new AuthenticationCredentialsNotFoundException("Erreur d'authentification : Le mail et/ou le mot de passe ne sont pas corrects ");
        }
        return userExistant;
    }



}
