package com.homenmove.modeles;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Khaderik on 31/05/2016.
 */
public class Nuit {

    @SerializedName("Chambre")
    private Chambre chambre;
    @SerializedName("ServiceChoisis")
    private List<ServicePropose> serviceChoisis = new ArrayList<ServicePropose>();
    @SerializedName("IdNuit")
    private Integer idNuit;
    @SerializedName("DateNuit")
    private String dateNuit;
    @SerializedName("DispoVisite")
    private String dispoVisite;

    /**
     *
     * @return
     * The chambre
     */
    public Chambre getChambre() {
        return chambre;
    }

    /**
     *
     * @param chambre
     * The Chambre
     */
    public void setChambre(Chambre chambre) {
        this.chambre = chambre;
    }

    /**
     *
     * @return
     * The serviceChoisis
     */
    public List<ServicePropose> getServiceChoisis() {
        return serviceChoisis;
    }

    /**
     *
     * @param serviceChoisis
     * The ServiceChoisis
     */
    public void setServiceChoisis(List<ServicePropose> serviceChoisis) {
        this.serviceChoisis = serviceChoisis;
    }

    /**
     *
     * @return
     * The idNuit
     */
    public Integer getIdNuit() {
        return idNuit;
    }

    /**
     *
     * @param idNuit
     * The IdNuit
     */
    public void setIdNuit(Integer idNuit) {
        this.idNuit = idNuit;
    }

    /**
     *
     * @return
     * The dateNuit
     */
    public String getDateNuit() {
        return dateNuit;
    }

    /**
     *
     * @param dateNuit
     * The DateNuit
     */
    public void setDateNuit(String dateNuit) {
        this.dateNuit = dateNuit;
    }

    /**
     *
     * @return
     * The dispoVisite
     */
    public String getDispoVisite() {
        return dispoVisite;
    }

    /**
     *
     * @param dispoVisite
     * The DispoVisite
     */
    public void setDispoVisite(String dispoVisite) {
        this.dispoVisite = dispoVisite;
    }
}
