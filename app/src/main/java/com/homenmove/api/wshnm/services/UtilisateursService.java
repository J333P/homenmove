package com.homenmove.api.wshnm.services;

import com.example.hm.homenmove.modeles.Utilisateur;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

/**
 * Created by Khaderik on 12/06/2016.
 */
public interface UtilisateursService {

    @GET("utilisateurs")
    Call<List<Utilisateur>> getLesUtilisateurs();

    @GET("utilisateurs")
    Call<Utilisateur> getUtilisateur(@Query("id") int idUser);

    @PUT("utilisateurs")
    Call<Utilisateur> updateUtilisateur(@Query("id") int idUser, Utilisateur userModif);

    @POST ("utilisateurs")
    Call<Utilisateur> AjouterUtilisateur(@Body Utilisateur userAAjouter);

    @DELETE("utilisateurs")
    Call<Utilisateur> SupprimerUtilisateur(@Query("id") int idUser);

}
