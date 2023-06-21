package com.example.EnergizeMe.myfirstapp.ui.main;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.EnergizeMe.myfirstapp.Datenbank.DataBaseMeinProfil;
import com.example.myfirstapp.R;
import com.example.myfirstapp.databinding.ActivityMeinProfilBinding;

public class MeinProfil extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMeinProfilBinding binding;
    private DataBaseMeinProfil profilDB;
    private EditText geburtsdatum;
    private EditText geschlecht;
    private EditText groesse;
    private EditText gewicht;
    private EditText ziel;
    private EditText taetigkeitslevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMeinProfilBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        profilDB = new DataBaseMeinProfil(this);

        geschlecht = (EditText)findViewById(R.id.gender_info);
        groesse = (EditText)findViewById(R.id.height_info);
        gewicht = (EditText)findViewById(R.id.weight_info);
        ziel = (EditText)findViewById(R.id.weight_info);
        taetigkeitslevel = (EditText)findViewById(R.id.activity_info);

        Spinner spinner = findViewById(R.id.spinner);
        String selectedValue = spinner.getSelectedItem().toString();
        ;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }


}