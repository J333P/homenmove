package com.example.hm.homenmove;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.example.hm.homenmove.business.ChambresBusiness.adapterRcvReservations;
import com.example.hm.homenmove.modeles.Adresse;
import com.example.hm.homenmove.modeles.Chambre;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.example.hm.homenmove.modeles.Reservation;
import com.example.hm.homenmove.modeles.Utilisateur;
import com.homenmove.api.wshnm.HomeNMoveClient;
import com.example.hm.homenmove.business.ChambresBusiness.adapterRcvChambreAccount;


public class AccountActivity extends AppCompatActivity {

    private int idUtilisateur;
    private Utilisateur _utilisateur;
    private RecyclerView RcvChambresAccount;
    private List<Chambre> _lesChambresAccount;
    private RecyclerView RcvReservations;
    private List<Reservation> _lesReservations;
    private TextView _textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        idUtilisateur = getIntent().getIntExtra("pIdUser", 0);

        RcvChambresAccount = (RecyclerView) findViewById(R.id.recycleViewChambreAccount);
        RcvChambresAccount.setLayoutManager(new LinearLayoutManager(this));

        RcvReservations = (RecyclerView) findViewById(R.id.recycleViewReservation);
        RcvReservations.setLayoutManager(new LinearLayoutManager(this));

        ChargeDonneesUtilisateur();
        ChargeLesChambres();
        ChargeLesReservations();
    }


    private void ChargeDonneesUtilisateur() {

        Call<Utilisateur> callUtilisateur = HomeNMoveClient.getUtilisateursSvc().getUtilisateur(idUtilisateur);
        callUtilisateur.enqueue(new Callback<Utilisateur>() {
            @Override
            public void onResponse(Call<Utilisateur> call, Response<Utilisateur> response) {
                if (response.isSuccessful()) {
                    _utilisateur = response.body();

                    _textView = (TextView) findViewById(R.id.txtPseudo);
                    _textView.setText(_utilisateur.getPseudo());

                    _textView = (TextView) findViewById(R.id.txtNom);
                    _textView.setText(_utilisateur.getPrenom() + " " + _utilisateur.getNom());

                    Adresse _adresse = _utilisateur.getAdresse();
                    _textView = (TextView) findViewById(R.id.txtAdresse1);
                    if (_adresse.getNumeroVoie() == null) {
                        _textView.setText(_adresse.getNomVoie());
                    }
                    else {
                        _textView.setText(_adresse.getNumeroVoie() + ", " + _adresse.getNomVoie());
                    }
                    _textView = (TextView)findViewById(R.id.txtAdresse2);
                    _textView.setText(_adresse.getCodePostal() + " " + _adresse.getVille());
                }
            }

            @Override
            public void onFailure(Call<Utilisateur> call, Throwable t) {
                // TODO: Pensez à gérer les erreurs
            }
        });
    }


    private void ChargeLesChambres() {

        final LinearLayout accountLayout = (LinearLayout) findViewById(R.id.AccountLayout);

        Call<List<Chambre>> callChambres = HomeNMoveClient.getChambresSvc().getLesChambres();

        callChambres.enqueue(new Callback<List<Chambre>>() {
            @Override
            public void onResponse(Call<List<Chambre>> call, Response<List<Chambre>> response) {
                if (response.isSuccessful()) {
                    _lesChambresAccount = response.body();
                    List<Chambre> _lesChambresTriees = new ArrayList<Chambre>();                            ;

                    for (Chambre uneChambre : _lesChambresAccount) {
                        if (uneChambre.getUtilisateur().getIdUtilisateur().equals(idUtilisateur)) {
                            _lesChambresTriees.add(uneChambre);
                        }
                    }

                    RcvChambresAccount.setAdapter(new adapterRcvChambreAccount(_lesChambresTriees));

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
                    List<Reservation> _lesReservationsTriees = new ArrayList<Reservation>();                            ;

                    for (Reservation uneReservation : _lesReservations) {
                        if (uneReservation.getUtilisateur().getIdUtilisateur() == idUtilisateur) {
                            _lesReservationsTriees.add(uneReservation);
                        }
                    }

                    RcvReservations.setAdapter(new adapterRcvReservations(_lesReservationsTriees));

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

    public void clicCreerChambre(View view) {
            Intent creationChambreIntent = new Intent(this, CreationChambreActivity.class);
            creationChambreIntent.putExtra("pIdUser", idUtilisateur);
            startActivity(creationChambreIntent);
    }
}
