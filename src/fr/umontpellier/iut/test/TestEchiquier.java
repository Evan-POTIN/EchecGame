package fr.umontpellier.iut.test;

import fr.umontpellier.iut.main.model.ModelCase;
import fr.umontpellier.iut.main.model.ModelEchiquier;
import fr.umontpellier.iut.main.model.ModelRoi;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestEchiquier {

    private ModelEchiquier echiquierRef = new ModelEchiquier();

    @Test
    public void setEchiquier() {
        echiquierRef.setRoiTour();
        ModelEchiquier copie = new ModelEchiquier(echiquierRef);

        //System.out.println(echiquierRef.toString());
        //System.out.println(copie.toString());

        assertEquals(Arrays.deepToString(echiquierRef.getEchiquier()), Arrays.deepToString(copie.getEchiquier()));

        //System.out.println(copie.toString());
        copie.getCase(1,3).deplacerPiece(copie.getCase(4,3));
        //System.out.println(copie.toString());
        echiquierRef.setEchiquier(copie.getEchiquier());

        assertEquals(Arrays.deepToString(echiquierRef.getEchiquier()), Arrays.deepToString(copie.getEchiquier()));


    }

    @Test
    public void testGetPiecesBlanc() {
        echiquierRef.setRoiTour();
        ArrayList<ModelCase> piecesBlanches = echiquierRef.getPiecesBlanc();

        ArrayList<ModelCase> pb = new ArrayList<>();
        pb.add(echiquierRef.getCase(1,3));
        pb.add(echiquierRef.getCase(2,1));

        assertEquals(pb, piecesBlanches);

        echiquierRef.getCase(0,3).setPiece(null);
        pb.remove(0);

        piecesBlanches = echiquierRef.getPiecesBlanc();

        assertEquals(pb, piecesBlanches);
    }

    @Test
    public void testCopieEchiquier() {
        echiquierRef.setRoiTour();
        ModelEchiquier copie = new ModelEchiquier(echiquierRef);
        assertEquals(Arrays.deepToString(echiquierRef.getEchiquier()), Arrays.deepToString(copie.getEchiquier()));
    }

    @Test
    public void testGetRoi() {
        ModelRoi roiNoir = (ModelRoi) echiquierRef.getCase(0,0).getPiece();
        assertEquals(roiNoir, echiquierRef.getRoiNoir());
    }

}
