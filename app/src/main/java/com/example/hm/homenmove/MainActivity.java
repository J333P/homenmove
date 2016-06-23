package com.example.hm.homenmove;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hm.homenmove.business.ChambresBusiness.adapterRcvChambres;
import com.example.hm.homenmove.modeles.Chambre;
import com.example.hm.homenmove.modeles.Utilisateur;
import com.homenmove.api.wshnm.HomeNMoveClient;

import java.util.List;
import java.util.StringTokenizer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.support.v4.app.ActivityCompat.startActivity;

public class MainActivity extends AppCompatActivity {

    private RecyclerView RcvChambres;
    private adapterRcvChambres chambresAdapter;
    private SwipeRefreshLayout maSwipeContainer;
    private List<Chambre> _lesChambres;
    private int idUser; //TODO charger la valeur apres login

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        maSwipeContainer = (SwipeRefreshLayout) findViewById(R.id.swipeContainer);
        RcvChambres = (RecyclerView) findViewById(R.id.recycleViewChambre);

        RcvChambres.setLayoutManager(new LinearLayoutManager(this));

        ChargeLesChambres();


        maSwipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                ChargeLesChambres();

                maSwipeContainer.setRefreshing(false);
            }
        });
    }


    private void ChargeLesChambres() {
        Call<List<Chambre>> callChambres = HomeNMoveClient.getChambresSvc().getLesChambres();
        callChambres.enqueue(new Callback<List<Chambre>>() {
            @Override
            public void onResponse(Call<List<Chambre>> call, Response<List<Chambre>> response) {
                if (response.isSuccessful()) {
                    _lesChambres = response.body();

                    chambresAdapter = new adapterRcvChambres(_lesChambres);
                    RcvChambres.setAdapter(chambresAdapter);
                    chambresAdapter.notifyDataSetChanged();

                } else {

                    Toast.makeText(getApplicationContext(), String.format("%s: %s", response.code(), response.message()), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<Chambre>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                chambresAdapter = null;
            }
        });
    }

    public void clicOuvrirAccount(View view) {
        if (idUser == 0) {
            Intent loginIntent = new Intent(this, LoginActivity.class);
            startActivity(loginIntent);
        } else {
            Intent accountIntent = new Intent(this, AccountActivity.class);
            accountIntent.putExtra("pIdUser", idUser);
            startActivity(accountIntent);
        }
    }
}
