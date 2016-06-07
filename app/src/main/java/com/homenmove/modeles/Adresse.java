package com.homenmove.modeles;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Khaderik on 31/05/2016.
 */

public class Adresse {

    @SerializedName("IdAdresse")
    private Integer idAdresse;
    @SerializedName("NumeroVoie")
    private Integer numeroVoie;
    @SerializedName("NomVoie")
    private String nomVoie;
    @SerializedName("Complement")
    private String complement;
    @SerializedName("CodePostal")
    private Integer codePostal;
    @SerializedName("Ville")
    private String ville;
    @SerializedName("Pays")
    private String pays;

    public Adresse(Integer idAdresse, Integer numeroVoie, String nomVoie, String complement, Integer codePostal, String ville, String pays) {
        this.idAdresse = idAdresse;
        this.numeroVoie = numeroVoie;
        this.nomVoie = nomVoie;
        this.complement = complement;
        this.codePostal = codePostal;
        this.ville = ville;
        this.pays = pays;
    }

    public Integer getIdAdresse() {
        return idAdresse;
    }

    public void setIdAdresse(Integer idAdresse) {
        this.idAdresse = idAdresse;
    }

    public Integer getNumeroVoie() {
        return numeroVoie;
    }

    public void setNumeroVoie(Integer numeroVoie) {
        this.numeroVoie = numeroVoie;
    }

    public String getNomVoie() {
        return nomVoie;
    }

    public void setNomVoie(String nomVoie) {
        this.nomVoie = nomVoie;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public Integer getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(Integer codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }
}