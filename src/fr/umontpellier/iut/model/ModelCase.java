package fr.umontpellier.iut.model;

public class ModelCase {
    private ModelPiece piece;
    private int posX, posY;

    public ModelCase(ModelPiece piece, int x, int y) {
        this.piece = piece;
        posX = x;
        posY = y;
    }

    public int[] getPos() {
        int[] coord = {posX, posY};
        return coord;
    }

    public void setPiece(ModelPiece p) {
        piece = p;
    }

    public String toString() {
        String s = "[";
        if(piece != null) {
            s += piece.toString();
        }
        s += "]";
        return s;
    }

    public boolean estVide() {
        return  this.piece == null;
    }


}
