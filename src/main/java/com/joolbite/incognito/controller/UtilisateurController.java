package com.joolbite.incognito.controller;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.joolbite.incognito.model.User;
import com.joolbite.incognito.repo.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/utilisateur")
@CrossOrigin("*")
public class UtilisateurController {

    @Autowired
    private IUserRepository repoUtilisateur;

    @GetMapping("/{id}")
    public User findUserById(@PathVariable Long id) {
        return repoUtilisateur.findUserById(id);
    }

}