package com.joolbite.incognito.controller;

import com.joolbite.incognito.model.Utilisateur;
import com.joolbite.incognito.repo.IUtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/utilisateur")
@CrossOrigin("*")
public class UtilisateurController {

    @Autowired
    private IUtilisateurRepository repoUtilisateur;

    @GetMapping("/{id}")
    public Utilisateur findUserById(@PathVariable Long id) {
        return repoUtilisateur.findUtilisateurById(id);
    }

    @PostMapping("")
    public Utilisateur create(@RequestBody Utilisateur utilisateur) {
        return repoUtilisateur.save(utilisateur);
    }


}