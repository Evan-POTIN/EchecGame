package fr.umontpellier.iut.main.model;


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
        echiquier = e.getEchiquier();
        roiBlanc = e.getRoiBlanc();
        roiNoir = e.getRoiNoir();
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
        echiquier[0][3].setPiece(new ModelTour(Couleurs.BLANC, this));


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


}
