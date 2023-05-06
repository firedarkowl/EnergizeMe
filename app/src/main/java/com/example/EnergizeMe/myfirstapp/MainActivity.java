package com.example.EnergizeMe.myfirstapp;

import android.content.Intent;
import android.os.Bundle;

import com.example.myfirstapp.R;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myfirstapp.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    DataBaseHelper myDb;
    private Button createButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Button btn = (Button) findViewById(R.id.button_create);
        btn.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(youShallNotPass()){
                    Intent i = new Intent(getApplicationContext(), UserView.class);
                    startActivity(i);
                } else {
                    Toast.makeText(MainActivity.this, "Bitte gib deine Daten ein!", Toast.LENGTH_SHORT).show();
                }
            }
        }));





        //setSupportActionBar(binding.toolbar);

        /*NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        myDb = new DataBaseHelper(this);*/


        /*binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    /**
     *Hilfsmethode: checkt ob der User seinen Namen und Nachnamen eingegeben hat
     */
    private boolean youShallNotPass() {
        EditText txt1 = findViewById(R.id.vorname);
        String vorname = txt1.getText().toString();

        EditText txt2 = findViewById(R.id.nachname);
        String nachname = txt2.getText().toString();

        if(vorname.isEmpty()) {
            txt1.setError("Bitte deinen Namen eingeben!");
            return false;
        }
        if(nachname.isEmpty()) {
            txt2.setError("Bitte deinen Namen eingeben!");
            return false;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}