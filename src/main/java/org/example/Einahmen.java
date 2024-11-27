package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Einahmen {
    private String Name;
    private double Betrag;
    private boolean Angekommen;
    Scanner input = new Scanner(System.in);
    JsonJackson json = new JsonJackson();

    ArrayList<String> einahmenListe = new ArrayList<String>();

    public ArrayList<String> getEinahmenListe() {
        return einahmenListe;
    }

    public void setEinahmenListe(ArrayList<String> einahmenListe) {
        this.einahmenListe = einahmenListe;
    }

    // Parameterloser Konstruktor
    public Einahmen() {

    }

    public Einahmen(String Name,double Betrag,boolean Angekommen)
    {
        this.Name = Name;
        this.Betrag = Betrag;
        this.Angekommen = Angekommen;
    }

    public String toString() {
        return String.format("%-20s - %.2f€ - %-10s", Name, Betrag,Angekommen); // Name linksbündig und Betrag rechtsbündig
    }

    public void setEinahmenListeIndex(String object) {
      this.einahmenListe.add(object);
    }

    public Einahmen einahmeabfrage()
    {
        Einahmen einahmen = new Einahmen();
        //Schreiben denn namen der fixkoste
       System.out.println("Namen eingeben:");
       einahmen.setName(input.nextLine());

       System.out.println("Betrag");
       String temp = input.nextLine();
       einahmen.setBetrag(Integer.parseInt(temp));
       //Default immer false
       einahmen.setAngekommen(false);
       return einahmen;
    }

    public void bearbeiteliste(Einahmen einahmen) {
        // schaune erst mal ob die liste leer ist
        einahmenListe = einahmen.getEinahmenListe();
        if (einahmenListe.isEmpty())
        {
            System.out.println("Liste ist leer,Nix zu Bearbeiten");
        } else
        {
            System.out.println("Bitte Die Zahl auswählen");

            String temp = input.nextLine();
            int index = Integer.parseInt(temp);

            einahmen = einahmen.einahmeabfrage();
            einahmenListe.set(index,einahmen.toString());
            json.objectojson(einahmenListe,"Einahme");
        }
    }

    public void setzeNeueEinahme(int flag,Einahmen einahmen)
    {
        einahmenListe = einahmen.getEinahmenListe();
        //  Hinzufügen
        if (flag == 1)
        {
           einahmen = einahmen.einahmeabfrage();
           einahmenListe.add(new Einahmen(einahmen.getName(), einahmen.getBetrag(),einahmen.isAngekommen()).toString());
        }
        //Bearbeiten
        else if(flag == 2)
        {
            einahmen.bearbeiteliste(einahmen);
        }
        einahmen.setEinahmenListe(einahmenListe);
        json.objectojson(einahmenListe,"Einahme");
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

