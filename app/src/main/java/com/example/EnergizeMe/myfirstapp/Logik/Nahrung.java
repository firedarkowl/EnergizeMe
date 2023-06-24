package com.example.EnergizeMe.myfirstapp.Logik;

public class Nahrung {
    private String name;
    private int menge;
    private int punkte;
    private int kalorien;
    private int protein;
    private int fett;
    private int kh;
    private int zucker;

    public Nahrung(String name, int menge, int punkte, int kalorien, int protein, int fett, int kh, int zucker) {
        this.name = name;
        this.menge = menge;
        this.punkte = punkte;
        this.kalorien = kalorien;
        this.protein = protein;
        this.fett = fett;
        this.kh = kh;
        this.zucker = zucker;


    }

    public String getName() {
        return name;
    }

    public int getMenge() {
        return menge;
    }

    public int getPunkte() {
        return punkte;
    }

    public int getKalorien() {
        return kalorien;
    }

    public int getProtein() {
        return protein;
    }

    public int getFett() {
        return fett;
    }

    public int getKh() {
        return kh;
    }

    public int getZucker() {
        return zucker;
    }
}
