package com.joolbite.incognito.service;


import com.joolbite.incognito.model.Utilisateur;
import com.joolbite.incognito.repo.IUtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UtilisateurService {

    @Autowired
    private final IUtilisateurRepository IUtilisateurRepository;

    @Autowired
    public UtilisateurService(IUtilisateurRepository IUtilisateurRepository) {
        this.IUtilisateurRepository = IUtilisateurRepository;
    }

    public Utilisateur loadUtilisateurByPseudo(String pseudo) throws UsernameNotFoundException {

        Objects.requireNonNull(pseudo);
        Utilisateur utilisateur = IUtilisateurRepository.findUtilisateurWithPseudo(pseudo);

        return utilisateur;
    }

    public Utilisateur loadUtilisateurByMailAndMotDePasse(Utilisateur Utilisateur) throws UsernameNotFoundException {

        Objects.requireNonNull(Utilisateur.getMail());
        Objects.requireNonNull(Utilisateur.getMotDePasse());

        return IUtilisateurRepository.findUtilisateurByMailAndMotDePasse(Utilisateur.getMail(), Utilisateur.getMotDePasse());
    }

}