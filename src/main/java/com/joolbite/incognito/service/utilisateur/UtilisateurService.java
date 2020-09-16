package com.joolbite.incognito.service.utilisateur;


import com.joolbite.incognito.Utils.UpdatableBCrypt;
import com.joolbite.incognito.model.Utilisateur;
import com.joolbite.incognito.repo.IUtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.function.Function;

@Service
public class UtilisateurService {

    private final IUtilisateurRepository IUtilisateurRepository;

    public UtilisateurService(IUtilisateurRepository IUtilisateurRepository) {
        this.IUtilisateurRepository = IUtilisateurRepository;
    }

    // Initialisation Bcrypt pour hash les mots de passe
    private static final UpdatableBCrypt bcrypt = new UpdatableBCrypt(11);


    public Utilisateur loadUtilisateurByPseudo(String pseudo) throws UsernameNotFoundException {

        Objects.requireNonNull(pseudo);
        Utilisateur utilisateur = IUtilisateurRepository.findUtilisateurByPseudo(pseudo);

        return utilisateur;
    }

    public Utilisateur rechercherUtilisateurByMail(Utilisateur utilisateur) throws UsernameNotFoundException {

        Objects.requireNonNull(utilisateur.getMail());

        return IUtilisateurRepository.findUtilisateurByMail(utilisateur.getMail());
    }

    public Utilisateur creerUtilisateur(Utilisateur utilisateur){
        Objects.requireNonNull(utilisateur.getMail());
        Objects.requireNonNull(utilisateur.getMotDePasse());

        hashInfosUtilisateur(utilisateur);

        return IUtilisateurRepository.save(utilisateur);
    }

    public Utilisateur hashInfosUtilisateur(Utilisateur utilisateur ){
        utilisateur.setMotDePasse(bcrypt.hash(utilisateur.getMotDePasse()));
        return utilisateur;
    }

    public boolean checkMotDePasseOk(Utilisateur utilisateur, Utilisateur utilisateurExistant){

        return bcrypt.verifyHash(utilisateur.getMotDePasse(), utilisateurExistant.getMotDePasse());
    }

}