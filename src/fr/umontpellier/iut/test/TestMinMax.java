package fr.umontpellier.iut.test;

import fr.umontpellier.iut.main.joueur.Arbre;
import fr.umontpellier.iut.main.joueur.Minmax;
import fr.umontpellier.iut.main.model.Couleurs;
import fr.umontpellier.iut.main.model.ModelEchiquier;
import fr.umontpellier.iut.main.model.ModelRoi;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMinMax {

    private ModelEchiquier echiquierRef = new ModelEchiquier();

    @Test
    public void testEvaluer() {
        echiquierRef.setRoiTour();
        Minmax minmax = new Minmax(3);
        assertEquals(1003, minmax.evaluerPosition(echiquierRef));

        echiquierRef.getCase(0,3).deplacerPiece(echiquierRef.getCase(1,3));

        assertEquals(2, minmax.evaluerPosition(echiquierRef));
    }


    @Test
    public void testGenererFils() {
        echiquierRef.setRoiTour();
        echiquierRef.getCase(0, 3).setPiece(null);   // Suppression de la tour pour faciliter le test
        Minmax minmax = new Minmax(1);

        System.out.println(echiquierRef);

        Arbre filsGen = minmax.genererFils(echiquierRef);   // Génération des fils

        // Création des fils en dur pour la comparaison avec la génération
        Arbre fils = new Arbre(echiquierRef, minmax.evaluerPosition(echiquierRef));

        ModelEchiquier f1 = new ModelEchiquier(echiquierRef);
        f1.getCase(2,1).deplacerPiece(f1.getCase(2,0));
        ModelEchiquier f2 = new ModelEchiquier(echiquierRef);
        f2.getCase(2,1).deplacerPiece(f2.getCase(3,0));
        ModelEchiquier f3 = new ModelEchiquier(echiquierRef);
        f3.getCase(2,1).deplacerPiece(f3.getCase(3,1));
        ModelEchiquier f4 = new ModelEchiquier(echiquierRef);
        f4.getCase(2,1).deplacerPiece(f4.getCase(3,2));
        ModelEchiquier f5 = new ModelEchiquier(echiquierRef);
        f5.getCase(2,1).deplacerPiece(f5.getCase(2,2));
        ModelEchiquier f6 = new ModelEchiquier(echiquierRef);
        f6.getCase(2,1).deplacerPiece(f6.getCase(1,2));

        fils.addFils(f1, minmax.evaluerPosition(f1));
        fils.addFils(f2, minmax.evaluerPosition(f2));
        fils.addFils(f3, minmax.evaluerPosition(f3));
        fils.addFils(f4, minmax.evaluerPosition(f4));
        fils.addFils(f5, minmax.evaluerPosition(f5));
        fils.addFils(f6, minmax.evaluerPosition(f6));

        assertEquals(fils, filsGen);
    }
}
