package com.example.EnergizeMe.myfirstapp.ui.main;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myfirstapp.R;

public class MeinTag extends AppCompatActivity {

    private TextView pointsTextView;
    private TextView proteinTextView;
    private TextView carbohydratesTextView;
    private TextView fatTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Text "Mein Tag"
        TextView titleTextView = findViewById(R.id.title);

        //Button für "MeinProfil" oben rechts (die Avocado)
        ImageView profileImageView = findViewById(R.id.profile);

        //Mahlzeiten Button (de obere) -> klickst drauf und es sollen die heute dafür getrackten Punkte erscheinen
        Button mealsButton = findViewById(R.id.buttonMeals);

        //Aktivität Button (der obere) -> klickst drauf und es sollen die heute getrackten Punke dafür erscheinen
        Button activitiesButton = findViewById(R.id.buttonActivities);

        //
        TextView pointsPerDayTextView = findViewById(R.id.pointsPerDayTextView);
        ProgressBar pointsPerDayProgressBar = findViewById(R.id.pointsPerDayProgressBar);
        TextView remainingPointsTextView = findViewById(R.id.remainingPointsTextView);
        ProgressBar remainingPointsProgressBar = findViewById(R.id.remainingPointsProgressBar);
        TextView consumedPointsTextView = findViewById(R.id.consumedPointsTextView);
        ProgressBar consumedPointsProgressBar = findViewById(R.id.consumedPointsProgressBar);
        ImageView lebensmittelImageView = findViewById(R.id.lebensmittel);
        ImageView aktivitatImageView = findViewById(R.id.aktivitat);

        // Setze die Click Listener für die Buttons
        mealsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Logik für den Klick auf den "Mahlzeiten"-Button hier einfügen
            }
        });

        activitiesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Logik für den Klick auf den "Aktivitäten"-Button hier einfügen
            }
        });

        // Weitere Initialisierungen und Anpassungen können hier durchgeführt werden
        // ...

    }
}
