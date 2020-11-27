package fr.umontpellier.iut.main.controller;

import fr.umontpellier.iut.main.controller.controllerPiece.ControllerPiece;
import fr.umontpellier.iut.main.model.ModelCase;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerCase implements Initializable {

    @FXML
    private StackPane viewCase;
    private final ModelCase modelCase;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /**
         * Méthode lancée à l'initialisation de la vue
         */
        //System.out.println("ControllerCase");

        // Attribution des dimensions du rectangle
        viewCase.setMinWidth(500/8.);
        viewCase.setMinHeight(500/8.);

        ControllerPiece cp = new ControllerPiece(modelCase.getPiece());

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../view/ViewPiece.fxml"));
        loader.setController(cp);

        try {
            Text unicode = (Text) loader.load();
            unicode.setScaleY(4);
            unicode.setScaleX(4);
            viewCase.getChildren().add(unicode);
        } catch (IOException e) {
            e.printStackTrace();
        }


        // Gestion du clic
        viewCase.setOnMouseClicked(
                mouseEvent -> {
                    selectionnerCase();
                }
        );
    }

    public ControllerCase(ModelCase modelCase) {
        /**
         * @Constructeur
         * @Param: Référence de la case qu'elle controlle
         */
        this.modelCase = modelCase;
    }


    public StackPane getRectangle() {
        return viewCase;
    }

    public void setCouleur(Paint couleur) {
        viewCase.setBackground(new Background(new BackgroundFill(couleur, null, null)));
    }

    public void selectionnerCase() {
        setCouleur(Color.YELLOW);
    }

}
