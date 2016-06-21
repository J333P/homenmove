package com.homenmove.api.wshnm;


import android.support.annotation.NonNull;

import com.homenmove.api.wshnm.services.ChambresService;
import com.homenmove.api.wshnm.services.NuitsServices;
import com.homenmove.api.wshnm.services.ReservationsServices;
import com.homenmove.api.wshnm.services.ServicesService;
import com.homenmove.api.wshnm.services.UtilisateursService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Khaderik on 31/05/2016.
 */
public class HomeNMoveClient {

    private static final String BASE_URL = "http://homenmove.api.montpellier.epsi.fr/api/";
//    private static final String BASE_URL = "http://192.168.1.13:5110/api/";

    private static UtilisateursService UtilisateursSvc;
    private static NuitsServices NuitsSvc;
    private static ServicesService ServicesSvc;
    private static ChambresService ChambresSvc;
    private static ReservationsServices ReservationsSvc;

    public static UtilisateursService getUtilisateursSvc() {
        if (UtilisateursSvc == null) {

            Retrofit retro = getRetrofit();
            UtilisateursSvc = retro.create(UtilisateursService.class);
        }
        return UtilisateursSvc;
    }

    public static NuitsServices getNuitsSvc() {
        if (NuitsSvc == null) {

            Retrofit retro = getRetrofit();
            NuitsSvc = retro.create(NuitsServices.class);
        }
        return NuitsSvc;
    }

    public static ServicesService getServicesSvc() {
        if (ServicesSvc == null) {

            Retrofit retro = getRetrofit();
            ServicesSvc = retro.create(ServicesService.class);
        }
        return ServicesSvc;
    }

    public static ChambresService getChambresSvc() {
        if (ChambresSvc == null) {

            Retrofit retro = getRetrofit();
            ChambresSvc = retro.create(ChambresService.class);
        }
        return ChambresSvc;
    }
    public static ReservationsServices getReservationsSvc() {
        if (ReservationsSvc == null) {

            Retrofit retro = getRetrofit();
            ReservationsSvc = retro.create(ReservationsServices.class);
        }
        return ReservationsSvc;
    }


    @NonNull
    private static Retrofit getRetrofit() {
        return new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
    }
}

