package com.joolbite.incognito.controller;

import com.joolbite.incognito.model.Utilisateur;
import com.joolbite.incognito.model.UtilisateurAuthData;
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
    public UtilisateurAuthData findJory(@RequestBody Utilisateur utilisateur
    ) {
        UtilisateurAuthData utilisateurExistant = authService.rechercherUtilisateur(utilisateur);
        return utilisateurExistant;
    }


}