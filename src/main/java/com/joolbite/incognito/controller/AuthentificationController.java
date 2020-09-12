package com.joolbite.incognito.controller;

import com.joolbite.incognito.model.Utilisateur;
import com.joolbite.incognito.model.UtilisateurAuthData;
import com.joolbite.incognito.service.authentification.AuthentificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/login")
@CrossOrigin
public class AuthentificationController {

    @Autowired
    private AuthentificationService authService;

    @PostMapping(value = "/authentification", consumes = MediaType.APPLICATION_JSON_VALUE)
    public UtilisateurAuthData findJory(@RequestBody Utilisateur utilisateur
    ) {
        System.out.println("Appel du service authentifierUtilisateur");
        UtilisateurAuthData utilisateurExistant = authService.rechercherUtilisateur(utilisateur);
        return utilisateurExistant;
    }

    @PostMapping(value = "/inscription", consumes = MediaType.APPLICATION_JSON_VALUE)
    public UtilisateurAuthData inscrireUtilisateur(@RequestBody Utilisateur utilisateur
    ) {
        System.out.println("Appel du service inscrireUtilisateur");
        UtilisateurAuthData utilisateurExistant = authService.inscrireUtilisateur(utilisateur);
        return utilisateurExistant;
    }


}