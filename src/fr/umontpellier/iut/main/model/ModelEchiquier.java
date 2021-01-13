package fr.umontpellier.iut.main.model;


import java.util.ArrayList;

public class ModelEchiquier {
    private ModelCase[][] echiquier;
    private ModelRoi roiBlanc;
    private ModelRoi roiNoir;

    public ModelEchiquier() {
        echiquier = new ModelCase[8][8];    // Initialisation de la matrice 8x8

        for(int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                echiquier[i][j] = new ModelCase(null, i, j);
            }
        }
    }

    public ModelEchiquier(ModelEchiquier e) {
        echiquier = new ModelCase[8][8];

        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {

                if(!e.getCase(i,j).estVide()) {
                    if(e.getCase(i,j).getPiece().getValeur() == 100) {
                        if(e.getCase(i,j).getPiece().getClr() == Couleurs.BLANC) {
                            echiquier[i][j] = new ModelCase(new ModelRoi(Couleurs.BLANC, this, e.getRoiBlanc().getPosition()), i,j);
                            roiBlanc = (ModelRoi) echiquier[i][j].getPiece();
                        }
                        else {
                            echiquier[i][j] = new ModelCase(new ModelRoi(Couleurs.NOIR, this, e.getRoiNoir().getPosition()), i,j);
                            roiNoir = (ModelRoi) echiquier[i][j].getPiece();
                        }
                    }
                    else {
                        echiquier[i][j] = new ModelCase(new ModelTour(Couleurs.BLANC, this), i, j);
                    }
                }
                else {
                    echiquier[i][j] = new ModelCase(null, i, j);
                }
            }
        }
    }

    public ModelCase[][] getEchiquier() {
        return echiquier;
    }

    public ModelRoi getRoiBlanc() {
        return roiBlanc;
    }

    public ModelRoi getRoiNoir() {
        return roiNoir;
    }

    public void setRoiTour() {
        echiquier[2][1].setPiece(new ModelRoi(Couleurs.BLANC, this, new int[]{2, 1}));
        roiBlanc = (ModelRoi)echiquier[2][1].getPiece();
        echiquier[1][3].setPiece(new ModelTour(Couleurs.BLANC, this));


        echiquier[0][0].setPiece(new ModelRoi(Couleurs.NOIR, this, new int[]{0, 0}));
        roiNoir = (ModelRoi)echiquier[0][0].getPiece();
    }

    public String toString() {
        StringBuilder s = new StringBuilder();

        for(int i=0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                s.append(echiquier[i][j].toString());
                s.append("\t");
            }
            s.append("\n");
        }
        return s.toString();
    }

    public ModelCase getCase(int x, int y) {
        return echiquier[x][y];
    }

    public void setEchiquier(ModelCase[][] mc) { echiquier = mc; }

    public ArrayList<ModelCase> getPiecesBlanc() {
        ArrayList<ModelCase> pieces = new ArrayList<>();

        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {
                if(!getCase(i,j).estVide() && echiquier[i][j].getPiece().getClr() == Couleurs.BLANC) {
                    pieces.add(echiquier[i][j]);
                }
            }
        }
        return pieces;
    }

    public ArrayList<ModelCase> getPiecesNoir() {
        ArrayList<ModelCase> pieces = new ArrayList<>();

        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {
                if(!getCase(i,j).estVide() && echiquier[i][j].getPiece().getClr() == Couleurs.NOIR) {
                    pieces.add(echiquier[i][j]);
                }
            }
        }
        return pieces;
    }

}
