package fr.umontpellier.iut.main.joueur;

import fr.umontpellier.iut.main.model.ModelCase;
import fr.umontpellier.iut.main.model.ModelEchiquier;

import java.util.ArrayList;

public class Arbre {

    private final ModelEchiquier coup;
    private final int valeurCoup;
    private ArrayList<Arbre> fils;

    public Arbre(ModelEchiquier me, int vc) { coup = me; valeurCoup = vc; }

    public ModelEchiquier getCoup() {
        return coup;
    }

    public ArrayList<Arbre> getFils() {
        return fils;
    }

    public int getValeurCoup() {
        return valeurCoup;
    }

    public Arbre getFilsByEval(int eval) {

        /**
         * @Action : renvoie la 1er coup ayant comme evaluation la valeur passée en paramètre
         */

        int i=0;
        while(fils.get(i).getValeurCoup() < eval) {
            i++;
        }
        return fils.get(i);
    }

    public void addFils(ModelEchiquier me, int vc) {
        if(fils == null) {
            fils = new ArrayList<>();
            fils.add(new Arbre(me,vc));
        }
        else if(fils.isEmpty()) {
            fils.add(new Arbre(me,vc));
        }
        else {
            int i=0;
            while(vc <= fils.get(i).valeurCoup) {
                i++;
            }
            fils.add(i, new Arbre(me,vc));
        }
    }
}
