package fr.umontpellier.iut.main.model;

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

    public abstract ArrayList<ModelCase> casesPossible(ArrayList<ModelCase> c) ;

    public abstract ArrayList<ModelCase> casesTheorique(int x, int y) ;

    public int getValeur() {
        return  valeur;
    }
}
