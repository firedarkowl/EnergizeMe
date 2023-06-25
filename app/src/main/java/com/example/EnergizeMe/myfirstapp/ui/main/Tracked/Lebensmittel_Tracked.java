package com.example.EnergizeMe.myfirstapp.ui.main.Tracked;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.EnergizeMe.myfirstapp.ui.main.MeinTag;
import com.example.myfirstapp.R;

import java.util.ArrayList;

public class Lebensmittel_Tracked extends AppCompatActivity {
    private ImageView back;
    private TextView title;
    private TextView gender;
    private ListView myListView;

    private AppBarConfiguration appBarConfiguration;

    public static ArrayList<String> tracked = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lebensmittel_tracked);

        // Initialisiere die Views
        back = findViewById(R.id.back);
        title = findViewById(R.id.title);
        gender = findViewById(R.id.gender);
        myListView = findViewById(R.id.myListView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tracked);

        // Setze den ArrayAdapter auf die ListView
        myListView.setAdapter(adapter);

        // Weitere Anpassungen und Logik können hier durchgeführt werden
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Logik für den Klick auf den "Mahlzeiten"-Button (für den oberen Button)
                Intent i = new Intent(Lebensmittel_Tracked.this, MeinTag.class);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_lebensmittel_tracked);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
/*
    @Override
    public void onResume(){
        super.onResume();
        pointsTextView.setText(punkte+"");

    }*/
}


/*
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myfirstapp.R;
import com.example.myfirstapp.databinding.ActivityLebensmittelTrackedBinding;
import com.google.android.material.snackbar.Snackbar;

public class Lebensmittel_Tracked extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityLebensmittelTrackedBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLebensmittelTrackedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_lebensmittel_tracked);
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

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_lebensmittel_tracked);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}*/
