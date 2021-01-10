package fr.umontpellier.iut.test;

import fr.umontpellier.iut.main.model.ModelCase;
import fr.umontpellier.iut.main.model.ModelEchiquier;
import fr.umontpellier.iut.main.model.ModelRoi;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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

    @Test
    public void testGetPiecesBlanc() {
        echiquierRef.setRoiTour();
        ArrayList<ModelCase> piecesBlanches = echiquierRef.getPiecesBlanc();

        ArrayList<ModelCase> pb = new ArrayList<>();
        pb.add(echiquierRef.getCase(0,3));
        pb.add(echiquierRef.getCase(2,1));

        assertEquals(pb, piecesBlanches);

        echiquierRef.getCase(0,3).setPiece(null);
        pb.remove(0);

        piecesBlanches = echiquierRef.getPiecesBlanc();

        assertEquals(pb, piecesBlanches);
    }

}
