package com.example.hm.homenmove;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hm.homenmove.modeles.Chambre;
import com.example.hm.homenmove.modeles.Utilisateur;
import com.homenmove.api.wshnm.HomeNMoveClient;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private int idUtilisateur;
    private String pseudo;
    private String motDePasse;
    private String nom;
    private String prenom;
    private String mail;
    private String adresse;
    private Date dateNaissance;
    private TextView _textView;
    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        idUtilisateur = 0;

        _textView = (TextView) findViewById(R.id.txtMessage);
        _textView.setVisibility(View.VISIBLE);

        _textView = (TextView)findViewById(R.id.txtNom);
        _textView.setVisibility(View.INVISIBLE);

        _textView = (TextView)findViewById(R.id.txtPrenom);
        _textView.setVisibility(View.INVISIBLE);

        _textView = (TextView)findViewById(R.id.txtAdresse);
        _textView.setVisibility(View.INVISIBLE);

        _textView = (TextView)findViewById(R.id.txtDateNaissance);
        _textView.setVisibility(View.INVISIBLE);

        Button btnCreateAccount = (Button)findViewById(R.id.btnCreateAccount);
        btnCreateAccount.setVisibility(View.INVISIBLE);
    }

    public void clicLogin(View view) {

        _textView = (TextView) findViewById(R.id.txtPseudo);
        pseudo = _textView.getText().toString();
        _textView = (TextView) findViewById(R.id.txtMdp);
        motDePasse = _textView.getText().toString();

        Call<List<Utilisateur>> callUtilisateurs = HomeNMoveClient.getUtilisateursSvc().getLesUtilisateurs();
        callUtilisateurs.enqueue(new Callback<List<Utilisateur>>() {

            @Override
            public void onResponse(Call<List<Utilisateur>> call, Response<List<Utilisateur>> response) {
                if (response.isSuccessful()) {
                    List<Utilisateur> _lesUtilisateurs = response.body();
                    for (Utilisateur unUtilisateur : _lesUtilisateurs) {
                        if (unUtilisateur.getPseudo().equals(pseudo)) {
                            if (unUtilisateur.getAdresseMail().equals(motDePasse)) {
                                idUtilisateur = unUtilisateur.getIdUtilisateur();
                            }
                            else {
                                message = "Mot de passe incorrect";
                            }
                        }
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(), String.format("%s: %s", response.code(), response.message()), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<Utilisateur>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        if(idUtilisateur != 0) {
            Intent accountIntent = new Intent(this, AccountActivity.class);
            accountIntent.putExtra("pIdUser", idUtilisateur);
            startActivity(accountIntent);
        }
        else {
            if (message != "Mot de passe incorrect") {
                message = "Renseigner les données pour créer un compte";
                afficherChamps();
            }
            TextView txtView = (TextView) findViewById(R.id.txtMessage);
            txtView.setText(message);
            txtView.setVisibility(View.VISIBLE);
        }
    }

    public void afficherChamps() {

        Button signInButton = (Button)findViewById(R.id.loginButton);
        signInButton.setVisibility(View.INVISIBLE);

//        Button AfficheChampsButton = (Button)findViewById(R.id.afficherChamps);
//        AfficheChampsButton.setVisibility(View.INVISIBLE);

        _textView = (TextView)findViewById(R.id.txtNom);
        _textView.setVisibility(View.VISIBLE);

        _textView = (TextView)findViewById(R.id.txtPrenom);
        _textView.setVisibility(View.VISIBLE);

        _textView = (TextView)findViewById(R.id.txtAdresse);
        _textView.setVisibility(View.VISIBLE);

        _textView = (TextView)findViewById(R.id.txtDateNaissance);
        _textView.setVisibility(View.VISIBLE);

        Button btnCreateAccount = (Button)findViewById(R.id.btnCreateAccount);
        btnCreateAccount.setVisibility(View.VISIBLE);
    }

    public void clicAfficherChamps(View view) {
        afficherChamps();
    }

    public void clicCreerCompte(View view){

    }
}
