package fr.umontpellier.iut.model;

import java.util.ArrayList;

public class ModelRoi extends ModelPiece {

    private static final int valeur = 100;

    public ModelRoi(Couleurs clr) {
        super(clr);
    }

    public String toString() {
        return clr == Couleurs.BLANC ? "R" : "r";
    }

    @Override
    public ArrayList<ModelCase> casesPossible(int x, int y) {
        ArrayList<ModelCase> cases = new ArrayList<>();

        if(x == 0 && y == 0) {
            // Si en haut à gauche
            if((ModelEchiquier.getCase(0, 1).estVide() || ModelEchiquier.getCase(0, 1).getPiece().getClr() != clr ) && !estEchec(0, 1))
                cases.add(ModelEchiquier.getCase(0, 1));

            if((ModelEchiquier.getCase(1, 1).estVide() || ModelEchiquier.getCase(1, 1).getPiece().getClr() != clr ) && !estEchec(1, 1))
                cases.add(ModelEchiquier.getCase(1, 1));

            if((ModelEchiquier.getCase(1, 0).estVide() || ModelEchiquier.getCase(1, 0).getPiece().getClr() != clr ) && !estEchec(1, 0))
                cases.add(ModelEchiquier.getCase(1, 0));
        }
        return cases;
    }

    public boolean estEchec(int x, int y) {
        return false;
    }


}