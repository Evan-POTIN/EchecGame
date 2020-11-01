package fr.umontpellier.iut.model;

import java.util.ArrayList;

public abstract class ModelPiece {

    private int valeur;
    protected Couleurs clr;
    protected ModelEchiquier plateau;    // Référence du plateau pour calculer les coups possibles

    public ModelPiece(Couleurs clr, ModelEchiquier echiquier) {
        this.clr = clr;
        plateau = echiquier;
    }

    public Couleurs getClr() {
        return clr;
    }

    public ArrayList<ModelCase> casesPossible(int x, int y) {
        return null;
    }

    public int getValeur() {
        return  valeur;
    }

}
