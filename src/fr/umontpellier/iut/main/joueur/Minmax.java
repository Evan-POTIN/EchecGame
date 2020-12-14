package fr.umontpellier.iut.main.joueur;

import fr.umontpellier.iut.main.model.Couleurs;
import fr.umontpellier.iut.main.model.ModelCase;
import fr.umontpellier.iut.main.model.ModelEchiquier;

public class Minmax extends Joueur{

    private int taille;

    public Minmax(Couleurs couleur) {
        super(couleur);
    }

    public Couleurs getCouleur() { return super.getCouleur(); }

    public int evaluerPosition(ModelEchiquier me) {
        int eval = 0;

        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {

                // Si la pièce est blanche on ajoute sa valeur sinon on soustrait
                eval += (!me.getCase(i,j).estVide() && me.getCase(i,j).getPiece().getClr() == Couleurs.BLANC)
                        ? me.getCase(i,j).getPiece().getValeur()
                        : -me.getCase(i,j).getPiece().getValeur();
            }
        }

        // On soustrait la distance entre les 2 rois
        eval -= Math.abs(me.getRoiBlanc().getPosition()[0] - me.getRoiNoir().getPosition()[0])
                + Math.abs(me.getRoiBlanc().getPosition()[1] - me.getRoiNoir().getPosition()[1]);

        return eval;
    }

}
