package com.example.myfirstapp;

import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;




public class Main{

    public static void main(String[] args) {


        // Beispiel-Nahrungsmittelobjekte erstellen
        LebensMittel avocado = new LebensMittel("Avocado",
                Map.of("Kalorien", 160.0, "Fett", 15.0, "Kohlenhydrate", 9.0, "Protein", 2.0));

        LebensMittel chickenBreast = new LebensMittel("Hühnerbrust",
                Map.of("Kalorien", 165.0, "Fett", 3.6, "Kohlenhydrate", 0.0, "Protein", 31.0));

        Kunde kunde = new Kunde("kunde", Gender.MALE, LocalDate.of(2000, 1, 1), 180, 80, Ernahungsziel.ABNEHMEN, AktivityLevel.NIEDRIG);

        // Beispiel-Scanner-Objekt zum Einlesen von Benutzereingaben
        Scanner scanner = new Scanner(System.in);



        // Benutzereingabe für Portionsgröße und Einheit
        System.out.print("Bitte geben Sie die Portionsgröße ein: ");
        double portionsgroesse = scanner.nextDouble();
        scanner.nextLine(); // Zeilenumbruch lesen, um den Scanner zu leeren
        System.out.print("Bitte geben Sie die Einheit ein (Gramm, Unzen, Tassen, Milliliter): ");
        String einheit = scanner.nextLine();

        // Beispiel-Ausgabe der berechneten Kalorien und umgerechneten Portionsgröße
        System.out.println("Avocado - Portionsgröße: " + portionsgroesse + " " + einheit);
        System.out.println("Kalorien: " + avocado.berechneKalorien(avocado.umrechnenPortionsgroesse(portionsgroesse, einheit)) + " kcal");
        System.out.println("Umgerechnete Portionsgröße: " + avocado.umrechnenPortionsgroesse(portionsgroesse, einheit) + " g");

        System.out.println();

        System.out.println("Hühnerbrust - Portionsgröße: " + portionsgroesse + " " + einheit);
        System.out.println("Kalorien: " + chickenBreast.berechneKalorien(chickenBreast.umrechnenPortionsgroesse(portionsgroesse, einheit)) + " kcal");
        System.out.println("Umgerechnete Portionsgröße: " + chickenBreast.umrechnenPortionsgroesse(portionsgroesse, einheit) + " g");

        // Beispiel-Überprüfung der Gültigkeit der Nährwertangaben
        System.out.println("Sind die Nährwertangaben für die Avocado gültig? " + avocado.istGueltig());
        System.out.println("Sind die Nährwertangaben für die Hühnerbrust gültig? " + chickenBreast.istGueltig());


        Aktivitat football = new Aktivitat(true,"football", LocalDate.now(),35);
        // Beispiel-Scanner-Objekt zum Einlesen von Benutzereingaben
        // Benutzereingabe für Portionsgröße und Einheit
        System.out.print("Bitte geben Sie SportArt: ");
        String sportArt = scanner.nextLine();
        scanner.nextLine(); // Zeilenumbruch lesen, um den Scanner zu leeren
        System.out.print("Bitte geben Sie Dauer: ");
        int dauer = scanner.nextInt();

        // Beispiel-Ausgabe der berechneten Kalorien und umgerechneten Portionsgröße
        System.out.println("SportArt: " + sportArt + " fur " + dauer +"min");

        System.out.println();

    }
}

