package com.example.myfirstapp;

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

    public void addTaglicheBestanspunkte(double punkte){
        punktstandtag +=punkte;

    }
}
