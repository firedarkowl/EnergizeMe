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

        ArrayList<String> myList = new ArrayList<>();

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