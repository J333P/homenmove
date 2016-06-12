package com.homenmove.api.wshnm.services;

import com.example.hm.homenmove.modeles.Chambre;

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
public interface ChambresService {


    @GET("chambres")
    Call<List<Chambre>> getLesChambres();

    @GET("chambres")
    Call<Chambre> getChambre(@Query("id") int idChambre);

    @PUT("chambres")
    Call<Chambre> updateChambre(@Query("id") int idChambre, Chambre ChambreModif);

    @POST("chambres")
    Call<Chambre> AjouterChambre(Chambre ChambreAAjouter);

    @DELETE("chambres")
    Call<Chambre> SupprimerChambre(@Query("id") int idChambre);

}
