package com.joolbite.incognito.model;

public class UtilisateurAuthData {

    private Utilisateur utilisateur;
    private String token;

    public UtilisateurAuthData() {
    }

    public UtilisateurAuthData(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


}
