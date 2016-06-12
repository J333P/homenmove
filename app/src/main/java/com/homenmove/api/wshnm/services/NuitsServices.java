package com.homenmove.api.wshnm.services;

import com.example.hm.homenmove.modeles.Nuit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

/**
 * Created by Khaderik on 12/06/2016.
 */
public interface NuitsServices {

    @GET("nuits")
    Call<List<Nuit>> getLesNuits();

    @GET("nuits")
    Call<Nuit> getNuit(@Query("id") int idNuit);

    @PUT("nuits")
    Call<Nuit> updateNuit(@Query("id") int idNuit, Nuit nuitModif);

    @POST("nuits")
    Call<Nuit> AjouterNuit(Nuit nuitAAjouter);

    @DELETE("nuits")
    Call<Nuit> SupprimerNuit(@Query("id") int idNuit);

}
