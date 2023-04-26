package com.example.myfirstapp;



import java.time.LocalDate;

public class EintragsAktivitat {

    private Kunde kunde;
    private Aktivitat aktivitat;
    private LocalDate datum;
    private double dauer;

    public LocalDate getDatum() {
        return datum;
    }

    public double getDauer() {
        return dauer;
    }

    public void setDauer(double dauer) {
        this.dauer = dauer;
    }

    public String toString() {
        return String.format("%s (%s) am %s, %.2f g", kunde,aktivitat.getDauer(),aktivitat.getSportArt(), datum);
    }

}

