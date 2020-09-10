package com.joolbite.incognito.model;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "utilisateur")
public class Utilisateur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long utilisateurId;
    private String pseudo;
    private String motDePasse;
    private String mail;
    public String getMail() {return mail; }
    public Long getUtilisateurId() {
        return utilisateurId;
    }
    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMotDePasse() {
        return motDePasse;
    }
    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }
    public void setMail(String mail) {this.mail = mail; }
}