package com.example.hm.homenmove;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.homenmove.api.wshnm.HomeNMoveApi;
import com.homenmove.api.wshnm.services.UtilisateursService;
import com.example.hm.homenmove.modeles.Utilisateur;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView _textView;
    private Call<Utilisateur> callUtilisateur;
    private Utilisateur monUser;
    private UtilisateursService _monUserSvc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _monUserSvc = HomeNMoveApi.getUtilisateursSvc();
        callUtilisateur = _monUserSvc.getUtilisateur(1);

        callUtilisateur.enqueue(new Callback<Utilisateur>() {

            @Override
            public void onResponse(Call<Utilisateur> call, Response<Utilisateur> response) {
                // handle success
                if (response.isSuccessful() &&  response.body().getClass() == Utilisateur.class) {
                    monUser = response.body();
                    _textView.setText("OK");
                }
            }

            @Override
            public void onFailure(Call<Utilisateur> call, Throwable t) {
                // handle failure
                Toast.makeText(getApplicationContext(), String.format("L'appel à l'API a échoué: %s ", t.getMessage()), Toast.LENGTH_SHORT).show();
            }

        });
    }
}
