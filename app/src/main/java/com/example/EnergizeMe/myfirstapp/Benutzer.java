package com.example.EnergizeMe.myfirstapp;

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

    public Benutzer(String name, Gender gender, LocalDate birthdate, int height, double weight, Ernaehrungsziel ernaehungsziel, Aktivitaetslevel aktivitaetslevel) {
        this.name = name;
        this.gender = gender;
        this.birthdate = birthdate;
        this.height = height;
        this.weight = weight;
        this.ernaehungsziel = ernaehungsziel;
        this.aktivitaetslevel = aktivitaetslevel;

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

    public void setPunktstandtag(double punktstandtag) {
        this.punktstandtag = punktstandtag;
    }

    public double getPunktstandwoche() {
        return punktstandwoche;
    }

    public void setPunktstandwoche(double punktstandwoche) {
        this.punktstandwoche = punktstandwoche;
    }

    public double getTaglicheBestanspunkte() {
        return taglicheBestanspunkte;
    }

    public void setTaglicheBestanspunkte(double taglicheBestanspunkte) {
        this.taglicheBestanspunkte = taglicheBestanspunkte;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void taglichePunktstand(){
        punktstandwoche +=punktstandtag;
        LocalTime now = LocalTime.now();
        if (now.getHour() >= 23) {
            punktstandtag= 0;
        }
    }
    public void setTaglicheBestanspunkte1(double punkte){
        punktstandtag +=punkte;
        taglicheBestanspunkte=punkte;
    }
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
     @RequiresApi(api = Build.VERSION_CODES.O)
     public void setTaglicheBestanspunkte2(double points) {
     // Calculate the daily points earned from exercise
     double exercisePoints = 0.0;

     exercisePoints += Aktivitat.berechneVerbrannteKalorien();

     double LebensMittelPoints = 0.0;
     LebensMittelPoints+=points;
     // Calculate the total points for the day
     double totalPoints = points - LebensMittelPoints + exercisePoints;

     // Set the daily points to the maximum of the total points and 0
     taglicheBestanspunkte2 = Math.max(totalPoints  , 0.0);
     }

     **/


    public void addTaglicheBestanspunkte(double punkte){
        punktstandtag +=punkte;

    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void setPunktZahl(double punkte) {
        int punktZahl = 0;
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
        setPunktZahl(PunktZahl);
    }


}





