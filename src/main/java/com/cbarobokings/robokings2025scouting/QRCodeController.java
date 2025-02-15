package com.cbarobokings.robokings2025scouting;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class QRCodeController {

    @FXML
    private Button clearQRdirButton;
    @FXML
    private ImageView qrImageWindowLocation;
    @FXML
    private Button scoutNextMatch_Button;

    @FXML
    public void initialize() {
        SceneDataStore restartScoutingStore = SceneDataStore.getInstance();

        String matchNumber = (String) restartScoutingStore.getValue("matchNumber");
        String startingColorAndPosition = (String) restartScoutingStore.getValue("startingColorAndPosition");
        String qrCodeFileName = "qrcode_M" + matchNumber + "_" + startingColorAndPosition + ".png";
        String qrCodeLocationDirectory = "robokingsscouting/qr_codes/" + qrCodeFileName;

        Path path = Paths.get(qrCodeLocationDirectory).toAbsolutePath();
        File file = path.toFile();

        if (file.exists()) {
            qrImageWindowLocation.setImage(new Image(file.toURI().toString()));
        } else {
            System.out.println("File does not exist: " + file.getAbsolutePath());
        }
    }

    @FXML
    void clearQRdirButtonClick(ActionEvent event) {

        PrimaryWindow.clearQRCodesDirectory();
    }

    @FXML
    void scoutNextMatchButtonClick(ActionEvent event) {
        SceneDataStore restartScoutingStore = SceneDataStore.getInstance();
        restartScoutingStore.clearData();
        PrimaryWindow.switchScene("Prematch.fxml");
    }

}
