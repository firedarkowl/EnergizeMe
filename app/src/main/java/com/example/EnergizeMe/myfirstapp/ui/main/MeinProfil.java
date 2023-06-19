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
import com.example.myfirstapp.R;
import com.example.myfirstapp.databinding.ActivityMeinProfilBinding;
import com.google.android.material.snackbar.Snackbar;

import java.time.LocalDate;

public class MeinProfil extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMeinProfilBinding binding;
    private Benutzer benutzer;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMeinProfilBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        // Example instance of Benutzer class
         benutzer = new Benutzer("John Doe", Gender.MALE,
                180, 75.0,33, Ernaehrungsziel.ABNEHMEN, Aktivitaetslevel.MODERAT);

        // Display user information in the fields
        displayUserInfo();
        handleUserProfileInput();


        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
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
        TextView nameTextView = findViewById(R.id.name);
        TextView birthdayTextView = findViewById(R.id.birthday);
        TextView weightTextView = findViewById(R.id.weight_info);
        TextView heightTextView = findViewById(R.id.height_info);
        TextView genderTextView = findViewById(R.id.gender_info);
        TextView activityTextView = findViewById(R.id.activity_info);

        nameTextView.setText(benutzer.getName());
        //birthdayTextView.setText(benutzer.getBirthdate());
        weightTextView.setText(String.valueOf(benutzer.getWeight()));
        heightTextView.setText(String.valueOf(benutzer.getHeight()));
        genderTextView.setText(benutzer.getGender().toString());
        activityTextView.setText(benutzer.getAktivitaetslevel().toString());
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    private void handleUserProfileInput() {

        TextView birthdayTextView = findViewById(R.id.birthday); // Assuming this is not editable
        Button weightButton = findViewById(R.id.weight_change);
        Button heightButton = findViewById(R.id.height_change);
        Button genderButton = findViewById(R.id.gender_change);
        Button activityButton = findViewById(R.id.activity_change);

        // Get the updated user input values

        int age = Integer.parseInt(birthdayTextView.getText().toString()); // Assuming this is not editable
        int weight = Integer.parseInt(weightButton.getText().toString());
        int height = Integer.parseInt(heightButton.getText().toString());
        String genderText = genderButton.getText().toString();
        Gender gender = Gender.valueOf(genderText);

        String activityLevelText = activityButton.getText().toString();
        Aktivitaetslevel activityLevel = Aktivitaetslevel.valueOf(activityLevelText);


        // Update the user profile with the new values
        benutzer.setAge(age);
         benutzer.setWeight(weight);
        benutzer.setHeight(height);
         benutzer.setGender(gender);
        benutzer.setAktivitaetslevel(activityLevel);

        // You can perform the necessary update operations based on your application's requirements
    }

    @Override
    public boolean onSupportNavigateUp() {
    NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
    return NavigationUI.navigateUp(navController, appBarConfiguration)
            || super.onSupportNavigateUp();
    }
}