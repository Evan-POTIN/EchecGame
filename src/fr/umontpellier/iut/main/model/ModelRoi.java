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


    @Override
    public ArrayList<ModelCase> casesPossible(ArrayList<ModelCase> cases) {
        ArrayList<ModelCase> casePossible = new ArrayList<>();
        for (ModelCase c : cases ){
            if (!estEchec(c.getPosX(), c.getPosY()) && (c.estVide() || c.getPiece().getClr() != this.clr)){
                casePossible.add(c);
            }
        }
        return casePossible;
    }

    @Override
    public ArrayList<ModelCase> casesTheorique(int x, int y) {
        /**
         * @Param: Coordonnées de la pièce
         * @Return: Liste de cases valables pour déplacement
         */

        ArrayList<ModelCase> cases = new ArrayList<>();

        if (x - 1 >= 0) {
            // Si pas sur la 1ère ligne
            cases.add(plateau.getCase(x - 1, y));
            if (y - 1 >= 0) {
                cases.add(plateau.getCase(x - 1, y - 1));
            }
            if (y + 1 <= 7) {
                cases.add(plateau.getCase(x - 1, y + 1));
            }
        }
        if (x + 1 <= 7) {
            // Si pas sur la dernière ligne
            cases.add(plateau.getCase(x + 1, y));
            if (y - 1 >= 0) {
                cases.add(plateau.getCase(x + 1, y - 1));
            }
            if (y + 1 <= 7) {
                cases.add(plateau.getCase(x + 1, y + 1));
            }
        }
        if (y - 1 >= 0) {
            // Si pas sur la 1ère colonnz
            cases.add(plateau.getCase(x, y - 1));

        }
        if (y + 1 <= 7) {
            // Si pas sur dernière colonne
            cases.add(plateau.getCase(x, y + 1));
        }

        return cases;
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


    public boolean estEchec(int x, int y) {

        /**
         * @Param: Coordonnées de la pièce
         * @Return: True si roi en Echec sur plateau[x][y], False sinon
         */

        boolean echec = false;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (!plateau.getCase(i,j).estVide() && plateau.getCase(i,j).getPiece().getClr() != clr){
                    if (plateau.getCase(i,j).getPiece().casesTheorique(i,j).contains(plateau.getCase(x,y))){
                        echec = true;
                    }
                }
            }
        }
        return echec;
    }

    public boolean echecEtMat() {
        return this.estEchec(position[0], position[1]) && this.casesPossible(this.casesTheorique(position[0],position[1])).size() == 0;
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
