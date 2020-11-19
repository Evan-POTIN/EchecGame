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
    private final ModelCase modelCase;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /**
         * Méthode lancée à l'initialisation de la vue
         */
        //System.out.println("ControllerCase");

        // Attribution des dimensions du rectangle
        viewCase.setWidth(500/8.);
        viewCase.setHeight(500/8.);

        // Gestion du clic
        viewCase.setOnMouseClicked(
                mouseEvent -> System.out.println("ControllerCase de [" + modelCase.getPosX() + ',' + modelCase.getPosY() + ']')
        );
    }

    public ControllerCase(ModelCase modelCase) {
        /**
         * @Constructeur
         * @Param: Référence de la case qu'elle controlle
         */
        this.modelCase = modelCase;
    }


    public Rectangle getRectangle() {
        return viewCase;
    }

    public void setCouleur(Paint couleur) {
        viewCase.setFill(couleur);
    }



}
