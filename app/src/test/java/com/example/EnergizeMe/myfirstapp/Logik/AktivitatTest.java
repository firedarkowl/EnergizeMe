package com.example.EnergizeMe.myfirstapp.Logik;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class AktivitatTest {

    private Benutzer benutzer;
    private Aktivitat aktivitat;
    private Nahrung lebensmittel;

    @Before
    public void setup() {
        // Set up a sample user for testing
        benutzer = new Benutzer("John", Gender.MALE,
                180, 80.0,33, Ernaehrungsziel.ABNEHMEN, Aktivitaetslevel.MODERAT);
        // Create an Aktivitat object
        aktivitat = new Aktivitat("Leicht Sport", LocalDate.now(), 60, benutzer);
        Map<String, Double> naehrwerte = new HashMap<>();
        naehrwerte.put("Kalorien", 100.0);
        naehrwerte.put("Fett", 10.0);
        naehrwerte.put("Ballaststoffe", 5.0);
        lebensmittel = new Nahrung("Test Lebensmittel", naehrwerte, benutzer);
    }

    @Test
    public void testBerechneVerbrannteKalorien_LeichtSport() {
        double burnedCalories = aktivitat.aktPunkteRechnung();
        double expectedCalories = Math.round(60 * benutzer.getWeight() / 1940.0);

        Assert.assertEquals(expectedCalories, burnedCalories, 0.01);
    }

    @Test
    public void testBerechneVerbrannteKalorien_MittelIntensiv() {
        aktivitat.setSportArt("Mittel Intensiv");
        double burnedCalories = aktivitat.aktPunkteRechnung();
        double expectedCalories = Math.round(60 * benutzer.getWeight() / 1400.0);

        Assert.assertEquals(expectedCalories, burnedCalories, 0.01);
    }

    @Test
    public void testBerechneVerbrannteKalorien_IntensivSport() {
        aktivitat.setSportArt("Intensiv Sport");
        double burnedCalories = aktivitat.aktPunkteRechnung();
        double expectedCalories = Math.round(60 * benutzer.getWeight() / 560.0);

        Assert.assertEquals(expectedCalories, burnedCalories, 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBerechneVerbrannteKalorien_UnknownSportArt() {
        aktivitat.setSportArt("Unknown Sport");
        aktivitat.aktPunkteRechnung();
    }
}
