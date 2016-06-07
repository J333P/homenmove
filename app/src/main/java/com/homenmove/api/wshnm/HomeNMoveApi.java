package com.homenmove.api.wshnm;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Khaderik on 31/05/2016.
 */
public class HomeNMoveApi {

    private static final String BASE_URL = "http://homenmove.api.montpellier.epsi.fr/api/";
    //private static final String BASE_URL = "http://localhost:5110/api/";
    private static HnMService monServiceHnM;

    public static HnMService getApi() {
        if (monServiceHnM == null) {

            Retrofit retro = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            monServiceHnM = retro.create(HnMService.class);
        }
        return monServiceHnM;
    }
}
