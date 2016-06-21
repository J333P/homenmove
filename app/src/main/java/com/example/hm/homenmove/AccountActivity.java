package com.example.hm.homenmove;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.hm.homenmove.business.ChambresBusiness.adapterRcvReservations;
import com.example.hm.homenmove.modeles.Chambre;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.example.hm.homenmove.modeles.Reservation;
import com.homenmove.api.wshnm.HomeNMoveClient;
import com.example.hm.homenmove.business.ChambresBusiness.adapterRcvChambreAccount;


public class AccountActivity extends AppCompatActivity {

    private String pseudoUtilisateur;
    private RecyclerView RcvChambresAccount;
    private List<Chambre> _lesChambresAccount;
    private RecyclerView RcvReservations;
    private List<Reservation> _lesReservations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        pseudoUtilisateur = getIntent().getStringExtra("pPseudoUser");

        RcvChambresAccount = (RecyclerView) findViewById(R.id.recycleViewChambreAccount);
        RcvChambresAccount.setLayoutManager(new LinearLayoutManager(this));

        RcvReservations = (RecyclerView) findViewById(R.id.recycleViewReservation);
        RcvReservations.setLayoutManager(new LinearLayoutManager(this));

        ChargeLesChambres();
        ChargeLesReservations();
    }

    private void ChargeLesChambres() {

        final LinearLayout accountLayout = (LinearLayout) findViewById(R.id.AccountLayout);

        Call<List<Chambre>> callChambres = HomeNMoveClient.getChambresSvc().getLesChambres();

        callChambres.enqueue(new Callback<List<Chambre>>() {
            @Override
            public void onResponse(Call<List<Chambre>> call, Response<List<Chambre>> response) {
                if (response.isSuccessful()) {
                    _lesChambresAccount = response.body();

                    RcvChambresAccount.setAdapter(new adapterRcvChambreAccount(_lesChambresAccount));

                } else {
                    // TODO: 16/06/2016 Pensez à gérer les erreurs
                    Snackbar.make(accountLayout, String.format("%s: %s", response.code(), response.message()), Snackbar.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<Chambre>> call, Throwable t) {
                // TODO: 16/06/2016 Pensez à gérer les erreurs
                Toast.makeText(getApplicationContext(),t.getMessage(), Toast.LENGTH_LONG).show();
                //Snackbar.make(mainLayout, t.getMessage(), Snackbar.LENGTH_LONG).show();
            }
        });
    }

    private void ChargeLesReservations() {

        final LinearLayout accountLayout = (LinearLayout) findViewById(R.id.AccountLayout);

        Call<List<Reservation>> callReservations = HomeNMoveClient.getReservationsSvc().getLesReservations();

        callReservations.enqueue(new Callback<List<Reservation>>() {
            @Override
            public void onResponse(Call<List<Reservation>> call, Response<List<Reservation>> response) {
                if (response.isSuccessful()) {
                    _lesReservations = response.body();

                    RcvReservations.setAdapter(new adapterRcvReservations(_lesReservations));

                } else {
                    // TODO: 16/06/2016 Pensez à gérer les erreurs
                    Snackbar.make(accountLayout, String.format("%s: %s", response.code(), response.message()), Snackbar.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<Reservation>> call, Throwable t) {
                // TODO: 16/06/2016 Pensez à gérer les erreurs
                Toast.makeText(getApplicationContext(),t.getMessage(), Toast.LENGTH_LONG).show();
                //Snackbar.make(mainLayout, t.getMessage(), Snackbar.LENGTH_LONG).show();
            }
        });
    }
}
