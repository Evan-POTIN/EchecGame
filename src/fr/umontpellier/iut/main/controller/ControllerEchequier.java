package fr.umontpellier.iut.main.controller;

import fr.umontpellier.iut.main.model.ModelCase;
import fr.umontpellier.iut.main.model.ModelEchiquier;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
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
        /**
         * Méthode lancée au chargement de la view
         */

        //System.out.println("ControllerEchiquier");
        modelEchiquier = new ModelEchiquier();  // Instancie le modèle associé
        modelEchiquier.setRoiTour();
        System.out.println(modelEchiquier.toString());

        // Parcours du plateau pour instancier les vues des cases
        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {

                // Crée un nouveau controller associé à la case
                ControllerCase cc = new ControllerCase(modelEchiquier.getCase(i,j));

                // Charge une nouvelle vue
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("./../view/ViewCase.fxml"));
                loader.setController(cc);   // Associe le controller à la vue

                try {
                    // Ajoute la vue à l'échiquier et lui attribue la bonne couleur
                    StackPane rct = (StackPane) loader.load();
                    Color color = (i+j) % 2 == 0 ? Color.WHITE : Color.BLACK;
                    cc.setCouleur(color);
                    GridPane.setConstraints(rct, j, i);
                    viewEchiquier.getChildren().add(rct);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

        int nbClique = 0;
        viewEchiquier.setOnMouseClicked(
                mouseEvent -> {
                    // Recalcule les coordonnée de la case depuis la viewEchiquier
                    // mouseEvent.getX() renvoie la position du clic relativement aux 500 pixels de dimension
                    // Je divise donc par 64 pour le ramener à un nombre entre 0 et 1 pour l'index 0
                    // Etant donné que c'est un float, je cast en int pour garder que la partie entier
                    // J'inverse le x et le y car c'est géré de différente manière entre une matrice et un GridPane

                    int x = (int)mouseEvent.getY()/64;
                    int y = (int)mouseEvent.getX()/64;
                    System.out.println(x + " " + y + modelEchiquier.getCase(x,y).getPiece().getUnicode());
                }
        );
    }

}
