package com.example.EnergizeMe.myfirstapp.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.EnergizeMe.myfirstapp.ui.main.Tracked.Activity_Tracked;
import com.example.EnergizeMe.myfirstapp.ui.main.Tracked.Lebensmittel_Tracked;
import com.example.myfirstapp.R;
import com.example.myfirstapp.databinding.ActivityMainBinding;

public class MeinTag extends AppCompatActivity {

    private TextView pointsTextView;
    private TextView proteinTextView;
    private TextView carbohydratesTextView;
    private TextView fatTextView;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Text "Mein Tag"
        TextView titleTextView = findViewById(R.id.title);

        //Button für "MeinProfil" oben rechts (die Avocado) - soll noch als Button betrachtet werden, s Link unten
        ImageView profileImageView = findViewById(R.id.profile);

        //Mahlzeiten Button (de obere) -> klickst drauf und es sollen die heute dafür getrackten Punkte erscheinen
        Button mealsButton = findViewById(R.id.buttonMeals);

        //Aktivität Button (der obere) -> klickst drauf und es sollen die heute getrackten Punke dafür erscheinen
        Button activitiesButton = findViewById(R.id.buttonActivities);

        //Punkte pro Tag Text
        TextView pointsPerDayTextView = findViewById(R.id.pointsPerDayTextView);

        //die Progressbar für die Punkte pro Tag
        ProgressBar pointsPerDayProgressBar = findViewById(R.id.pointsPerDayProgressBar);

        //Punkte die noch übrig bleiben
        TextView remainingPointsTextView = findViewById(R.id.remainingPointsTextView);

        //die Progressbar für die Punkte die noch übrig bleiben für den Tag
        ProgressBar remainingPointsProgressBar = findViewById(R.id.remainingPointsProgressBar);

        //Verbrauchte Punkte
        TextView consumedPointsTextView = findViewById(R.id.consumedPointsTextView);

        //die Progressbar zu den verbrauchten Punkten
        ProgressBar consumedPointsProgressBar = findViewById(R.id.consumedPointsProgressBar);

        //"Buttons" zum Tacken von jeweils Lebensmittel/Mahzeit und aktivität
        ImageView lebensmittelImageView = findViewById(R.id.lebensmittel);
        ImageView aktivitatImageView = findViewById(R.id.aktivität);

        performButtonClickLogic();





        // Setze die Click Listener für die Buttons
        /*mealsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Logik für den Klick auf den "Mahlzeiten"-Button (für die obere)
                Intent i = new Intent(getApplicationContext(), Lebensmittel_Tracked.class);
                startActivity(i);
            }
        });

        activitiesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Logik für den Klick auf den "Aktivitäten"-Button (für die obere)
                Intent i = new Intent(getApplicationContext(), Activity_Tracked.class);
                startActivity(i);
            }
        });*/

        // Weitere Initialisierungen und Anpassungen können hier durchgeführt werden
        // ...


        //für ImageView als Button behandeln: https://www.geeksforgeeks.org/how-to-use-imageview-as-a-button-in-android/
    }

    private void performButtonClickLogic() {
        // Logik für den Klick auf den "Mahlzeiten"-Button (für die obere)
        Intent mealsIntent = new Intent(getApplicationContext(), Lebensmittel_Tracked.class);
        startActivity(mealsIntent);

        // Logik für den Klick auf den "Aktivitäten"-Button (für die obere)
        Intent activitiesIntent = new Intent(getApplicationContext(), Activity_Tracked.class);
        startActivity(activitiesIntent);

        // Weitere Logik, die Sie hier ausführen möchten...
    }
}
