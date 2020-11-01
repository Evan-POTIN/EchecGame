package fr.umontpellier.iut.model;

import java.util.ArrayList;

public class ModelTour extends ModelPiece {

    private static final int valeur = 5;

    public ModelTour(Couleurs clr, ModelCase[][] plateau) {
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

        for(int plusX = x ; plusX < 8 ; plusX++ ){
            if(plateau[plusX][y].estVide() || plateau[plusX][y].getPiece().clr != this.clr ){
                cases.add(plateau[plusX][y]);
            }
        }

        for (int moinsX = x ; moinsX >= 0 ; moinsX-- ){
            if(plateau[moinsX][y].estVide() || plateau[moinsX][y].getPiece().clr != this.clr ){
                cases.add(plateau[moinsX][y]);
            }
        }

        for (int plusY = y ; plusY < 8 ; plusY++ ){
            if(plateau[x][plusY].estVide() || plateau[x][plusY].getPiece().clr != this.clr ){
                cases.add(plateau[x][plusY]);
            }
        }

        for (int moinsY = y ; moinsY >= 8 ; moinsY-- ){
            if(plateau[x][moinsY].estVide() || plateau[x][moinsY].getPiece().clr != this.clr ){
                cases.add(plateau[x][moinsY]);
            }
        }

        return cases;
    }

}
