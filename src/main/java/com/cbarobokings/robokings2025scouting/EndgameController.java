package com.cbarobokings.robokings2025scouting;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class EndgameController {

    @FXML
    private Button back_Button;
    @FXML
    private Button next_Button;
    @FXML
    private TextArea comments_TextArea;
    @FXML
    private ChoiceBox<String> endgamePosition_ChoiceBox;
    @FXML
    private CheckBox playedDefense_CheckBox;
    @FXML
    private TextField totalAlliancePoints_TextField;

    @FXML
    public void initialize() {
        //SceneDataStore initiation
        SceneDataStore endgameStore = SceneDataStore.getInstance();

        //Modify anything not directly modifiable in SceneBuilder
        endgamePosition_ChoiceBox.getItems().addAll("None", "Park", "Shallow", "Deep");
        endgamePosition_ChoiceBox.setStyle("-fx-font-family: 'Berlin Sans FB'; -fx-font-size: 12px; -fx-font-weight: regular;");

        NumericTextFieldFilter.applyNumericFilter(totalAlliancePoints_TextField);

        // Restore any saved data
        if (endgameStore.getValue("endgamePosition") != null) {
            endgamePosition_ChoiceBox.setValue((String) endgameStore.getValue("endgamePosition"));
        }
        if (endgameStore.getValue("playedDefense") != null) {
            playedDefense_CheckBox.setSelected((Boolean) endgameStore.getValue("playedDefense"));
        }
        if (endgameStore.getValue("totalAlliancePoints") != null) {
            totalAlliancePoints_TextField.setText((String) endgameStore.getValue("totalAlliancePoints"));
        }
        if (endgameStore.getValue("comments") != null) {
            comments_TextArea.setText((String) endgameStore.getValue("comments"));
        }

        //Save any inputted data
        endgamePosition_ChoiceBox.setOnAction(event ->
                endgameStore.setValue("endgamePosition", endgamePosition_ChoiceBox.getValue()));
        playedDefense_CheckBox.setOnAction(event ->
                endgameStore.setValue("playedDefense", playedDefense_CheckBox.isSelected()));
        totalAlliancePoints_TextField.textProperty().addListener((observable, oldValue, newValue) ->
                endgameStore.setValue("totalAlliancePoints", newValue));
        comments_TextArea.textProperty().addListener((observable, oldValue, newValue) ->
                endgameStore.setValue("comments", newValue));


    }

    @FXML
    void backToTeleopButtonClick(ActionEvent event) {
        PrimaryWindow.switchScene("Teleop.fxml");
    }

    @FXML
    void toQRCodeButtonClick(ActionEvent event) {
        PrimaryWindow.switchScene("DataConfirmation.fxml");
    }

}
