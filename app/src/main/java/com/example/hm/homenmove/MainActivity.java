package com.example.hm.homenmove;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.hm.homenmove.business.ChambresBusiness.adapterRcvChambres;
import com.example.hm.homenmove.modeles.Chambre;
import com.homenmove.api.wshnm.HomeNMoveClient;

import java.util.List;
import java.util.StringTokenizer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView RcvChambres;

    private List<Chambre> _lesChambres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RcvChambres = (RecyclerView) findViewById(R.id.recycleViewChambre);
        RcvChambres.setLayoutManager(new LinearLayoutManager(this));

        ChargeLesChambres();
    }

    private void ChargeLesChambres() {

        final LinearLayout mainLayout = (LinearLayout) findViewById(R.id.MainLayout);

        Call<List<Chambre>> callChambres = HomeNMoveClient.getChambresSvc().getLesChambres();

        callChambres.enqueue(new Callback<List<Chambre>>() {
            @Override
            public void onResponse(Call<List<Chambre>> call, Response<List<Chambre>> response) {
                if (response.isSuccessful()) {
                    _lesChambres = response.body();

                    RcvChambres.setAdapter(new adapterRcvChambres(_lesChambres));

                } else {
                    // TODO: 16/06/2016 Pensez à gérer les erreurs
                    Snackbar.make(mainLayout, String.format("%s: %s", response.code(), response.message()), Snackbar.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<Chambre>> call, Throwable t) {
                // TODO: 16/06/2016 Pensez à gérer les erreurs
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG).show();
                //Snackbar.make(mainLayout, t.getMessage(), Snackbar.LENGTH_LONG).show();
            }
        });
    }
}
