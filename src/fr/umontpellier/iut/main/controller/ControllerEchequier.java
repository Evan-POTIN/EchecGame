package fr.umontpellier.iut.main.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerEchequier implements Initializable {

    @FXML
    private GridPane fenetre;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("ControllerEchiquier");
        fenetre.setGridLinesVisible(true);

        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {
                Color color = (i+j) % 2 == 0 ? Color.WHITE : Color.BLACK;
                Rectangle rct = new Rectangle(500/8., 500/8., color);
                GridPane.setConstraints(rct, i, j);
                fenetre.getChildren().add(rct);
            }
        }
    }
}
