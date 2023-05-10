package com.example.EnergizeMe.myfirstapp.Datenbank;

import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myfirstapp.R;

public class DummyKlasse extends AppCompatActivity {
/*
    DataBaseHelperBenutzer myDb;
    EditText editTextId, editName, editGebDatum; // Rest der Attribute hinzufügen

    //Button der eingegebene Daten zur DB hinzufügt
    Button btnAddData;

    //Button, der alle gespeicherten Daten ausgibt
    Button btnviewAll;
    //BUtton zum Updaten der Daten
    Button btnViewUpdate;
    // Button zum Löschen
    Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // von Lan: um DB zu erstellen und erste Benutzerdaten zu erfassen
        myDb = new DataBaseHelperBenutzer(this);

        // edit-Variablen bzw. R.id.x-Variablen muessen noch anepasst werden. Ich weiss nicht welche Variablen alles imFrontend sind
        //editName = (EditText) findViewById(R.id.vorname);
        //editGebDatum = (EditText) findViewById(R.id.) // Rest der Attribute ergänzen
        btnAddData = (Button)findViewById(R.id.button_create); // id von random button
        btnviewAll = (Button)findViewById(R.id.section_label);// id von random button
        btnViewUpdate = (Button)findViewById(R.id.section_label);// id von random button
        btnDelete = (Button)findViewById(R.id.vorname);// id von random button

        addData();
        viewAll();
        updateData();
        deleteData();

    }

    public void addData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //noch in bearbeitung
                        boolean isInserted = myDb.insertData(editName.getText()); // Rest der Attribute hinzufügen: erst durch Frontend möglich
                        if(isInserted==true) {
                            //Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(MainActivity.this,"Data not Inserted", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }

    public void viewAll() {
        btnviewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getAllData();
                        if(res.getCount()== 0) {
                            // show Message
                            showMessage("Error", "Nothing found");
                            return;
                        }
                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Id : "+ res.getString(0)+"\n");
                            buffer.append("Name : "+ res.getString(1)+"\n");
                            buffer.append("GebDatum : "+ res.getString(2)+"\n");
                            buffer.append(" : "+ res.getString(3)+"\n");
                            buffer.append(" : "+ res.getString(4)+"\n\n");
                            // ... Rest hinzufügen
                        }

                        showMessage("Data",buffer.toString());

                    }
                }

        );
    }

    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();

    }

    public void updateData() {
        btnViewUpdate.setOnClickListener(
                new View.OnClickListener()  {
                    @Override
                    public void onClick(View v) {
                        //boolean isUpdated = myDb.updateData(editTextId.getId(),editName.getId(),editGebDatum.getId()); // rest der attribute hinzufügen
                        if(isUpdated == true) {
                            Toast.makeText(MainActivity.this, "Data Updated", Toast.LENGTH_LONG).show();

                        } else {
                            Toast.makeText(MainActivity.this, "Data Not Updated", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }

    public void deleteData() {
        btnDelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deleteRows = myDb.deleteData(editTextId.getText().toString());
                        if(deleteRows >0) {
                            Toast.makeText(MainActivity.this, "Data Deleted", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(MainActivity.this, "Data not Deleted", Toast.LENGTH_LONG).show();
                        }
                    }
                }

        );
    }


 */
}
