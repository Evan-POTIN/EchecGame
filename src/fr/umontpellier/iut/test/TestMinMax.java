package fr.umontpellier.iut.test;

import fr.umontpellier.iut.main.joueur.Minmax;
import fr.umontpellier.iut.main.model.Couleurs;
import fr.umontpellier.iut.main.model.ModelEchiquier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMinMax {

    private ModelEchiquier echiquierRef = new ModelEchiquier();

    @Test
    public void testEvaluer() {
        echiquierRef.setRoiTour();
        Minmax minmax = new Minmax(3, echiquierRef);
        assertEquals(1003, minmax.evaluerPosition(echiquierRef));

        echiquierRef.getCase(0,3).deplacerPiece(echiquierRef.getCase(1,3));

        assertEquals(2, minmax.evaluerPosition(echiquierRef));
    }
}
