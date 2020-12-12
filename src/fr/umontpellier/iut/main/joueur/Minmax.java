package fr.umontpellier.iut.main.joueur;

import fr.umontpellier.iut.main.model.Couleurs;

public class Minmax extends Joueur{

    private int taille;

    public Minmax(Couleurs couleur) {
        super(couleur);
    }

    public Couleurs getCouleur() { return super.getCouleur(); }


}
