package com.example.EnergizeMe.myfirstapp.ui.main.Tracking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.EnergizeMe.myfirstapp.Logik.Nahrung;
import com.example.EnergizeMe.myfirstapp.ui.main.MeinTag;
import com.example.myfirstapp.R;
import com.example.myfirstapp.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class Tracking_Lebensmittel extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ImageView back;
    private ListView myListView;
    private @NonNull ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_tracking_lebensmittel);

        ArrayList<Nahrung> nahrung = new ArrayList<>();

        Nahrung nahrung1 = new Nahrung("Apfel", 100, 5, 52, 0, 0, 14, 10);
        nahrung.add(nahrung1);

        Nahrung nahrung2 = new Nahrung("Banane", 100, 3, 96, 1, 0, 23, 17);
        nahrung.add(nahrung2);

        Nahrung nahrung3 = new Nahrung("Hühnchenbrust", 100, 8, 165, 31, 3, 0, 0);
        nahrung.add(nahrung3);

        Nahrung nahrung4 = new Nahrung("Vollkornbrot", 100, 4, 79, 3, 1, 14, 1);
        nahrung.add(nahrung4);

        Nahrung nahrung5 = new Nahrung("Joghurt", 100, 6, 154, 5, 9, 14, 14);
        nahrung.add(nahrung5);

        back = findViewById(R.id.back);
        myListView = findViewById(R.id.myListView);

        // Weitere Anpassungen und Logik können hier durchgeführt werden
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Logik für den Klick auf den "Mahlzeiten"-Button (für den oberen Button)
                Intent i = new Intent(Tracking_Lebensmittel.this, MeinTag.class);
                startActivity(i);
            }
        });
    }


    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_tracking);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}