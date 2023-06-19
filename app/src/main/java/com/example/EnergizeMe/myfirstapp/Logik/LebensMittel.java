package com.example.EnergizeMe.myfirstapp.Logik;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Map;

/**
 * Ein Klasse , die implementiert, was ein Benutzer der App an einem Tag verbraucht
 */

public class LebensMittel {

    private Benutzer benutzer;
    private String name;
    private Map<String, Double> naehrwerte; // Key: Nährstoff, Value: Nährwert pro 100g
    private double lebPunkte;
    private double portionGrosse;
    private double kalorien;

    public LebensMittel(String name, Map<String, Double> naehrwerte, Benutzer benutzer) {
        this.benutzer = benutzer;
        this.name = name;
        this.naehrwerte = naehrwerte;
    }

    //diese methode zur Überprüfen der Gültigkeit der eingegebenen Nahrwertangaben.
    public boolean istGueltig() {
        // Überprüfen, ob alle Nährstoffangaben und die Portionsgröße gültige positive Zahlen sind
        for (double wert : naehrwerte.values()) {
            if (wert < 0) {
                return false;
            }
        }
        return true;
    }

    //diese Methode Berchnet den Punkte von ein Lebensmittel ein, und den Punkte am Taglichepunktstand addiert
    @RequiresApi(api = Build.VERSION_CODES.O)
    public double lebPunkteRechnung(double portionsgroesse) {
         kalorien = naehrwerte.get("Kalorien") * portionsgroesse / 100.0;
        double fett = naehrwerte.get("Fett") * portionsgroesse / 100.0;
        double ballaststoffe = Math.min(naehrwerte.get("Ballaststoffe"), 4.0) * portionsgroesse / 100.0;
        lebPunkte = Math.ceil((kalorien / 50.0 + fett / 12.0 - ballaststoffe / 5.0) * 2.0) / 2.0;
        benutzer.taglichePunktstand(null, this);
        portionGrosse = portionsgroesse;
        return Math.round(lebPunkte);
    }

    public Map<String, Double> getNaehrwerte() {
        return naehrwerte;
    }

    public Benutzer getKunde() {
        return benutzer;
    }

    public void setKunde(Benutzer benutzer) {
        this.benutzer = benutzer;
    }

    public String getName() {
        return name;
    }
    public double getKalorien(){return kalorien;}

    @RequiresApi(api = Build.VERSION_CODES.O)
    public double getLebPunkte() {
        return Math.round(lebPunkte);
    }

    public void setName(String name) {
        this.name = name;
    }

}
