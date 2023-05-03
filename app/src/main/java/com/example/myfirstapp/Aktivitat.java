package com.example.myfirstapp;
import android.os.Build;
import androidx.annotation.RequiresApi;
import java.time.LocalDate;
/**Diese Klasse implemntiert den Aktivität von den Nutzer von Energize-Me App*/
public class Aktivitat {

    private Benutzer benutzer;
    private String sportArt;
    private double savedPoints;
    private int dauer;
    private LocalDate lastEvent;

    public Aktivitat(String sportArt,LocalDate lastEvent,int dauer){
        this.sportArt=sportArt;
        this.lastEvent=lastEvent;
        this.dauer=dauer;
    }

    public Benutzer getBenutzer() {
        return benutzer;
    }

    public void setBenutzer(Benutzer benutzer) {
        this.benutzer = benutzer;
    }

    public String getSportArt() {
        return sportArt;
    }

    public void setSportArt(String sportArt) {
        this.sportArt = sportArt;
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

    //Die Methode speichert auch den Betrag der Punkte, die täglich gespart werden dürfen,
    // und stellt sicher, dass diese Punkte nicht verfallen, solange sie innerhalb von 7 Tagen verwendet werden.
    @RequiresApi(api = Build.VERSION_CODES.O)
    public double berechneVerbrannteKalorien() {
        double punkte=0.0;
        if (sportArt.equals("Leicht Sport")) {
            punkte += (dauer * benutzer.getWeight() /1940.0);
        } else if (sportArt.equals("Mittel Intensiv")) {
            punkte += (dauer * benutzer.getWeight()) / 1400.0;
        } else if (sportArt.equals("Intensiv Sport")) {
            punkte += (dauer * benutzer.getWeight()) / 560.0;
        } else {
            throw new IllegalArgumentException("Unbekannte Sportart: " + sportArt);
        }

        // Wenn es bereits ein Event gab und eine Woche seitdem vergangen ist, setzen Sie gesparte Punkte auf 0
        LocalDate today = LocalDate.now();
        if (today.isAfter(lastEvent.plusWeeks(1))) {
            savedPoints = 0;
        }

        savedPoints +=punkte;
        //Hier wird die maximale Anzahl von Punkten berechnet, die täglich gespart werden können.
        // Dabei wird die aktuelle Anzahl der gespeicherten Punkte savedPoints mit dem Wert 4.0 verglichen und der kleinere Wert ausgewählt.
        double dailySavedPoints = Math.min(savedPoints, 4.0);
        //Die Anzahl der gespeicherten Punkte wird um die Anzahl der täglich gesparten Punkte reduziert.
        savedPoints -= dailySavedPoints;
        // Ziehe die Punkte ab, was man isst von sportpunkte, sorge dafür, dass die Punktzahl nicht negativ wird
        return Math.max(benutzer.getPunktstandwoche() - dailySavedPoints, 0.0);
    }
}
