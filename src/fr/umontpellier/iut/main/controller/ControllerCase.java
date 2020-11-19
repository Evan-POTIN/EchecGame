package fr.umontpellier.iut.main.controller;

import fr.umontpellier.iut.main.model.ModelCase;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerCase implements Initializable {

    @FXML
    private Rectangle viewCase;
    private Paint couleur;
    private final ModelCase modelCase;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //System.out.println("ControllerCase");
        viewCase.setWidth(500/8.);
        viewCase.setHeight(500/8.);
        viewCase.setFill(couleur);

        viewCase.setOnMouseClicked(
                mouseEvent -> System.out.println("ControllerCase de [" + modelCase.getPosX() + ',' + modelCase.getPosY() + ']')
        );
    }

    public ControllerCase(ModelCase modelCase) {
        this.modelCase = modelCase;
    }

    public Rectangle getRectangle() {
        return viewCase;
    }

    public void setCouleur(Paint couleur) {
        this.couleur = couleur;
    }

    public Paint getCouleur() {
        return couleur;
    }



}
