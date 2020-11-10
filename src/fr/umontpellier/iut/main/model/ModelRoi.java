package fr.umontpellier.iut.main.model;

import java.util.ArrayList;

public class ModelRoi extends ModelPiece {

    private final int valeur = 100;
    private boolean premierCoup = false;
    private int[] position;

    public ModelRoi(Couleurs clr, ModelEchiquier plateau, int[] position) {

        super(clr, plateau);
        this.position = position;
    }

    public int[] getPosition() {
        return position;
    }

    public void setPosition(int[] position) {
        this.position = position;
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
            if(!estEchec(x-1, y)) {
                cases.add(plateau.getCase(x-1, y));
            }

            if(y-1 >= 0) {
                if(!estEchec(x-1, y-1)) {
                    cases.add(plateau.getCase(x-1,y-1));
                }
            }
            if(y+1 <= 7) {
                if(!estEchec(x-1, y+1)) {
                    cases.add(plateau.getCase(x-1,y+1));
                }
            }
        }
        if(x+1 <= 7) {
            // Si pas sur la dernière ligne
            if(!estEchec(x+1, y)) {

                cases.add(plateau.getCase(x+1, y));
            }


            if(y-1 >= 0) {
                if(!estEchec(x+1, y-1)) {
                    cases.add(plateau.getCase(x+1, y-1));
                }
            }
            if(y+1 <= 7) {
                if(!estEchec(x+1, y+1)) {
                    cases.add(plateau.getCase(x+1,y+1));
                }
            }
        }
        if(y-1 >= 0) {
            // Si pas sur la 1ère colonne
            if(!estEchec(x, y-1)) {
                cases.add(plateau.getCase(x, y-1));
            }

        }
        if(y+1 <= 7) {
            // Si pas sur dernière colonne
            if(!estEchec(x, y+1)) {
                System.out.println("messonge");
                cases.add(plateau.getCase(x,y+1));
            }
        }

        return cases;
    }



    public boolean estEchec(int x, int y) {

        /**
         * @Param: Coordonnées de la pièce
         * @Return: True si roi en Echec sur plateau[x][y], False sinon
         */

        boolean echec = false;

        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if (!plateau.getCase(i,j).estVide() && plateau.getCase(i,j).getPiece().getValeur() == 100){
                    int a = i;
                    int b = y;
                    if (((x == a-1 && y == b) || (x == a-1 && y == b-1) || (x == a-1 && y == b+1)|| (x == a && y == b-1)|| (x == a && y == b+1)|| (x == a+1 && y == b-1)|| (x == a+1 && y == b)|| (x == a+1 && y == b+1))){
                        echec = true;
                    }
                }
                else if(!plateau.getCase(i,j).estVide() && plateau.getCase(i,j).getPiece().getClr() != clr && plateau.getCase(i,j).getPiece().getValeur() != 100) {
                    if(plateau.getCase(i,j).getPiece().casesPossible(i,j).contains(plateau.getCase(x,y))) {
                        echec = true;
                        System.out.println("bbb");
                    }
                }
            }
        }
        return echec;
    }

    public boolean echecEtMat(){
        return this.estEchec(position[0], position[1]) && this.casesPossible(position[0],position[1]).size() == 0;
    }
    public boolean isPremierCoup() {
        return premierCoup;
    }

    public void setPremierCoup(boolean premierCoup) {
        this.premierCoup = premierCoup;
    }

    @Override
    public int getValeur() {
        return valeur;
    }
}
