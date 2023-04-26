package com.example.myfirstapp;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Diese Klasse implementiert den Nutzer der EnergizeMe-App.
 */

public class Benutzer {
    private String name;
    private Gender gender;
    private LocalDate birthdate;
    private int height;
    private double weight;
    private Ernaehrungsziel ernaehungsziel;
    private Aktivitaetslevel aktivitaetslevel;
    private double punktestandTag;
    private double punktestandWoche;
    private double taglicheBestanspunkte;

    public Benutzer(String name, Gender gender, LocalDate birthdate, int height, double weight, Ernaehrungsziel ernaehungsziel, Aktivitaetslevel aktivitaetslevel) {
        this.name = name;
        this.gender = gender;
        this.birthdate = birthdate;
        this.height = height;
        this.weight = weight;
        this.ernaehungsziel = ernaehungsziel;
        this.aktivitaetslevel = aktivitaetslevel;

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void taeglicherPunktestand(){
        punktestandWoche += punktestandTag;
        LocalTime now = LocalTime.now();
        if (now.getHour() >= 23) {
            punktestandTag = 0;
        }
    }

    public void addTaeglicheBestandspunkte(double punkte){
        punktestandTag +=punkte;

    }
    public double getTotalPoints() {
        return punktestandTag;
    }
}
