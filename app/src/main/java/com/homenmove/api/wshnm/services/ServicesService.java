package com.homenmove.api.wshnm.services;

import com.example.hm.homenmove.modeles.Service;

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
public interface ServicesService {

    @GET("services")
    Call<List<Service>> getLesServices();

    @GET("services")
    Call<Service> getService(@Query("id") int idService);

    @PUT("services")
    Call<Service> updateService(@Query("id") int idService, Service ServiceModif);

    @POST("services")
    Call<Service> AjouterService(Service ServiceAAjouter);

    @DELETE("services")
    Call<Service> SupprimerService(@Query("id") int idService);
}
