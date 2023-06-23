package com.example.EnergizeMe.myfirstapp.Logik;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;


public class LebensMittelTest {

    private Nahrung lebensmittel;
    private Aktivitat aktivitat;
    private Benutzer benutzer;

    @Before
    public void setUp() {
        // Set up a sample user for testing
        benutzer = new Benutzer("John", Gender.MALE,
                180, 80.0, 33, Ernaehrungsziel.ABNEHMEN, Aktivitaetslevel.MODERAT);
        // Create an Aktivitat object
         aktivitat = new Aktivitat("Leicht Sport", LocalDate.now(), 30, benutzer);
        Map<String, Double> naehrwerte = new HashMap<>();
        naehrwerte.put("Kalorien", 100.0);
        naehrwerte.put("Fett", 10.0);
        naehrwerte.put("Ballaststoffe", 5.0);
        lebensmittel = new Nahrung("Test Lebensmittel", naehrwerte, benutzer);
    }

    @Test
    public void testIstGueltig_ValidData() {
        // The nutritional values are valid, so the method should return true
        Assert.assertTrue(lebensmittel.istGueltig());
    }

    @Test
    public void testIstGueltig_InvalidData() {
        // Set an invalid nutritional value (negative value)
        lebensmittel.getNaehrwerte().put("Kalorien", -50.0);
        // The nutritional values are now invalid, so the method should return false
        Assert.assertFalse(lebensmittel.istGueltig());
    }

    @Test
    public void testPunkt() {
        Map<String, Double> naehrwerte = new HashMap<>();
        naehrwerte.put("Kalorien", 100.0);
        naehrwerte.put("Fett", 10.0);
        naehrwerte.put("Ballaststoffe", 5.0);

        Nahrung lebensmittel = new Nahrung("Example Food", naehrwerte, benutzer);

        double portionsgroesse = 200.0;
        double expectedPoints = 5;
        double actualPoints = lebensmittel.lebPunkteRechnung(portionsgroesse);
        Assert.assertEquals(expectedPoints, actualPoints, 0.01);
    }

}
