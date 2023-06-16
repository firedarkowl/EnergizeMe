package com.example.EnergizeMe.myfirstapp.Logik;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Diese Klasse implementiert den Nutzer der EnergizeMe-App.
 */
public class Benutzer {
    private String name;
    private Gender gender;
    private LocalDate birthdate;
    private int height;
    private double weight;
    private Ernaehrungsziel ernaehungsziel;
    private Aktivitaetslevel aktivitaetslevel;
    private double punktstandtag;
    private double punktstandwoche;
    private double taglicheBestanspunkte;
    private double PunktZahl;

    private double wochepunktstand = 0; // Weekly points variable
    private LocalDate startDate= LocalDate.now(); // Start date of the counting period
    private int daysCounter = 0; // Counter for the number of days
    private LebensMittel lebensMittel;
    private Aktivitat aktivitat;
    public Benutzer(String name, Gender gender, LocalDate birthdate, int height, double weight, Ernaehrungsziel ernaehungsziel, Aktivitaetslevel aktivitaetslevel) {
        this.name = name;
        this.gender = gender;
        this.birthdate = birthdate;
        this.height = height;
        this.weight = weight;
        this.ernaehungsziel = ernaehungsziel;
        this.aktivitaetslevel = aktivitaetslevel;
    }

    /**
     * Berechnet den täglichen Punktestand des Benutzers.
     *
     * @return der tägliche Punktestand des Benutzers
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public double taglichePunktstand() {

        punktstandtag = setPunktZahl();
            if (aktivitat != null) {
                punktstandtag += aktivitat.berechneVerbrannteKalorien();}
            if(lebensMittel != null){
                punktstandtag -= lebensMittel.getPoints();
            }
        LocalTime now = LocalTime.now();
        if (now.getHour() >= 23) {
            punktstandtag = 0;
        }
        LocalDate today = LocalDate.now();
        if (today.isAfter(startDate.plusDays(6))) {
            // Start of a new counting period (7 days), reset the weekly points
            wochepunktstand = 0;
            startDate = today; // Update the startDate to the current date
            daysCounter = 0; // Reset the days counter
            punktstandwoche = 0;
        }
        punktstandwoche += punktstandtag;
        daysCounter++;
        return punktstandtag;
    }

    public double berechneWochepunktstand() {
        return wochepunktstand;
    }

    /**
     * Gibt das Alter des Benutzers zurück.
     *
     * @return das Alter des Benutzers
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public int getAge() {
        LocalDate now = LocalDate.now();
        int age = now.getYear() - birthdate.getYear();
        if (now.getMonthValue() < birthdate.getMonthValue() ||
                (now.getMonthValue() == birthdate.getMonthValue() && now.getDayOfMonth() < birthdate.getDayOfMonth())) {
            age--;
        }
        return age;
    }

    /**
     * Fügt die täglichen Bestanspunkte des Benutzers hinzu.
     */
    public void addTaglicheBestanspunkte(double punkte) {
        punktstandtag += punkte;
    }

    /**
     * Setzt die Punktzahl des Benutzers basierend auf verschiedenen Faktoren wie Geschlecht, Alter, Größe, Gewicht und Aktivitätsniveau.
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public double setPunktZahl() {
        double punktZahl = 0;

        switch (gender) {
            case MALE:
                punktZahl += 15;
                break;
            case FEMALE:
                punktZahl += 7;
                break;
            case DIVERS:
                punktZahl += 15;
                break;
        }

        // Points based on age
        int age = getAge();
        if (age >= 18 && age <= 20) {
            punktZahl += 5;
        } else if (age >= 21 && age <= 35) {
            punktZahl += 4;
        } else if (age >= 36 && age <= 50) {
            punktZahl += 3;
        } else if (age >= 51 && age <= 65) {
            punktZahl += 2;
        } else if (age > 66) {
            punktZahl += 1;
        }

        // Points based on height
        double height = getHeight();
        if (height < 1.60) {
            punktZahl += 1;
        } else {
            punktZahl += 2;
        }

        // Points based on weight
        double initialWeight = getWeight();
        int weightPoints = (int) Math.floor(initialWeight / 10);
        punktZahl += weightPoints;

        // Points based on activity level
        switch (aktivitaetslevel) {
            case NIEDRIG:
                punktZahl += 1;
                break;
            case MODERAT:
                punktZahl += 2;
                break;
            case HOCH:
                punktZahl += 4;
                break;
            case EXTREM:
                punktZahl += 6;
                break;
        }
        // set the total points
        PunktZahl = punktZahl;
    return  PunktZahl;
    }
    /**
     * Gibt die Punktzahl des Benutzers zurück.
     *
     * @return die Punktzahl des Benutzers
     */
    public double getPunktZahl() {
        return PunktZahl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Ernaehrungsziel getErnaehungsziel() {
        return ernaehungsziel;
    }

    public void setErnaehungsziel(Ernaehrungsziel ernaehungsziel) {
        this.ernaehungsziel = ernaehungsziel;
    }

    public Aktivitaetslevel getAktivitaetslevel() {
        return aktivitaetslevel;
    }

    public void setAktivitaetslevel(Aktivitaetslevel aktivitaetslevel) {
        this.aktivitaetslevel = aktivitaetslevel;
    }

    public double getPunktstandtag() {
        return punktstandtag;
    }

}




