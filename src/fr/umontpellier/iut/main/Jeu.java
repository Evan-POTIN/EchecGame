package fr.umontpellier.iut.main;

import fr.umontpellier.iut.main.controller.ControllerEchequier;
import fr.umontpellier.iut.main.joueur.Minmax;
import fr.umontpellier.iut.main.model.ModelEchiquier;
import fr.umontpellier.iut.main.model.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Scanner;

public class Jeu extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        /**
         * Charge la view principale aka la ViewEchiquier
         */
        Parent root = FXMLLoader.load(getClass().getResource("view/ViewEchiquier.fxml"));
        primaryStage.setTitle("Stale Chess");
        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.show();
    }


    public static void main(String[] args) {

        launch(args);

        ModelEchiquier e = new ModelEchiquier();
        e.setRoiTour();
        boolean verif = false;

        Minmax minmax = new Minmax();

      while (!e.getRoiBlanc().echecEtMat()  && !e.getRoiNoir().echecEtMat()) {

            System.out.println(e.toString());

            while (!verif) {
                System.out.println("Tour du joueur blanc");

                e = minmax.minmax(e, 1, Integer.MIN_VALUE, Integer.MAX_VALUE, true).getCoup();

            }
            verif = e.getRoiNoir().echecEtMat() ? !verif : verif;
            System.out.println(e.toString());

            while (verif) {

                ModelCase roiNoir = e.getCase(e.getRoiNoir().getPosition()[0], e.getRoiNoir().getPosition()[1]);

                Scanner sc = new Scanner(System.in);
                System.out.println("Tour du joueur noir");
                System.out.print("le X : ");
                int posX = sc.nextInt();
                System.out.print("\nle Y : ");
                int posY = sc.nextInt();

                if (roiNoir.deplacerPiece(e.getCase(posX, posY))) {
                    verif = !verif;
                }
            }
            System.out.println(e.toString());
        }

        if (e.getRoiNoir().echecEtMat()){
            System.out.println("Le joueur 1 a gagné");
        }else {
            System.out.println("Le joueur 2 a gagné");
        }

        System.exit(0);

    }
}

