package com.example.hm.homenmove.modeles;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Khaderik on 31/05/2016.
 */
public class Reservation {

    @SerializedName("Nuits")
    private List<Nuit> nuits = new ArrayList<Nuit>();
    @SerializedName("Utilisateur")
    private Utilisateur utilisateur;
    @SerializedName("IdReservation")
    private Integer idReservation;
    @SerializedName("DateReservation")
    private String dateReservation;

    /**
     *
     * @return
     * The nuits
     */
    public List<Nuit> getNuits() {
        return nuits;
    }

    /**
     *
     * @param nuits
     * The Nuits
     */
    public void setNuits(List<Nuit> nuits) {
        this.nuits = nuits;
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
     * The idReservation
     */
    public Integer getIdReservation() {
        return idReservation;
    }

    /**
     *
     * @param idReservation
     * The IdReservation
     */
    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    /**
     *
     * @return
     * The dateReservation
     */
    public String getDateReservation() {
        return dateReservation;
    }

    /**
     *
     * @param dateReservation
     * The DateReservation
     */
    public void setDateReservation(String dateReservation) {
        this.dateReservation = dateReservation;
    }
}
