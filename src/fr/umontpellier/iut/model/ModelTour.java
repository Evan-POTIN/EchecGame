package fr.umontpellier.iut.model;

public class ModelTour extends ModelPiece {

    private static final int valeur = 5;

    public ModelTour(Couleurs clr) {
        super(clr);
    }

    public String toString() {
        return clr == Couleurs.BLANC ? "T" :  "t";
    }
}
