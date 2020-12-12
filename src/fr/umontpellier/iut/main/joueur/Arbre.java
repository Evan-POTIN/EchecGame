package fr.umontpellier.iut.main.joueur;

import java.util.ArrayList;

public class Arbre {

    private int valeurCoup;
    private ArrayList<Arbre> fils;

    public Arbre() {}

    public int getValeurCoup() {
        return valeurCoup;
    }

    public ArrayList<Arbre> getFils() {
        return fils;
    }
}
