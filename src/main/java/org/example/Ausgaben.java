package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Ausgaben {
    private String Name;
    private double Betrag;
    private boolean Angekommen;
    Scanner input = new Scanner(System.in);
    JsonJackson json = new JsonJackson();
    ArrayList<String> ausgabenListe = new ArrayList<String>();

    public ArrayList<String> getEinahmenListe() {
        return ausgabenListe;
    }

    public void setEinahmenListe(ArrayList<String> ausgabenListe) {
        this.ausgabenListe = ausgabenListe;
    }

    // Parameterloser Konstruktor
    public Ausgaben() {

    }

    public Ausgaben(String Name,double Betrag,boolean Angekommen)
    {
        this.Name = Name;
        this.Betrag = Betrag;
        this.Angekommen = Angekommen;
    }

    public String toString() {
        return String.format("%-20s - %.2f€ - %-10s", Name, Betrag,Angekommen); // Name linksbündig und Betrag rechtsbündig
    }

    public Ausgaben ausgabenAbfrage()
    {
        Ausgaben ausgaben = new Ausgaben();
        //Schreiben denn namen der fixkoste
        System.out.println("Namen eingeben:");
        ausgaben.setName(input.nextLine());

        System.out.println("Betrag");
        String temp = input.nextLine();
        ausgaben.setBetrag(Integer.parseInt(temp));
        //Default immer false
        ausgaben.setAngekommen(false);
        return ausgaben;
    }

    public void bearbeiteliste(Ausgaben ausgaben) {
        // schaune erst mal ob die liste leer ist
        ausgabenListe = ausgaben.getEinahmenListe();
        if (ausgabenListe.isEmpty())
        {
            System.out.println("Liste ist leer,Nix zu Bearbeiten");
        } else
        {
            System.out.println("Bitte Die Zahl auswählen");

            String temp = input.nextLine();
            int index = Integer.parseInt(temp);

            ausgaben = ausgaben.ausgabenAbfrage();
            ausgabenListe.set(index,ausgaben.toString());
            json.objectojson(ausgabenListe,"Ausgabe");
        }
    }

    public void setzeNeueEinahme(int flag,Ausgaben ausgaben)
    {
        ausgabenListe = ausgaben.getEinahmenListe();
        //  Hinzufügen
        if (flag == 1)
        {
            ausgaben = ausgaben.ausgabenAbfrage();
            ausgabenListe.add(new Einahmen(ausgaben.getName(), ausgaben.getBetrag(),ausgaben.isAngekommen()).toString());
        }
        //Bearbeiten
        else if(flag == 2)
        {
            ausgaben.bearbeiteliste(ausgaben);
        }
        ausgaben.setEinahmenListe(ausgabenListe);
        json.objectojson(ausgabenListe,"Ausgabe");
    }

    public boolean isAngekommen() {
        return Angekommen;
    }

    public void setAngekommen(boolean angekommen) {
        Angekommen = angekommen;
    }

    public double getBetrag() {
        return Betrag;
    }

    public void setBetrag(double betrag) {
        Betrag = betrag;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
