package com.example.myfirstapp;

import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.EnergizeMe.myfirstapp.Logik.Aktivitaetslevel;
import com.example.EnergizeMe.myfirstapp.Logik.Benutzer;
import com.example.EnergizeMe.myfirstapp.Logik.Ernaehrungsziel;
import com.example.EnergizeMe.myfirstapp.Logik.Gender;
import com.example.EnergizeMe.myfirstapp.Logik.LebensMittel;
import com.example.myfirstapp.R;
import com.example.myfirstapp.databinding.ActivityMeinTagBinding;

import java.util.HashMap;
import java.util.Map;

public class MeinTagOld extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMeinTagBinding binding;
    private Benutzer benutzer;
    private LebensMittel lebensmittel;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMeinTagBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Beispielinstanz der Benutzerklasse
        benutzer = new Benutzer("John Doe", Gender.MALE,
                180, 75.0, 33, Ernaehrungsziel.ABNEHMEN, Aktivitaetslevel.MODERAT);
        Map<String, Double> naehrwerte = new HashMap<>();
        naehrwerte.put("Kalorien", 100.0);
        naehrwerte.put("Fett", 10.0);
        naehrwerte.put("Ballaststoffe", 5.0);
        lebensmittel = new LebensMittel("Test Lebensmittel", naehrwerte, benutzer);

        // Benutzerinformationen in den Feldern anzeigen
        displayUserInfo();
        handleUserProfileInput();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_mein_tag);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        /*binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAnchorView(R.id.fab)
                        .setAction("Action", null).show();
            }
        });*/
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void displayUserInfo() {
        TextView kalorienTextView = findViewById(R.id.name);
        TextView wochentlichPunktstandTextView = findViewById(R.id.birthday);
        TextView basePointsTextView = findViewById(R.id.weight_info);
        TextView PunktstandtagTextView = findViewById(R.id.height_info);

        kalorienTextView.setText(String.valueOf((int) lebensmittel.getKalorien()));
        wochentlichPunktstandTextView.setText(String.valueOf(benutzer.berechneWochepunktstand()));
        basePointsTextView.setText(String.valueOf(benutzer.getPunktZahl()));
        PunktstandtagTextView.setText(String.valueOf((int) benutzer.getPunktstandtag()));
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void handleUserProfileInput() {
        Button portiongrosseButton = findViewById(R.id.weight_change);

        int portiongrosse = Integer.parseInt(portiongrosseButton.getText().toString());

        lebensmittel.lebPunkteRechnung(portiongrosse);
        // Du kannst hier die notwendigen Aktualisierungsoperationen basierend auf den Anforderungen deiner Anwendung durchführen
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_mein_tag);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
