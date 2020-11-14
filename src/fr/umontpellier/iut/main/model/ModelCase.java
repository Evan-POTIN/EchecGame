package fr.umontpellier.iut.main.model;


import java.util.ArrayList;

public class ModelCase {
    private ModelPiece piece;
    private int posX, posY;

    public ModelCase(ModelPiece piece, int x, int y) {
        this.piece = piece;
        posX = x;
        posY = y;
    }

    public ModelPiece getPiece() {
        return piece;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
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

    public boolean deplacerPiece(ModelCase dest) {

        ArrayList<ModelCase> coupsPossible = this.piece.casesPossible(this.piece.casesTheorique(posX, posY));

        if(coupsPossible.contains(dest)) {
            dest.setPiece(this.piece);
            this.setPiece(null);
            if (this.getPiece() != null && this.getPiece().getValeur() == 100){
                if (this.getPiece().getClr() == Couleurs.BLANC){
                    ((ModelRoi) this.getPiece()).setPosition(new int[]{dest.getPosX(),dest.getPosY()});
                }else {
                    ((ModelRoi) this.getPiece()).setPosition(new int[]{dest.getPosX(),dest.getPosY()});
                }
            }
            return true;
        } else {
            return false;
        }
    }


}
