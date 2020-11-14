package fr.umontpellier.iut.main;

import java.lang.Class;

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
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        ModelEchiquier e = new ModelEchiquier();
        e.setRoiTour();
        System.out.println(e.toString());
        System.out.println(e.getRoiNoir().estEchec(0,0));

        System.out.println(e.getRoiBlanc().casesPossible(e.getRoiBlanc().casesTheorique(e.getRoiBlanc().getPosition()[0],e.getRoiBlanc().getPosition()[1])));


        boolean verif = false;
        System.out.println(e.getRoiNoir().echecEtMat());


      while (!e.getRoiBlanc().echecEtMat()  && !e.getRoiNoir().echecEtMat()) {

            System.out.println(e.toString());

            while (!verif) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Joueur 1 choisit un pion a bouger");
                System.out.print("le X : ");
                int posX = sc.nextInt();
                System.out.print("\nle Y : ");
                int posY = sc.nextInt();

                System.out.println("Joueur 1 choisit où envoyer ce pion");
                System.out.print("le X : ");
                int destX = sc.nextInt();
                System.out.print("\nle Y : ");
                int destY = sc.nextInt();

                if ( e.getCase(posX,posY).getPiece() != null && e.getCase(posX, posY).getPiece().getClr() == Couleurs.BLANC && e.getCase(posX, posY).deplacerPiece(e.getCase(destX, destY))) {
                    verif = !verif;
                }

            }
            verif = e.getRoiNoir().echecEtMat() ? !verif : verif;
            System.out.println(e.toString());

            while (verif) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Joueur 2 choisit un pion a bouger");
                System.out.print("le X : ");
                int posX = sc.nextInt();
                System.out.print("\nle Y : ");
                int posY = sc.nextInt();

                System.out.println("Joueur 2 choisit où envoyer ce pion");
                System.out.print("le X : ");
                int destX = sc.nextInt();
                System.out.print("\nle Y : ");
                int destY = sc.nextInt();
                if (e.getCase(posX,posY).getPiece() != null && e.getCase(posX, posY).getPiece().getClr() == Couleurs.NOIR && e.getCase(posX, posY).deplacerPiece(e.getCase(destX, destY))) {
                    verif = !verif;
                }
            }
        }

        if (e.getRoiNoir().echecEtMat()){
            System.out.println("Le joueur 1 a gagné");
        }else {
            System.out.println("Le joueur 2 a gagné");
        }

        System.exit(0);

    }
}

