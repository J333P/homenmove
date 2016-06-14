package com.example.hm.homenmove;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.example.hm.homenmove.modeles.Chambre;
import com.homenmove.api.wshnm.HomeNMoveClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView monRecyclerView;
    private RecyclerView.Adapter monAdapter;
    private RecyclerView.LayoutManager monLayoutManager;


    private Call<List<Chambre>> monCallListeDesChambres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        monRecyclerView = (RecyclerView) findViewById(R.id.recycleViewChambre);

        monCallListeDesChambres = HomeNMoveClient.getChambresSvc().getLesChambres();

        monCallListeDesChambres.enqueue(new Callback<List<Chambre>>() {
            @Override
            public void onResponse(Call<List<Chambre>> call, Response<List<Chambre>> response) {
                int statusCode = response.code();
                List<Chambre> mesChambres  = response.body();
            }

            @Override
            public void onFailure(Call<List<Chambre>> call, Throwable t) {
                // Log error here since request failed

            }
        });

//            monLayoutManager=new
//
//            LinearLayoutManager(this);
//
//            monRecyclerView.setLayoutManager(monLayoutManager);
//
//            String[] monDataSet = {"1", "2", "3", "4"};
//            monAdapter=new
//
//            AdapterMain(getBaseContext(),monDataSet
//
//            );
//            monRecyclerView.setAdapter(monAdapter);
        }
    }
