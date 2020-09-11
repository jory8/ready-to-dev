package com.joolbite.incognito.controller;

import com.joolbite.incognito.model.Utilisateur;
import com.joolbite.incognito.repo.IUtilisateurRepository;
import com.joolbite.incognito.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/utilisateur")
@CrossOrigin("*")
public class UtilisateurController {

    @Autowired
    private IUtilisateurRepository repoUtilisateur;

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping("/{id}")
    public Utilisateur findUserById(@PathVariable Long id) {
        return repoUtilisateur.findUtilisateurById(id);
    }

    @PostMapping("/creer")
    public Utilisateur createUtilisateur(@RequestBody Utilisateur utilisateur) {
        return utilisateurService.creerUtilisateur(utilisateur);
    }


}