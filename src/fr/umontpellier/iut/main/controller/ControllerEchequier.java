package fr.umontpellier.iut.main.controller;

import fr.umontpellier.iut.main.model.ModelEchiquier;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerEchequier implements Initializable {

    @FXML
    private GridPane viewEchiquier;

    private ModelEchiquier modelEchiquier;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("ControllerEchiquier");
        modelEchiquier = new ModelEchiquier();
        modelEchiquier.setRoiTour();
        System.out.println(modelEchiquier.toString());
        //viewEchiquier.setGridLinesVisible(true);

        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {

                ControllerCase cc = new ControllerCase(modelEchiquier.getCase(i,j));

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("./../view/ViewCase.fxml"));
                //loader.setController(cc);

                try {
                    Rectangle rct = (Rectangle) loader.load();
                    Color color = (i+j) % 2 == 0 ? Color.WHITE : Color.BLACK;
                    rct.setFill(color);
                    GridPane.setConstraints(rct, i, j);
                    viewEchiquier.getChildren().add(rct);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
