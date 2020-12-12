package fr.umontpellier.iut.main.joueur;

import fr.umontpellier.iut.main.model.ModelEchiquier;

import java.util.ArrayList;

public class Arbre {

    private ModelEchiquier coup;
    private int valeurCoup;
    private ArrayList<Arbre> fils;

    public Arbre(ModelEchiquier me, int vc) { coup = me; valeurCoup = vc; }

    public ModelEchiquier getCoup() {
        return coup;
    }

    public ArrayList<Arbre> getFils() {
        return fils;
    }

    public void addFils(ModelEchiquier me, int vc) {
        if(fils.isEmpty()) {
            fils.add(new Arbre(me,vc));
        }
        else {
            int i=0;
            while(vc <= fils.get(i).valeurCoup || i < fils.size()) {
                i++;
            }
            fils.add(new Arbre(me,vc));
        }
    }
}
