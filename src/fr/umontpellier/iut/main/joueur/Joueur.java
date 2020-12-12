package fr.umontpellier.iut.main.joueur;

import fr.umontpellier.iut.main.model.Couleurs;

public class Joueur {
    private Couleurs couleur;

    public Joueur(Couleurs couleur) {
        this.couleur = couleur;
    }

    public Couleurs getCouleur() {
        return couleur;
    }
}
