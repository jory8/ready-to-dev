package com.joolbite.incognito.repo;

import com.joolbite.incognito.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface IUtilisateurRepository extends JpaRepository<Utilisateur, Integer> {

    @Query(" select u from Utilisateur u" +
            " where u.pseudo = :pseudo")
    Utilisateur findUtilisateurWithPseudo(@Param("pseudo")String pseudo);

    @Query(" select u from Utilisateur u" +
            " where u.utilisateurId = :id")
    Utilisateur findUtilisateurById(@Param("id")Long id);

    @Query(" select u from Utilisateur u" +
            " where u.mail = :mail")
    Utilisateur findUtilisateurByMail(@Param("mail")String mail);


}
