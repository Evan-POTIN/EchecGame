package fr.umontpellier.iut.main.controller.controllerPiece;

import fr.umontpellier.iut.main.model.Couleurs;
import fr.umontpellier.iut.main.model.ModelPiece;
import fr.umontpellier.iut.main.model.ModelRoi;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerPiece implements Initializable {
    @FXML
    private Text icon;
    private ModelPiece piece;

    public ControllerPiece(ModelPiece piece) {
        this.piece = piece;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        if(piece != null) {
            icon.setText(piece.getUnicode());

            if(piece.getClr() == Couleurs.BLANC) {
                icon.setFill(Color.GREEN);
            } else {
                icon.setFill(Color.RED);
            }
        }
    }
}
