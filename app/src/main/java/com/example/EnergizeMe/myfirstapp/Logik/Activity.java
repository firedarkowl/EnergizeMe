package com.example.EnergizeMe.myfirstapp.Logik;

import java.time.LocalTime;

public class Activity {
    private String name;
    private int dauer;
    private int kalorien;
    private int punkte;
    private LocalTime zeit;

    public Activity(String name, int dauer, int kalorien, int punkte, LocalTime zeit) {

        this.name = name;
        this.dauer = dauer;
        this.kalorien = kalorien;
        this.punkte = punkte;
        this.zeit = zeit;
    }

    public String getName() {
        return name;
    }

    public int getDauer() {
        return dauer;
    }

    public int getKalorien() {
        return kalorien;
    }

    public int getPunkte() {
        return punkte;
    }

    public LocalTime getZeit() {
        return zeit;
    }
}
