package com.example.hm.homenmove.modeles;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Khaderik on 31/05/2016.
 */

public class Utilisateur {

    @SerializedName("Adresse")
    private Adresse adresse;
    @SerializedName("IdUtilisateur")
    private Integer idUtilisateur;
    @SerializedName("Pseudo")
    private String pseudo;
    @SerializedName("Nom")
    private String nom;
    @SerializedName("Prenom")
    private String prenom;
    @SerializedName("AdresseMail")
    private String adresseMail;
    @SerializedName("DateNaissance")
    private String dateNaissance;

    public Utilisateur(Adresse adresse, Integer idUtilisateur, String pseudo, String nom, String prenom, String adresseMail, String dateNaissance) {
        this.adresse = adresse;
        this.idUtilisateur = idUtilisateur;
        this.pseudo = pseudo;
        this.nom = nom;
        this.prenom = prenom;
        this.adresseMail = adresseMail;
        this.dateNaissance = dateNaissance;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Integer getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Integer idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresseMail() {
        return adresseMail;
    }

    public void setAdresseMail(String adresseMail) {
        this.adresseMail = adresseMail;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
}