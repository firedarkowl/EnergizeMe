package com.example.EnergizeMe.myfirstapp.Logik;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class BenutzerTest {

    private Benutzer benutzer;
    private Aktivitat aktivitat;
    private LebensMittel lebensmittel;

    @Before
    public void setUp() throws Exception {
        // Set up a sample user for testing
        benutzer = new Benutzer("John", Gender.MALE, LocalDate.of(1990, 1, 1),
                180, 80.0, Ernaehrungsziel.ABNEHMEN, Aktivitaetslevel.MODERAT);
        // Create an Aktivitat object
        Aktivitat aktivitat = new Aktivitat("Leicht Sport", LocalDate.now(), 30, benutzer);
        Map<String, Double> naehrwerte = new HashMap<>();
        naehrwerte.put("Kalorien", 100.0);
        naehrwerte.put("Fett", 10.0);
        naehrwerte.put("Ballaststoffe", 5.0);
        lebensmittel = new LebensMittel("Test Lebensmittel", naehrwerte, benutzer);

    }

    @Test
    public void testTaglichePunktstand() {
        double initialPunktstandTag = benutzer.taglichePunktstand();
        double expectedPunktstandTag = benutzer.setPunktZahl();
        Assert.assertEquals(expectedPunktstandTag, initialPunktstandTag, 0.01);

        Aktivitat aktivitat = new Aktivitat("Leicht Sport", LocalDate.now(), 60, benutzer);
        double burnedCalories = aktivitat.berechneVerbrannteKalorien();
        benutzer.addTaglicheBestanspunkte(burnedCalories);
        double updatedPunktstandTag = benutzer.taglichePunktstand();
        double expectedUpdatedPunktstandTag = expectedPunktstandTag + burnedCalories;
        Assert.assertEquals(expectedUpdatedPunktstandTag, updatedPunktstandTag, 0.01);
    }

    @Test
    public void testBerechneWochepunktstand() {
        double initialWochepunktstand = benutzer.berechneWochepunktstand();
        double expectedWochepunktstand = 0.0;
        Assert.assertEquals(expectedWochepunktstand, initialWochepunktstand, 0.01);

        Aktivitat aktivitat = new Aktivitat("Leicht Sport", LocalDate.now(), 60, benutzer);
        double burnedCalories = aktivitat.berechneVerbrannteKalorien();
        benutzer.addTaglicheBestanspunkte(burnedCalories);
        double updatedWochepunktstand = benutzer.berechneWochepunktstand();
        double expectedUpdatedWochepunktstand = burnedCalories;
        Assert.assertEquals(expectedUpdatedWochepunktstand, updatedWochepunktstand, 0.01);
    }

    @Test
    public void testGetAge() {
        int age = benutzer.getAge();
        int expectedAge = LocalDate.now().getYear() - benutzer.getBirthdate().getYear();
        Assert.assertEquals(expectedAge, age);
    }


    @Test
    public void setPunktZahl() {

        double expectedPunktstandTag = 31;
        benutzer.setPunktZahl();
        double actualPunktstandTag = benutzer.getPunktZahl();
        Assert.assertEquals(expectedPunktstandTag, actualPunktstandTag, 0.0);

    }}
