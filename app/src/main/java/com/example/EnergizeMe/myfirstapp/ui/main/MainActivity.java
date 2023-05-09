package com.example.EnergizeMe.myfirstapp.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.EnergizeMe.myfirstapp.Datenbank.DataBaseHelperBenutzer;
import com.example.myfirstapp.R;
import com.example.myfirstapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    DataBaseHelperBenutzer myDb;
    EditText editName, editGebDatum;
    Button btnAddData;

    private Button createButton;

    private String PREF_NAME = null;
    private String PREF_NACHNAME = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        /*
        // von Lan: um DB zu erstellen und erste Benutzerdaten zu erfassen
        myDb = new DataBaseHelperBenutzer(this);

        // edit-Variablen bzw. R.id.x-Variablen muessen noch anepasst werden. Ich weiss nicht welche Variablen alles im
        // Frontend sind
        editName = (EditText) findViewById(R.id.vorname);
        //editGebDatum = (EditText) findViewById(R.id.)

        */


        Button btn = (Button) findViewById(R.id.button_create);
        btn.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (youShallNotPass()) {
                    Intent i = new Intent(getApplicationContext(), UserView.class);
                    startActivity(i);
                    EditText txt1 = findViewById(R.id.vorname);
                    String vorname = txt1.getText().toString();

                    EditText txt2 = findViewById(R.id.nachname);
                    String nachname = txt2.getText().toString();

                    Toast.makeText(MainActivity.this, "Willkommen " + vorname + " " + nachname, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Bitte gib deine Daten ein!", Toast.LENGTH_SHORT).show();
                }
            }
        }));






        //setSupportActionBar(binding.toolbar);

        /*NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        */


        /*binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    /*
    public void addData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //noch in bearbeitung
                        boolean isInserted = myDb.insertData(editName.getText());
                        if(isInserted==true) {
                            Toast.makeText(MainActivity.this, "Data INserted", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(MainActivity.this,"Data not Inserted", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }
    */

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