package fr.umontpellier.iut.model;

import java.util.ArrayList;

public class ModelTour extends ModelPiece {

    private static final int valeur = 5;

    public ModelTour(Couleurs clr, ModelEchiquier plateau) {
        super(clr, plateau);
    }

    public String toString() {
        return clr == Couleurs.BLANC ? "T" : "t";
    }

    public ArrayList<ModelCase> casesPossible(int x, int y) {

        /**
         * @Param: Coordonnées de la pièce
         * @Return: Liste de cases valables pour déplacement
         */

        ArrayList<ModelCase> cases = new ArrayList<>();

        for(int plusX = x+1 ; plusX < 8 ; plusX++ ){
            if(plateau.getCase(plusX,y).estVide() || plateau.getCase(plusX,y).getPiece().clr != this.clr ){
                cases.add(plateau.getCase(plusX, y));

                if(!plateau.getCase(plusX,y).estVide()) {
                    break;
                }
            }
        }

        for (int moinsX = x ; moinsX >= 0 ; moinsX-- ){
            if(plateau.getCase(moinsX, y).estVide() || plateau.getCase(moinsX, y).getPiece().clr != this.clr ){
                cases.add(plateau.getCase(moinsX,y));

                if(!plateau.getCase(moinsX,y).estVide()) {
                    break;
                }
            }

        }

        for (int plusY = y ; plusY < 8 ; plusY++ ){
            if(plateau.getCase(x, plusY).estVide() || plateau.getCase(x, plusY).getPiece().clr != this.clr ){
                cases.add(plateau.getCase(x, plusY));

                if(!plateau.getCase(x,plusY).estVide()) {
                    break;
                }
            }
        }

        for (int moinsY = y ; moinsY >= 8 ; moinsY-- ){
            if(plateau.getCase(x, moinsY).estVide() || plateau.getCase(x, moinsY).getPiece().clr != this.clr ){
                cases.add(plateau.getCase(x, moinsY));

                if(!plateau.getCase(x,moinsY).estVide()) {
                    break;
                }
            }
        }

        return cases;
    }

}
