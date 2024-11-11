package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {
    private Einahmen einahmen = new Einahmen();
    private Ausgaben ausgaben = new Ausgaben();
    Scanner input = new Scanner(System.in);

    public void enty() {
        MainMenu main = new MainMenu();
        main.asciart();
        main.start();
    }

    public void asciart() {
        System.out.println(" ______   __     __   __     ______     __   __     ______     __    __     ______     __   __     ______     ______     ______     ______    ");
        System.out.println("/\\  ___\\ /\\ \\   /\\ \"-.\\ \\   /\\  __ \\   /\\ \"-.\\ \\   /\\___  \\   /\\ \"-./  \\   /\\  __ \\   /\\ \"-.\\ \\   /\\  __ \\   /\\  ___\\   /\\  ___\\   /\\  == \\   ");
        System.out.println("\\ \\  __\\ \\ \\ \\  \\ \\ \\-.  \\  \\ \\  __ \\  \\ \\ \\-.  \\  \\/_/  /__  \\ \\ \\-./\\ \\  \\ \\  __ \\  \\ \\ \\-.  \\  \\ \\  __ \\  \\ \\ \\__ \\  \\ \\  __\\   \\ \\  __<   ");
        System.out.println(" \\ \\_\\    \\ \\_\\  \\ \\_\\\"\\_\\  \\ \\_\\ \\_\\  \\ \\_\\\"\\_\\   /\\_____\\  \\ \\_\\ \\ \\_\\  \\ \\_\\ \\_\\  \\ \\_\\\"\\_\\  \\ \\_\\ \\_\\  \\ \\_____\\  \\ \\_____\\  \\ \\_\\ \\_\\ ");
        System.out.println("  \\/_/     \\/_/   \\/_/ \\/_/   \\/_/\\/_/   \\/_/ \\/_/   \\/_____/   \\/_/  \\/_/   \\/_/\\/_/   \\/_/ \\/_/   \\/_/\\/_/   \\/_____/   \\/_____/   \\/_/ /_/ ");
        System.out.println("  ");
        System.out.println("  ");
        System.out.println("  ");
    }

    public void start() {
        MainMenu mainmenu = new MainMenu();
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Wähle deine Option");
            // In Einahmen und Ausgaben Können wir die einahmen/ausgaben defenieren & kosten
            // Was noch wichtig wäre ist was alles von denn einahmen gekommen ist
            // und von den ausgaben abgebucht
            System.out.println("[E] - Einahmen");
            System.out.println("[A] - Ausgaben");
            // In der Statistik sehen wir alles ein
            System.out.println("[S] - Statistik");
            System.out.println("[X] - Exit");
            //Userinput und machen es Groß
            String userInput = input.nextLine();
            switch (userInput.toUpperCase()) {
                case "E":
                    einahmeausgabefenster("Einahmen");
                    break;
                case "A":
                    einahmeausgabefenster("Ausgaben");
                    break;
                case "S":
                    break;
                case "X":
                    break;
            }
        }
    }

    public void entryEinahme()
    {
            //Userinput und machen es Groß
            String userInput = input.nextLine();
            switch (userInput.toUpperCase()) {
                case "H":
                    einahmen.setzeNeueEinahme(1,einahmen);
                    break;
                case "B":
                    einahmen.setzeNeueEinahme(2,einahmen);
                    break;
                case "S":
                    break;
                case "X":
                    break;
            }
    }

    public void entryAusgabe()
    {
        //Userinput und machen es Groß
        String userInput = input.nextLine();
        switch (userInput.toUpperCase()) {
            case "H":
                ausgaben.setzeNeueEinahme(1,ausgaben);
                break;
            case "B":
                ausgaben.setzeNeueEinahme(2,ausgaben);
                break;
            case "S":
                break;
            case "X":
                break;
        }
    }

    public void einahmeausgabefenster(String wahl) {
        while (true) {
            System.out.println("  ");
            System.out.println("  ");
            System.out.println("  ");
            System.out.println("  ");
            System.out.println("  ");
            System.out.println("  ");
            System.out.println("  ");
            System.out.println("  ");
            System.out.println("  ");
            if (wahl.equals("Einahmen")) {
                ArrayList<String> einahmenList = einahmen.getEinahmenListe();
                System.out.println("Einahmen:");
                for (int i = 0; i < einahmenList.size(); i++) {
                    System.out.println(i + "." + einahmenList.get(i));
                }
            } else {
                ArrayList<String> ausgabenListe = ausgaben.getEinahmenListe();
                System.out.println("Ausgaben:");
                for (int i = 0; i < ausgabenListe.size(); i++) {
                    System.out.println(i + "." + ausgabenListe.get(i));
                }
            }
            System.out.println("  ");
            System.out.println("  ");
            System.out.println("  ");
            System.out.println("  ");
            System.out.println("Was möchtest du tun?");
            System.out.println("[H] - Hinzufügen");
            System.out.println("[B] - Bearbeiten");
            // In der Statistik sehen wir alles ein
            System.out.println("[S] - Statistik");
            System.out.println("[X] - Exit");
            if (wahl.equals("Einahmen")) {
                entryEinahme();
            } else {
                entryAusgabe();
            }
        }
    }
}
