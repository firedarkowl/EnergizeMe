package com.example.EnergizeMe.myfirstapp.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.EnergizeMe.myfirstapp.Datenbank.DataBaseHelperBenutzer;
import com.example.EnergizeMe.myfirstapp.Datenbank.DataBaseMeinProfil;
import com.example.myfirstapp.R;
import com.example.myfirstapp.databinding.ActivityMainBinding;

import java.util.HashMap;

public class MeinProfil extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private @NonNull ActivityMainBinding binding;
    private DataBaseMeinProfil profilDB;
    private EditText geburtsdatum;
    private EditText geschlecht;
    private EditText groesse;
    private EditText gewicht;
    private EditText ziel;
    private EditText taetigkeitslevel;
    private ImageView back;
    private TextView vorname_view, nachname_view, alter_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_mein_profil);

        profilDB = new DataBaseMeinProfil(this);
        vorname_view = findViewById(R.id.vorname);
        nachname_view = findViewById(R.id.nachname);
        alter_view = findViewById(R.id.alter);

        DataBaseHelperBenutzer dbhb = new DataBaseHelperBenutzer(this);
        HashMap<String, String> userData = dbhb.getUserData();

        vorname_view.setText(userData.get("vorname"));
        nachname_view.setText(userData.get("nachname"));
        alter_view.setText("Alter: "+ String.valueOf(userData.get("alter")));


        geschlecht = (EditText) findViewById(R.id.gender_info);
        groesse = (EditText) findViewById(R.id.height_info);
        gewicht = (EditText) findViewById(R.id.weight_info);
        ziel = (EditText) findViewById(R.id.weight_info);
        taetigkeitslevel = (EditText) findViewById(R.id.activity_info);

        back = findViewById(R.id.back);
        Spinner spinner = findViewById(R.id.spinner);
        //tring selectedValue = spinner.getSelectedItem().toString();


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Logik für den Klick auf den "Mahlzeiten"-Button (für den oberen Button)
                Intent i = new Intent(MeinProfil.this, MeinTag.class);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }


}