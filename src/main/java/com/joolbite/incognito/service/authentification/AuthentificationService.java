package com.joolbite.incognito.service.authentification;

import com.joolbite.incognito.model.Utilisateur;
import com.joolbite.incognito.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthentificationService {

    @Autowired
    UtilisateurService utilisateurService;

     public Utilisateur rechercherUtilisateur(Utilisateur utilisateur){

        Utilisateur utilisateurExistant = utilisateurService.rechercherUtilisateurByMail(utilisateur);
        if(null == utilisateurExistant){
            throw new AuthenticationCredentialsNotFoundException("Erreur d'authentification : Le mail renseigné n'est pas correct ");
        }
        if(!utilisateurService.checkMotDePasseOk(utilisateur, utilisateurExistant)){
             throw new AuthenticationCredentialsNotFoundException("Erreur d'authentification : Le mot de passe renseigné n'est pas correct ");
         };

        return utilisateurExistant;
    }


}
