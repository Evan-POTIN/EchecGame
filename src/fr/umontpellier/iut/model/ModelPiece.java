package fr.umontpellier.iut.model;

import java.util.ArrayList;

public abstract class ModelPiece {

    protected Couleurs clr;
    protected ModelCase[][] plateau;    // Référence du plateau pour calculer les coups possibles

    public ModelPiece(Couleurs clr, ModelCase[][] echiquier) {
        this.clr = clr;
        plateau = echiquier;
    }

    public Couleurs getClr() {
        return clr;
    }

    public ArrayList<ModelCase> casesPossible(int x, int y) {
        return null;
    }

}
