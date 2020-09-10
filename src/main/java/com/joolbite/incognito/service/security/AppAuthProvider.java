package com.joolbite.incognito.service.security;

import com.joolbite.incognito.model.Utilisateur;
import com.joolbite.incognito.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class AppAuthProvider extends DaoAuthenticationProvider {

    @Autowired
    UtilisateurService utilisateurService;

    public Authentication authenticate(Utilisateur utilisateur) throws AuthenticationException {

        String name = utilisateur.getMail();
        String password = utilisateur.getMotDePasse();

        Utilisateur utilisateurExistant = utilisateurService.loadUtilisateurByPseudo(name);

        if (utilisateurExistant == null) {
            throw new BadCredentialsException("Username/Password does not match");
        }

        return new UsernamePasswordAuthenticationToken(utilisateurExistant, null);

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;

    }
}