package fr.umontpellier.iut.model;

public class ModelEchiquier {
    private ModelCase[][] echiquier;

    public ModelEchiquier() {
        echiquier = new ModelCase[8][8];    // Initialisation de la matrice 8x8

        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                echiquier[i][j] = new ModelCase(null, i, j);
            }
        }
        echiquier[0][0].setPiece(new ModelRoi());
        echiquier[1][0].setPiece(new ModelTour());
        echiquier[5][3].setPiece(new ModelRoi());
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

}
