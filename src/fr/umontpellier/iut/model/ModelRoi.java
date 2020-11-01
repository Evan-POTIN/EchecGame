package fr.umontpellier.iut.model;

import java.util.ArrayList;

public class ModelRoi extends ModelPiece {

    private static final int valeur = 100;
    private boolean premierCoup = false;

    public ModelRoi(Couleurs clr, ModelEchiquier plateau) {
        super(clr, plateau);
    }

    public String toString() {
        return clr == Couleurs.BLANC ? "R" : "r";
    }

    @Override
    public ArrayList<ModelCase> casesPossible(int x, int y) {

        /**
         * @Param: Coordonnées de la pièce
         * @Return: Liste de cases valables pour déplacement
         */

        ArrayList<ModelCase> cases = new ArrayList<>();

        if(x-1 >= 0) {
            // Si pas sur la 1ère ligne
            cases.add(plateau.getCase(x-1, y));

            if(y-1 >= 0) {
                cases.add(plateau.getCase(x-1,y-1));
            }
            if(y+1 <= 7) {
                cases.add(plateau.getCase(x-1,y+1));
            }
        }
        if(x+1 <= 7) {
            // Si pas sur la dernière ligne
            cases.add(plateau.getCase(x+1, y));

            if(y-1 >= 0) {
                cases.add(plateau.getCase(x+1, y-1));
            }
            if(y+1 <= 7) {
                cases.add(plateau.getCase(x+1,y+1));
            }
        }
        if(y-1 >= 0) {
            // Si pas sur la 1ère colonne
            cases.add(plateau.getCase(x, y-1));

            if(x-1 >= 0) {
                cases.add(plateau.getCase(x-1,y-1));
            }
            if(x+1 <= 7) {
                cases.add(plateau.getCase(x+1,y-1));
            }
        }
        if(y+1 <= 7) {
            // Si pas sur dernière colonne
            cases.add(plateau.getCase(x,y+1));

            if(x-1 >= 0) {
                cases.add(plateau.getCase(x-1,y+1));
            }
            if(x+1 <= 7) {
                cases.add(plateau.getCase(x+1,y+1));
            }
        }
        return cases;
    }



    public boolean estEchec(int x, int y) {

        /**
         * @Param: Coordonnées de la pièce
         * @Return: True si roi en Echec sur plateau[x][y], False sinon
         */

        /*ArrayList<ModelCase> CasePlateau = new ArrayList<ModelCase>();
        for (int i = 0; i <9 ; i++) {
            for (int j = 0; j <9; j++) {
                CasePlateau.add(ModelEchiquier.getCase(i,j));
            }

        }
        if (){

        }

        else {
            return false;
        }*/
        return false;
    }


    public boolean isPremierCoup() {
        return premierCoup;
    }

    public void setPremierCoup(boolean premierCoup) {
        this.premierCoup = premierCoup;
    }
}
