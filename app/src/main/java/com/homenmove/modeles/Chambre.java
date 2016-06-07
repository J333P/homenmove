package com.homenmove.modeles;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Khaderik on 31/05/2016.
 */
public class Chambre {

    @SerializedName("Adresse")
    private Adresse adresse;
    @SerializedName("ServiceProposes")
    private List<ServicePropose> serviceProposes = new ArrayList<ServicePropose>();
    @SerializedName("Utilisateur")
    private Utilisateur utilisateur;
    @SerializedName("IdChambre")
    private Integer idChambre;
    @SerializedName("LibelleChambre")
    private String libelleChambre;
    @SerializedName("DescriptionChambre")
    private String descriptionChambre;
    @SerializedName("Photo")
    private String photo;
    /**
     *
     * @return
     * The adresse
     */
    public Adresse getAdresse() {
        return adresse;
    }

    /**
     *
     * @param adresse
     * The Adresse
     */
    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    /**
     *
     * @return
     * The serviceProposes
     */
    public List<ServicePropose> getServiceProposes() {
        return serviceProposes;
    }

    /**
     *
     * @param serviceProposes
     * The ServiceProposes
     */
    public void setServiceProposes(List<ServicePropose> serviceProposes) {
        this.serviceProposes = serviceProposes;
    }

    /**
     *
     * @return
     * The utilisateur
     */
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    /**
     *
     * @param utilisateur
     * The Utilisateur
     */
    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    /**
     *
     * @return
     * The idChambre
     */
    public Integer getIdChambre() {
        return idChambre;
    }

    /**
     *
     * @param idChambre
     * The IdChambre
     */
    public void setIdChambre(Integer idChambre) {
        this.idChambre = idChambre;
    }

    /**
     *
     * @return
     * The libelleChambre
     */
    public String getLibelleChambre() {
        return libelleChambre;
    }

    /**
     *
     * @param libelleChambre
     * The LibelleChambre
     */
    public void setLibelleChambre(String libelleChambre) {
        this.libelleChambre = libelleChambre;
    }

    /**
     *
     * @return
     * The descriptionChambre
     */
    public String getDescriptionChambre() {
        return descriptionChambre;
    }

    /**
     *
     * @param descriptionChambre
     * The DescriptionChambre
     */
    public void setDescriptionChambre(String descriptionChambre) {
        this.descriptionChambre = descriptionChambre;
    }

    /**
     *
     * @return
     * The photo
     */
    public String getPhoto() {
        return photo;
    }

    /**
     *
     * @param photo
     * The Photo
     */
    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
