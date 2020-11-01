package fr.umontpellier.iut.model;

public class ModelEchiquier {
    private ModelCase[][] echiquier;

    public ModelEchiquier() {
        echiquier = new ModelCase[8][8];    // Initialisation de la matrice 8x8

        for(int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                echiquier[i][j] = new ModelCase(null, i, j);
            }
        }
    }

    public void setRoiTour() {
        echiquier[0][0].setPiece(new ModelRoi(Couleurs.BLANC, echiquier));
        echiquier[1][0].setPiece(new ModelTour(Couleurs.NOIR, echiquier));
        echiquier[5][3].setPiece(new ModelRoi(Couleurs.NOIR, echiquier));
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


}
