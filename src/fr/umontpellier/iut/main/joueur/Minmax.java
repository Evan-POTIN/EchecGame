package fr.umontpellier.iut.main.joueur;

import fr.umontpellier.iut.main.model.Couleurs;
import fr.umontpellier.iut.main.model.ModelCase;
import fr.umontpellier.iut.main.model.ModelEchiquier;
import fr.umontpellier.iut.main.model.ModelPiece;

import java.util.ArrayList;

public class Minmax {

    int taille;

    public Minmax(int taille) { this.taille = taille; }

    public int evaluerPosition(ModelEchiquier me) {

        /**
         * @action: evalue une position donné et lui donne une valeur numérique
         * @param: le ModelEchiquier à evaluer
         * @return: un entier
         *
         *      Plus la valeur retournée est grande et plus le joueur blanc est avantagé
         *      Plus la valeur retournée est petite et plus le joueur noir est avantagé
         */


        int eval = 0;

        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {

                // Si la pièce est blanche on ajoute sa valeur sinon on soustrait
                if(!me.getCase(i,j).estVide()) {
                    eval += (me.getCase(i,j).getPiece().getClr() == Couleurs.BLANC)
                            ? me.getCase(i,j).getPiece().getValeur()
                            : -me.getCase(i,j).getPiece().getValeur();
                }
            }
        }

        // On soustrait la distance entre les 2 rois
        eval += Math.abs(me.getRoiBlanc().getPosition()[0] - me.getRoiNoir().getPosition()[0])
                + Math.abs(me.getRoiBlanc().getPosition()[1] - me.getRoiNoir().getPosition()[1]);


        // Modificateur de 100 si le roi est en echec
        if(me.getRoiNoir().estEchec(me.getRoiNoir().getPosition()[0], me.getRoiNoir().getPosition()[1])) {
            eval += 100;
        }
        if(me.getRoiBlanc().estEchec(me.getRoiBlanc().getPosition()[0], me.getRoiBlanc().getPosition()[1])) {
            eval -= 100;
        }

        // Modificateur de 900 si Mat, combiné avec celui d'echec cela fait 1000
        if(me.getRoiNoir().echecEtMat()) { eval += 900; }
        if(me.getRoiBlanc().echecEtMat()) { eval -= 900; }


        // Retranche le nombre de cases où le roi noir peut se déplacer
        eval -= me.getRoiNoir().casesPossible(me.getRoiNoir().casesTheorique(me.getRoiNoir().getPosition()[0],me.getRoiNoir().getPosition()[1])).size();

        // Ajoute le nombre de case où le roi blanc peut se déplacer
        // eval += me.getRoiBlanc().casesPossible(me.getRoiBlanc().casesTheorique(me.getRoiBlanc().getPosition()[0],me.getRoiBlanc().getPosition()[1])).size();

        return eval;
    }


    public Arbre genererFils(Arbre me, boolean jBlanc) {
        ArrayList<ModelCase> pieces = (jBlanc) ? me.getCoup().getPiecesBlanc() : me.getCoup().getPiecesNoir();

        for(ModelCase p : pieces) {
            ArrayList<ModelCase> casesPossible = p.getPiece().casesPossible(p.getPiece().casesTheorique(p.getPosX(), p.getPosY()));

            for(ModelCase cp : casesPossible) {
                ModelEchiquier nouvellePos = new ModelEchiquier(me.getCoup());
                nouvellePos.getCase(p.getPosX(), p.getPosY()).deplacerPiece(nouvellePos.getCase(cp.getPosX(), cp.getPosY()));

                me.getFils().add(new Arbre(nouvellePos));
            }
        }
        return me;
    }


    public int minmax(Arbre me, int profondeur, boolean jBlanc) {
        Arbre abr = genererFils(me, jBlanc);

        if(profondeur == 0 || me.getCoup().getRoiNoir().echecEtMat() || me.getCoup().getRoiBlanc().echecEtMat()) {
            return evaluerPosition(abr.getCoup());
        }
        else if(jBlanc) {
            int maxEval = Integer.MIN_VALUE;

            for(Arbre fils : abr.getFils()) {
                int eval = minmax(fils, profondeur-1, false);
                maxEval = Math.max(maxEval, eval);
            }
            return maxEval;
        }
        else {
            int minEval = Integer.MAX_VALUE;

            for(Arbre fils : abr.getFils()) {
                int eval = minmax(fils, profondeur-1, true);
                minEval = Math.min(minEval, eval);
            }
            return minEval;
        }
    }

    public ModelEchiquier jouerCoup(ModelEchiquier me) {
        Arbre abr = new Arbre(me);
        return abr.getFilsByEval(minmax(abr, taille, true)).getCoup();
    }

}
