package fr.umontpellier.iut.model;

public class ModelTour extends ModelPiece {

    private static final int valeur = 5;

    public ModelTour(Couleurs clr, ModelCase[][] plateau) {
        super(clr, plateau);
    }

    public String toString() {
        return clr == Couleurs.BLANC ? "T" : "t";
    }
}
