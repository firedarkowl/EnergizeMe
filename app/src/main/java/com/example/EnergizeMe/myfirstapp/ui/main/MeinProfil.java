package com.example.EnergizeMe.myfirstapp.ui.main;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.EnergizeMe.myfirstapp.Datenbank.DataBaseHelperBenutzer;
import com.example.EnergizeMe.myfirstapp.Datenbank.DataBaseMeinProfil;
import com.example.myfirstapp.R;
import com.example.myfirstapp.databinding.ActivityMainBinding;

import java.util.HashMap;

public class MeinProfil extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private @NonNull ActivityMainBinding binding;
    private DataBaseMeinProfil profilDB;
    private EditText geburtsdatum;
    private EditText groesse;
    private EditText gewicht;
    private EditText ziel;
    private Spinner taetigkeitslevel, geschlecht;
    private ImageView back;
    private TextView vorname_view, nachname_view, alter_view;

    private Context context;

    Button weight_change, height_change, delete_profil, gender_change, activity_change;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_mein_profil);

        profilDB = new DataBaseMeinProfil(this);
        vorname_view = findViewById(R.id.vorname);
        nachname_view = findViewById(R.id.nachname);
        alter_view = findViewById(R.id.alter);

        DataBaseHelperBenutzer dbhb = new DataBaseHelperBenutzer(this);
        HashMap<String, String> userData = dbhb.getUserData();

        vorname_view.setText(userData.get("vorname"));
        nachname_view.setText(userData.get("nachname"));
        alter_view.setText("Alter: "+ String.valueOf(userData.get("alter")));


        geschlecht = findViewById(R.id.gender_info);
        String[] geschlechter = new String[]{"Männlich", "Weiblich", "Divers"};
        ArrayAdapter<String> adapterGeschlecht = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, geschlechter);
        geschlecht.setAdapter(adapterGeschlecht);


        groesse = (EditText) findViewById(R.id.height_info);
        groesse.setText(String.valueOf(userData.get("groesse")));
        gewicht = (EditText) findViewById(R.id.weight_info);
        gewicht.setText(String.valueOf(userData.get("gewicht")));
        ziel = (EditText) findViewById(R.id.weight_info);

        taetigkeitslevel = findViewById(R.id.activity_info);
        String[] taetigkeiten = new String[]{"Wenig Bewegung", "Durchschnittliche Bewegung", "Viel Bewegung"};
        ArrayAdapter<String> adapterTaetigkeiten = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, taetigkeiten);
        taetigkeitslevel.setAdapter(adapterTaetigkeiten);

        String selectedTatigkeit = userData.get("tätigkeit");
        int selectedTaetigkeitPosition = adapterTaetigkeiten.getPosition(selectedTatigkeit);
        taetigkeitslevel.setSelection(selectedTaetigkeitPosition);


        String selectedGender = userData.get("geschlecht");
        int selectedGenderPosition = adapterGeschlecht.getPosition(selectedGender);
        geschlecht.setSelection(selectedGenderPosition);

        back = findViewById(R.id.back);
        delete_profil = findViewById(R.id.delete_profil);
        Spinner spinner = findViewById(R.id.spinner);
        //tring selectedValue = spinner.getSelectedItem().toString();

        weight_change = findViewById(R.id.weight_change);
        weight_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues cv = new ContentValues();
                cv.put(DataBaseHelperBenutzer.COL_GEWICHT, gewicht.getText().toString());
                dbhb.updateCurrentUser(cv);
                Toast.makeText(context, "Gewicht wurde geändert", Toast.LENGTH_SHORT).show();
            }
        });

        gender_change = findViewById(R.id.gender_change);
        gender_change.setOnClickListener (new View.OnClickListener() {
        @Override
        public void onClick(View v){
            String selectedGender = geschlecht.getSelectedItem().toString();
            ContentValues cv = new ContentValues();
            cv.put(DataBaseHelperBenutzer.COL_GESCHLECHT, selectedGender);
            dbhb.updateCurrentUser(cv);
            Toast.makeText(context, "Geschlecht wurde geändert", Toast.LENGTH_SHORT).show();

            // Den geänderten Wert im Spinner anzeigen
            int selectedGenderPosition = adapterGeschlecht.getPosition(selectedGender);
            geschlecht.setSelection(selectedGenderPosition);
        }
        });

        activity_change = findViewById(R.id.activity_change);
        activity_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedActivity = taetigkeitslevel.getSelectedItem().toString();
                ContentValues cv = new ContentValues();
                cv.put(DataBaseHelperBenutzer.COL_TAETIGKEIT, selectedActivity);
                dbhb.updateCurrentUser(cv);
                //Toast.makeText(context, "Tätigkeitslevel wurde aktualisiert", Toast.LENGTH_SHORT).show();

                int selectedTatigkeitPosition = adapterTaetigkeiten.getPosition(selectedActivity);
                taetigkeitslevel.setSelection(selectedTatigkeitPosition);

            }
        });

        height_change = findViewById(R.id.height_change);
        height_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues cv = new ContentValues();
                cv.put(DataBaseHelperBenutzer.COL_GROESSE, groesse.getText().toString());
                dbhb.updateCurrentUser(cv);
                Toast.makeText(context, "Größe wurde geändert", Toast.LENGTH_SHORT).show();
            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        delete_profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(context)
                        .setTitle("Unwiderufliches Löschen")
                        .setMessage("Willst Du dieses Profil wirklich unwiederuflich löschen?")
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                dbhb.deleteCurrentUser();
                                DataBaseHelperBenutzer.currentUserId = -1;
                                finish();
                                startActivity(new Intent(context, MainActivity.class));
                            }})
                        .setNegativeButton(android.R.string.no, null).show();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }


}