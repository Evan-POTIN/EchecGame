package fr.umontpellier.iut.test;

import fr.umontpellier.iut.main.model.ModelEchiquier;
import fr.umontpellier.iut.main.model.ModelRoi;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestEchiquier {

    private ModelEchiquier echiquierRef = new ModelEchiquier();

    @Test
    public void setEchiquier() {
        echiquierRef.setRoiTour();
        ModelEchiquier copie = new ModelEchiquier(echiquierRef);
        assertEquals(echiquierRef.getEchiquier(), copie.getEchiquier());

        copie.getCase(0,3).deplacerPiece(copie.getCase(1,3));
        echiquierRef.setEchiquier(copie.getEchiquier());
        assertEquals(echiquierRef.getEchiquier(), copie.getEchiquier());
        //System.out.println(echiquierRef.toString());
    }

}
