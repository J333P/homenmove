package com.homenmove.modeles;

/**
 * Created by Khaderik on 31/05/2016.
 */
import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

public class ServicePropose {

    @SerializedName("Service")
    private Service service;
    @SerializedName("IdServicePropose")
    private Integer idServicePropose;
    @SerializedName("Tarif")
    private Double tarif;

    /**
     *
     * @return
     * The service
     */
    public Service getService() {
        return service;
    }

    /**
     *
     * @param service
     * The Service
     */
    public void setService(Service service) {
        this.service = service;
    }

    /**
     *
     * @return
     * The idServicePropose
     */
    public Integer getIdServicePropose() {
        return idServicePropose;
    }

    /**
     *
     * @param idServicePropose
     * The IdServicePropose
     */
    public void setIdServicePropose(Integer idServicePropose) {
        this.idServicePropose = idServicePropose;
    }

    /**
     *
     * @return
     * The tarif
     */
    public Double getTarif() {
        return tarif;
    }

    /**
     *
     * @param tarif
     * The Tarif
     */
    public void setTarif(Double tarif) {
        this.tarif = tarif;
    }

}