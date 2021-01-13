package fr.umontpellier.iut.main.controller;

import com.sun.webkit.Timer;
import fr.umontpellier.iut.main.joueur.Minmax;
import fr.umontpellier.iut.main.model.Couleurs;
import fr.umontpellier.iut.main.model.ModelCase;
import fr.umontpellier.iut.main.model.ModelEchiquier;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControllerEchequier implements Initializable {

    @FXML
    private GridPane viewEchiquier;

    private ModelEchiquier modelEchiquier;

    ArrayList<ModelCase> casePossible;

    ModelCase prevPiece;

    Minmax minmax;

    boolean quiJoue;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /**
         * Méthode lancée au chargement de la view
         */

        //System.out.println("ControllerEchiquier");
        modelEchiquier = new ModelEchiquier();  // Instancie le modèle associé
        minmax = new Minmax(3);
        modelEchiquier.setRoiTour();
        System.out.println(modelEchiquier.toString());
        quiJoue = true;
        loadScreen();


    }

    public StackPane getStackPaneByRowColumnIndex(int row, int column) {
        StackPane result = null;
        ObservableList<Node> childrens = viewEchiquier.getChildren();

        for (Node node : childrens) {
            if (viewEchiquier.getRowIndex(node) == row && viewEchiquier.getColumnIndex(node) == column) {
                result = (StackPane) node;
                break;
            }
        }

        return result;
    }

    private void loadScreen() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                // Crée un nouveau controller associé à la case
                ControllerCase cc = new ControllerCase(modelEchiquier.getCase(i, j));

                // Charge une nouvelle vue
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("./../view/ViewCase.fxml"));
                loader.setController(cc);   // Associe le controller à la vue

                try {
                    // Ajoute la vue à l'échiquier et lui attribue la bonne couleur
                    StackPane rct = (StackPane) loader.load();
                    Color color = (i + j) % 2 == 0 ? Color.WHITE : Color.BLACK;
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

                    int x = (int) mouseEvent.getY() / 64;
                    int y = (int) mouseEvent.getX() / 64;
                    for (int i = 0; i < 8; i++) {
                        for (int j = 0; j < 8; j++) {
                            StackPane a = getStackPaneByRowColumnIndex(i, j);
                            if ((i + j) % 2 == 0) {
                                a.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
                            } else {
                                a.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
                            }
                        }
                    }
                    if (quiJoue) {
                        modelEchiquier = minmax.jouerCoup(modelEchiquier);
                        if (!modelEchiquier.getRoiBlanc().echecEtMat() && !modelEchiquier.getRoiNoir().echecEtMat()) {
                            quiJoue = !quiJoue;
                            loadScreen();

                        } else {
                            ecranFin();
                        }
                    } else {
                        if (modelEchiquier.getCase(x, y).getPiece() != null) {
                        /*if (modelEchiquier.getCase(x,y).getPiece().getClr() == Couleurs.BLANC && quiJoue == true) {
                            casePossible = new ArrayList<>(modelEchiquier.getCase(x, y).getPiece().casesPossible(modelEchiquier.getCase(x, y).getPiece().casesTheorique(x, y)));
                            prevPiece = new ModelCase(modelEchiquier.getCase(x, y).getPiece(), x, y);
                            for (ModelCase c : casePossible) {
                                StackPane a = getStackPaneByRowColumnIndex(c.getPosX(), c.getPosY());
                                a.setBackground(new Background(new BackgroundFill(Color.BLUEVIOLET, null, null)));
                            }*/

                            if (modelEchiquier.getCase(x, y).getPiece().getClr() == Couleurs.NOIR) {
                                casePossible = new ArrayList<>(modelEchiquier.getCase(x, y).getPiece().casesPossible(modelEchiquier.getCase(x, y).getPiece().casesTheorique(x, y)));
                                prevPiece = new ModelCase(modelEchiquier.getCase(x, y).getPiece(), x, y);
                                for (ModelCase c : casePossible) {
                                    StackPane a = getStackPaneByRowColumnIndex(c.getPosX(), c.getPosY());

                                    a.setBackground(new Background(new BackgroundFill(Color.BLUEVIOLET, null, null)));
                                }

                            }
                        } else if (casePossible != null && casePossible.contains(modelEchiquier.getCase(x, y))) {
                            modelEchiquier.getCase(prevPiece.getPosX(), prevPiece.getPosY()).deplacerPiece(modelEchiquier.getCase(x, y));

                            if (!modelEchiquier.getRoiBlanc().echecEtMat() && !modelEchiquier.getRoiNoir().echecEtMat()) {
                                quiJoue = !quiJoue;
                                loadScreen();

                            } else {
                                ecranFin();
                            }


                        } else {
                            casePossible = null;
                            prevPiece = null;
                        }
                        ;

                    }
                }
        );
    }

    public void ecranFin(){
        Stage finishStage = new Stage();
        Pane pane = new Pane();
        Label label = new Label();
        Scene finishScene = new Scene(pane, 800, 560);
        if (modelEchiquier.getRoiNoir().echecEtMat()) {
            label = new Label("Les blancs ont gagnée");
        } else if (modelEchiquier.getRoiBlanc().echecEtMat()) {
            label = new Label("Les blancs ont gagnée");
        }

        FlowPane root = new FlowPane();
        root.setPadding(new Insets(10));
        root.getChildren().add(label);

        Scene scene = new Scene(root, 200, 100);

        finishStage.setScene(scene);
        finishStage.show();
    }
}
