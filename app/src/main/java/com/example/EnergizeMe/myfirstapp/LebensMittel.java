package com.example.EnergizeMe.myfirstapp;
import java.util.HashMap;
import java.util.Map;
/**Ein Klasse , die implementiert, was ein Benutzer der App an einem Tag verbraucht */

public class LebensMittel {
    public Benutzer getKunde() {
        return benutzer;
    }

    public void setKunde(Benutzer benutzer) {
        this.benutzer = benutzer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Benutzer benutzer;
    private String name;
    private Map<String, Double> naehrwerte; // Key: Nährstoff, Value: Nährwert pro 100g

    public Map<String, Double> getNaehrwerte() {
        return naehrwerte;
    }

    public LebensMittel(String name, Map<String, Double> naehrwerte) {
        this.name = name;
        this.naehrwerte = naehrwerte;
    }

    public double berechneKalorien(double portionsgroesse) {
        return naehrwerte.get("Kalorien") * portionsgroesse / 100.0;
    }

    //z.b. in USE haben andere einheiten als EU
    public double umrechnenPortionsgroesse(double portionsgroesse, String einheit) {
        Map<String, Double> faktoren = new HashMap<>();
        faktoren.put("Gramm", 1.0);
        faktoren.put("Unzen", 28.35);
        faktoren.put("Tassen", 236.59);
        faktoren.put("Milliliter", 1.0);
        double faktor = faktoren.get(einheit);
        return portionsgroesse * faktor / 100.0;
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
    }//diese Methode Berchnet den Punkte von ein Lebensmittel ein, und den Punkte am Taglichepunktstand addiert
    public double punkt(double portionsgroesse) {
        double kalorien = berechneKalorien(portionsgroesse);
        double fett = naehrwerte.get("Fett") * portionsgroesse / 100.0;
        double ballaststoffe = Math.min(naehrwerte.get("Ballaststoffe"), 4.0) * portionsgroesse / 100.0;
        double points = Math.ceil((kalorien / 50.0 + fett / 12.0 - ballaststoffe / 5.0) * 2.0) / 2.0;
        benutzer.setTaglicheBestanspunkte1(points);;
        return points;
    }

}
