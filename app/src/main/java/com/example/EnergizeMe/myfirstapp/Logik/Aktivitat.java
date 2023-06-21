package com.example.EnergizeMe.myfirstapp.Logik;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDate;

/**
 * Diese Klasse implemntiert den Aktivität von den Nutzer von Energize-Me App
 */


public class Aktivitat {

    private Benutzer benutzer;
    private String sportArt;
    private double savedPoints;
    private int dauer;
    private LocalDate lastEvent;

    public Aktivitat(String sportArt, LocalDate lastEvent, int dauer, Benutzer benutzer) {
        this.sportArt = sportArt;
        this.lastEvent = lastEvent;
        this.dauer = dauer;
        this.benutzer = benutzer;
    }

    //Die Methode speichert auch den Betrag der Punkte, die täglich gespart werden dürfen,
    // und stellt sicher, dass diese Punkte nicht verfallen, solange sie innerhalb von 7 Tagen verwendet werden.
    @RequiresApi(api = Build.VERSION_CODES.O)
    public double aktPunkteRechnung() {
        double aktPunkte = 0.0;
        if (sportArt != null && sportArt.equals("Leicht Sport")) {
            //zahlen kommen aus der Formel
            aktPunkte += Math.round(dauer * benutzer.getWeight() / 1940.0);
        } else if (sportArt != null && sportArt.equals("Mittel Intensiv")) {
            aktPunkte += Math.round(dauer * benutzer.getWeight()) / 1400.0;
        } else if (sportArt != null && sportArt.equals("Intensiv Sport")) {
            aktPunkte += Math.round(dauer * benutzer.getWeight()) / 560.0;
        } else {
            throw new IllegalArgumentException("Unbekannte Sportart: " + sportArt);
        }
        benutzer.taglichePunktstand(this, null);
        savedPoints = aktPunkte;
        return Math.round(aktPunkte);
    }

    public Benutzer getBenutzer() {
        return benutzer;
    }


    public String getSportArt() {
        return sportArt;
    }

    public void setSportArt(String sportArt) {
        this.sportArt = sportArt;
    }

    public double getSavedPoints() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            aktPunkteRechnung();
        }
        return savedPoints;
    }

    public void setSavedPoints(double savedPoints) {
        this.savedPoints = savedPoints;
    }

    public int getDauer() {
        return dauer;
    }

    public void setDauer(int dauer) {
        this.dauer = dauer;
    }

    public LocalDate getLastEvent() {
        return lastEvent;
    }

    public void setLastEvent(LocalDate lastEvent) {
        this.lastEvent = lastEvent;
    }


}

