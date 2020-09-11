package com.joolbite.incognito.service.authentification;

import com.joolbite.incognito.Utils.UpdatableBCrypt;
import com.joolbite.incognito.model.Utilisateur;
import com.joolbite.incognito.model.UtilisateurAuthData;
import com.joolbite.incognito.service.utilisateur.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthentificationService {

    @Autowired
    UtilisateurService utilisateurService;

    // Initialisation Bcrypt pour hash les mots de passe
    private static final UpdatableBCrypt bcrypt = new UpdatableBCrypt(11);


    // récupère l'utilisateur en base et génère un token s'il existe
     public UtilisateurAuthData rechercherUtilisateur(Utilisateur utilisateur){

        Utilisateur utilisateurExistant = utilisateurService.rechercherUtilisateurByMail(utilisateur);
        if(null == utilisateurExistant){
            throw new AuthenticationCredentialsNotFoundException("Erreur d'authentification : Le mail renseigné n'est pas correct ");
        }
        if(!utilisateurService.checkMotDePasseOk(utilisateur, utilisateurExistant)){
             throw new AuthenticationCredentialsNotFoundException("Erreur d'authentification : Le mot de passe renseigné n'est pas correct ");
         };
        UtilisateurAuthData utilisateurAuthData = genererToken(utilisateurExistant);
        return utilisateurAuthData;
    }

public UtilisateurAuthData genererToken(Utilisateur utilisateur){
         UtilisateurAuthData utilisateurAuthData = new UtilisateurAuthData(utilisateur);
         StringBuilder token = new StringBuilder().append(bcrypt.hash(utilisateur.getMail())).append(bcrypt.hash(utilisateur.getMotDePasse()));
         utilisateurAuthData.setToken(token.toString());
         return utilisateurAuthData;
}


}
