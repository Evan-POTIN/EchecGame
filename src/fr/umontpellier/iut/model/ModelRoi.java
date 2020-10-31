package fr.umontpellier.iut.model;

public class ModelRoi extends ModelPiece {

    private static final int valeur = 100;

    public ModelRoi(Couleurs clr) {
        super(clr);
    }

    public String toString() {
        return clr == Couleurs.BLANC ? "R" : "r";
    }


}
