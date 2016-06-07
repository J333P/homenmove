package com.homenmove.modeles;

/**
 * Created by Khaderik on 31/05/2016.
 */
import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

public class Service {

    @SerializedName("IdService")
    private Integer idService;
    @SerializedName("LibelleService")
    private String libelleService;
    @SerializedName("DescriptionService")
    private String descriptionService;

    /**
     *
     * @return
     * The idService
     */
    public Integer getIdService() {
        return idService;
    }

    /**
     *
     * @param idService
     * The IdService
     */
    public void setIdService(Integer idService) {
        this.idService = idService;
    }

    /**
     *
     * @return
     * The libelleService
     */
    public String getLibelleService() {
        return libelleService;
    }

    /**
     *
     * @param libelleService
     * The LibelleService
     */
    public void setLibelleService(String libelleService) {
        this.libelleService = libelleService;
    }

    /**
     *
     * @return
     * The descriptionService
     */
    public String getDescriptionService() {
        return descriptionService;
    }

    /**
     *
     * @param descriptionService
     * The DescriptionService
     */
    public void setDescriptionService(String descriptionService) {
        this.descriptionService = descriptionService;
    }
}
