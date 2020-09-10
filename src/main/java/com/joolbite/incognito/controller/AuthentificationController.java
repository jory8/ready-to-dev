package com.joolbite.incognito.controller;

import com.joolbite.incognito.model.Utilisateur;
import com.joolbite.incognito.service.authentification.AuthentificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/login")
@CrossOrigin("*")
public class AuthentificationController {

    @Autowired
    private AuthentificationService authService;

    @GetMapping("")
    public Utilisateur findUtilisateur(@PathVariable Utilisateur utilisateur) {
        Utilisateur utilisateur1;
        utilisateur1 = authService.rechercherUtilisateur(utilisateur);
        return utilisateur1;
    }

    // TODO
    @GetMapping("/jory")
    public Utilisateur findJory() {
        Utilisateur jory = new Utilisateur();
        jory.setMotDePasse("motDePasseJory");
        jory.setMail("jory.labat@gmail.com");
        jory = authService.rechercherUtilisateur(jory);
        return jory;
    }

}