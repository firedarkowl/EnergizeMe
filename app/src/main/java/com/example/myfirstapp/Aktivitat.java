package com.example.myfirstapp;



import android.os.Build;

import androidx.annotation.RequiresApi;



import java.time.LocalDate;



public class Aktivitat {

    private Kunde kunde;
    private boolean sport;

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }

    public boolean isSport() {
        return sport;
    }

    public void setSport(boolean sport) {
        this.sport = sport;
    }

    public double getSavedPoints() {
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

    public String getSportArt() {
        return sportArt;
    }

    public void setSportArt(String sportArt) {
        this.sportArt = sportArt;
    }

    private double savedPoints;
    private int dauer;
    private LocalDate lastEvent;
    private String sportArt;

    public Aktivitat(boolean sport, String sportArt,LocalDate lastEvent,int dauer){
        this.sport=sport;
        this.lastEvent=lastEvent;
        this.dauer=dauer;
        this.sportArt=sportArt;
    }

    //Die Methode speichert auch den Betrag der Punkte, die täglich gespart werden dürfen,
    // und stellt sicher, dass diese Punkte nicht verfallen, solange sie innerhalb von 7 Tagen verwendet werden.
    @RequiresApi(api = Build.VERSION_CODES.O)
    public double punkt() {
        double punkte=0;
        if (sport) {
            if (dauer > 0 && kunde.getWeight()> 0) {
                if (dauer * kunde.getWeight() / 1940.0 <= 0.5) {
                    punkte += 0.5;
                } else if (dauer * kunde.getWeight()/ 1400.0 <= 1.0) {
                    punkte += 1.0;
                } else {
                    punkte += dauer * kunde.getWeight()/ 560.0;
                }
            }
        }
        // Wenn es bereits ein Event gab und eine Woche seitdem vergangen ist, setzen Sie gesparte Punkte auf 0
        LocalDate today = LocalDate.now();
        if (today.isAfter(lastEvent.plusWeeks(1))) {
            savedPoints = 0;
        }
        // Berechne die gesparten Punkte, die am selben Tag ausgegeben werden können
        double dailySavedPoints = Math.min(savedPoints, 4.0);
        // Speichere die übrigen Punkte für später
        savedPoints -= dailySavedPoints;
        // Ziehe die am selben Tag gesparten Punkte ab und sorge dafür, dass die Punktzahl nicht negativ wird
        double earnedPoints = Math.max(punkte - dailySavedPoints, 0.0);
        kunde.addTaglicheBestanspunkte(earnedPoints);
        return earnedPoints;
    }
}
