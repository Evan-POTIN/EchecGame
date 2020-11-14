package fr.umontpellier.iut.main.model;

import com.sun.webkit.Timer;

import java.util.ArrayList;

public class ModelTour extends ModelPiece {

    private static final int valeur = 5;

    public ModelTour(Couleurs clr, ModelEchiquier plateau) {
        super(clr, plateau);
    }


    public String toString() {
        return clr == Couleurs.BLANC ? "T" : "t";
    }

    @Override
    public ArrayList<ModelCase> casesTheorique(int x, int y) {

        /**
         * @Param: Coordonnées de la pièce
         * @Return: Liste de cases valables pour déplacement
         */

        ArrayList<ModelCase> cases = new ArrayList<>();

        for (int plusX = x + 1; plusX < 8; plusX++) {

            cases.add(plateau.getCase(plusX, y));
            if (!plateau.getCase(plusX, y).estVide()) {
                break;
            }
        }


        for (int moinsX = x - 1; moinsX >= 0; moinsX--) {

            cases.add(plateau.getCase(moinsX, y));
            if (!plateau.getCase(moinsX, y).estVide()) {
                break;
            }
        }


        for (int plusY = y + 1; plusY < 8; plusY++) {
            cases.add(plateau.getCase(x, plusY));
            if (!plateau.getCase(x, plusY).estVide()) {
                break;
            }
        }


        for (int moinsY = y - 1; moinsY >= 0; moinsY--) {
            cases.add(plateau.getCase(x, moinsY));
            if (!plateau.getCase(x, moinsY).estVide()) {
                break;
            }
        }


        return cases;
    }

    @Override
    public ArrayList<ModelCase> casesPossible(ArrayList<ModelCase> cases) {
        ArrayList<ModelCase> casePossible = new ArrayList<>();
        for (ModelCase c : cases) {
            if (c.estVide() || c.getPiece().getClr() != clr) {
                casePossible.add(c);
            }
        }
        return casePossible;
    }

}
