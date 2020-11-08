package fr.umontpellier.iut.main;

import fr.umontpellier.iut.main.model.ModelEchiquier;
import fr.umontpellier.iut.main.model.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Jeu extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        ModelEchiquier e = new ModelEchiquier();
        e.setRoiTour();
        System.out.println(e.toString());
        System.out.println(e.getCase(0,0).deplacerPiece(e.getCase(0,1)));
        System.out.println(e.getCase(0,1).deplacerPiece(e.getCase(1,2)));
        System.out.println(e.toString());







        System.exit(0);
        //launch(args);
    }
}
