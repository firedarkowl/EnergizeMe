package com.example.myfirstapp;



import java.time.LocalDate;


public class VerzehrteNahrungsmittel {

    private Kunde kunde;
    private LebensMittel  lebensMittel;
    private LocalDate datum;
    private double menge; // in Gramm

    public VerzehrteNahrungsmittel(Kunde kunde,LebensMittel lebensMittel, LocalDate datum, double menge) {
        this.kunde=kunde;
        this.lebensMittel = lebensMittel;
        this.datum = datum;
        this.menge = menge;
    }

    public double getKalorien() {
        return lebensMittel.berechneKalorien(menge);
    }

    public double getKohlenhydrate() {
        return lebensMittel.getNaehrwerte().get("Kohlenhydrate") * (menge / 100);
    }

    public double getProtein() {
        return lebensMittel.getNaehrwerte().get("Protein") * (menge / 100);
    }

    public double getFett() {
        return lebensMittel.getNaehrwerte().get("Fett")* (menge / 100);
    }

    public LebensMittel getLebensMittel() {
        return lebensMittel;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public double getMenge() {
        return menge;
    }

    public void setMenge(double menge) {
        this.menge = menge;
    }

    public String toString() {
        return String.format("%s (%s) am %s, %.2f g", kunde,lebensMittel.getName(),lebensMittel.getNaehrwerte(), datum, menge);
    }
}
