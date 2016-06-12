package com.homenmove.api.wshnm.services;

import com.example.hm.homenmove.modeles.Reservation;
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
public interface ReservationsServices {

    @GET("reservations")
    Call<List<Reservation>> getLesReservations();

    @GET("reservations")
    Call<Reservation> getReservation(@Query("id") int idReservation);

    @PUT("reservations")
    Call<Reservation> updateReservation(@Query("id") int idReservation, Reservation ReservationModif);

    @POST("reservations")
    Call<Reservation> AjouterReservation(Reservation ReservationAAjouter);

    @DELETE("reservations")
    Call<Reservation> SupprimerReservation(@Query("id") int idReservation);
}
