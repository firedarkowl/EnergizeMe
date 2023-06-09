package com.example.EnergizeMe.myfirstapp.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.EnergizeMe.myfirstapp.ui.main.Tracked.Activity_Tracked;
import com.example.EnergizeMe.myfirstapp.ui.main.Tracked.Lebensmittel_Tracked;
import com.example.EnergizeMe.myfirstapp.ui.main.Tracking.Tracking;
import com.example.EnergizeMe.myfirstapp.ui.main.Tracking.Tracking_Lebensmittel;
import com.example.myfirstapp.R;
import com.example.myfirstapp.databinding.ActivityMainBinding;

public class MeinTag extends AppCompatActivity {

    private TextView pointsTextView;
    private TextView proteinTextView;
    private TextView carbohydratesTextView;
    private TextView fatTextView;
    private ActivityMainBinding binding;
    private AppBarConfiguration appBarConfiguration;

    private  ProgressBar consumedPointsProgressBar;

    private ProgressBar remainingPointsProgressBar;

    public static int punkte = 0;
    public static int protein = 0;
    public static int kohlenhydrate = 0;
    public static int fett = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
 //       setContentView(binding.getRoot());
        setContentView(R.layout.activity_mein_tag);

        pointsTextView = findViewById(R.id.points);
        proteinTextView = findViewById(R.id.protein);
        carbohydratesTextView = findViewById(R.id.kohlenhydrate);
        fatTextView = findViewById(R.id.fett);


        //Button für "MeinProfil" oben rechts (die Avocado) - soll noch als Button betrachtet werden, s Link unten
        ImageView profileImageView = findViewById(R.id.profile);

        //Mahlzeiten Button (de obere) -> klickst drauf und es sollen die heute dafür getrackten Punkte erscheinen
        Button mealsButton = (Button) findViewById(R.id.buttonMeals);

        //Aktivität Button (der obere) -> klickst drauf und es sollen die heute getrackten Punke dafür erscheinen
        Button activitiesButton = (Button) findViewById(R.id.buttonActivities);

        //die Progressbar für die Punkte pro Tag
        ProgressBar pointsPerDayProgressBar = findViewById(R.id.pointsPerDayProgressBar);

        //die Progressbar für die Punkte die noch übrig bleiben für den Tag
        remainingPointsProgressBar = findViewById(R.id.remainingPointsProgressBar);

        //die Progressbar zu den verbrauchten Punkten
        consumedPointsProgressBar = findViewById(R.id.consumedPointsProgressBar);

        //"Buttons" zum Tacken von jeweils Lebensmittel/Mahzeit und aktivität
        ImageView lebensmittelImageView = findViewById(R.id.lebensmittel_tracking);
        ImageView aktivitatImageView = findViewById(R.id.aktivitaet_tracking);




        mealsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Logik für den Klick auf den "Mahlzeiten"-Button (für den oberen Button)
                Intent i = new Intent(MeinTag.this, Lebensmittel_Tracked.class);
                startActivity(i);
            }
        });

        activitiesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Logik für den Klick auf den "Aktivitäten"-Button (für den oberen Button)
                Intent activitiesIntent = new Intent(MeinTag.this, Activity_Tracked.class);
                startActivity(activitiesIntent);
            }
        });

        profileImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Logik für den Klick auf den "Mahlzeiten"-Button (für den oberen Button)
                Intent i = new Intent(MeinTag.this, MeinProfil.class);
                startActivity(i);
            }
        });

        lebensmittelImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Logik für den Klick auf den "Mahlzeiten"-Button (für den oberen Button)
                Intent i = new Intent(MeinTag.this, Tracking_Lebensmittel.class);
                startActivity(i);
            }
        });

        aktivitatImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Logik für den Klick auf den "Mahlzeiten"-Button (für den oberen Button)
                Intent i = new Intent(MeinTag.this, Tracking.class);
                startActivity(i);
            }
        });



        //für ImageView als Button behandeln: https://www.geeksforgeeks.org/how-to-use-imageview-as-a-button-in-android/
    }


    public void setPointsTextView(TextView textView) {
        this.pointsTextView = textView;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public void onResume(){
        super.onResume();
        pointsTextView.setText(punkte+"");
        proteinTextView.setText(protein+"");
        carbohydratesTextView.setText(kohlenhydrate+"");
        fatTextView.setText(fett+"");
        consumedPointsProgressBar.setMax(100);
        remainingPointsProgressBar.setMax(100);
        consumedPointsProgressBar.setProgress(punkte);
        remainingPointsProgressBar.setProgress(100 - punkte);

    }
}
