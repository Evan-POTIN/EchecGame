package fr.umontpellier.iut.main.joueur;

import fr.umontpellier.iut.main.model.ModelCase;
import fr.umontpellier.iut.main.model.ModelEchiquier;

import java.util.ArrayList;

public class Arbre {

    private final ModelEchiquier coup;
    private int valeurCoup;
    private ArrayList<Arbre> fils;

    public Arbre(ModelEchiquier me) {coup = me; fils = new ArrayList<>(); valeurCoup = Integer.MIN_VALUE; }

    public ModelEchiquier getCoup() {
        return coup;
    }

    public void setValeurCoup(int vc) { valeurCoup = vc;}

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

        Arbre a = fils.get(0);

        for(Arbre fils : fils) {
            if(fils.getValeurCoup() == eval) {
                a = fils;
                break;
            }
        }
        return a;
    }
}
