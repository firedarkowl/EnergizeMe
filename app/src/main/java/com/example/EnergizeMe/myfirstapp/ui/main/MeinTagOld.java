package com.example.EnergizeMe.myfirstapp.ui.main;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
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
import com.google.android.material.snackbar.Snackbar;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class MeinTag extends AppCompatActivity {

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
// Example instance of Benutzer class
        benutzer = new Benutzer("John Doe", Gender.MALE,
                180, 75.0,33, Ernaehrungsziel.ABNEHMEN, Aktivitaetslevel.MODERAT);
        Map<String, Double> naehrwerte = new HashMap<>();
        naehrwerte.put("Kalorien", 100.0);
        naehrwerte.put("Fett", 10.0);
        naehrwerte.put("Ballaststoffe", 5.0);
        lebensmittel = new LebensMittel("Test Lebensmittel", naehrwerte, benutzer);

        // Display user information in the fields
        displayUserInfo();
        handleUserProfileInput();
        // setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_mein_tag);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAnchorView(R.id.fab)
                        .setAction("Action", null).show();
            }
        });
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    private void displayUserInfo() {
        TextView kalorienTextView = findViewById(R.id.name);
        TextView wochentlichPunktstandTextView = findViewById(R.id.birthday);
        TextView basePointsTextView = findViewById(R.id.weight_info);
        TextView PunktstandtagTextView = findViewById(R.id.height_info);


        kalorienTextView.setText((int) lebensmittel.getKalorien());
        //birthdayTextView.setText(benutzer.getBirthdate());
        wochentlichPunktstandTextView.setText(String.valueOf(benutzer.berechneWochepunktstand()));
        basePointsTextView.setText(String.valueOf(benutzer.getPunktZahl()));
        PunktstandtagTextView.setText((int) benutzer.getPunktstandtag());

    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    private void handleUserProfileInput() {

        // TextView birthdayTextView = findViewById(R.id.birthday); // Assuming this is not editable
        Button portiongrosseButton = findViewById(R.id.weight_change);


        // Get the updated user input values

        // String birthdate = birthdayTextView.getText().toString(); // Assuming this is not editable
        int portiongrosse = Integer.parseInt(portiongrosseButton.getText().toString());



        // Update the user profile with the new values
        // benutzer.setName(name);
        lebensmittel.lebPunkteRechnung(portiongrosse);
        // You can perform the necessary update operations based on your application's requirements
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_mein_tag);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}