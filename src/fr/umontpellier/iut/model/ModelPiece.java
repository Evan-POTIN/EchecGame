package fr.umontpellier.iut.model;

import java.util.ArrayList;

public abstract class ModelPiece {

    protected Couleurs clr;

    public ModelPiece(Couleurs clr) {
        this.clr = clr;
    }

    public Couleurs getClr() {
        return clr;
    }

    public ArrayList<ModelCase> casesPossible(int x, int y) {
        return null;
    }

}
