package fr.umontpellier.iut.test;

import fr.umontpellier.iut.main.model.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

public class TestPieces {

    private ModelEchiquier echiquierTest = new ModelEchiquier();

    @Test
    public void testRoiEchec() {
        echiquierTest.setRoiTour();
        ModelRoi roi = (ModelRoi) echiquierTest.getCase(0, 0).getPiece();

        assertTrue(roi.estEchec(0, 0));
    }
}
