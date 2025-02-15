package com.cbarobokings.robokings2025scouting;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.List;

public class PrematchController {
    @FXML
    private Button next_Button;
    @FXML
    private TextField scouterName_TextField;
    @FXML
    private ChoiceBox<String> teamNumber_ChoiceBox;
    @FXML
    private TextField matchNumber_TextField;
    @FXML
    private ChoiceBox<String> startingColorAndPosition_ChoiceBox;
    @FXML
    private CheckBox preloadedCoral_CheckBox;

    @FXML
    public void initialize() {
        //SceneDataStore initiation
        SceneDataStore prematchStore = SceneDataStore.getInstance();

        //Define Teams to choose from eventTeams.txt file
        String teamsList_txtFILE = "robokingsscouting/eventTeams.txt";
        List<String> teamNumbers = PrimaryWindow.loadChoicesFromFile(teamsList_txtFILE);

        //Modify anything not directly modifiable in SceneBuilder
        teamNumber_ChoiceBox.getItems().addAll(teamNumbers);
        teamNumber_ChoiceBox.setStyle("-fx-font-family: 'Berlin Sans FB'; -fx-font-size: 12px; -fx-font-weight: regular;");

        NumericTextFieldFilter.applyNumericFilter(matchNumber_TextField);

        startingColorAndPosition_ChoiceBox.getItems().addAll("red1", "red2", "red3", "blue1", "blue2", "blue3");
        startingColorAndPosition_ChoiceBox.setStyle("-fx-font-family: 'Berlin Sans FB'; -fx-font-size: 12px; -fx-font-weight: regular;");


        // Restore any saved data
        if (prematchStore.getValue("scouterName") != null) {
            scouterName_TextField.setText((String) prematchStore.getValue("scouterName"));
        }
        if (prematchStore.getValue("teamNumber") != null) {
            teamNumber_ChoiceBox.setValue((String) prematchStore.getValue("teamNumber"));
        }
        if (prematchStore.getValue("matchNumber") != null) {
            matchNumber_TextField.setText((String) prematchStore.getValue("matchNumber"));
        }
        if (prematchStore.getValue("startingColorAndPosition") != null) {
            startingColorAndPosition_ChoiceBox.setValue((String) prematchStore.getValue("startingColorAndPosition"));
        }
        if (prematchStore.getValue("preloadedCoral") != null) {
            preloadedCoral_CheckBox.setSelected((Boolean) prematchStore.getValue("preloadedCoral"));
        }

        //Save any inputted data
        scouterName_TextField.textProperty().addListener((observable, oldValue, newValue) ->
                prematchStore.setValue("scouterName", scouterName_TextField.getText()));
        teamNumber_ChoiceBox.setOnAction(event ->
                prematchStore.setValue("teamNumber", teamNumber_ChoiceBox.getValue()));
        matchNumber_TextField.textProperty().addListener((observable, oldValue, newValue) ->
                prematchStore.setValue("matchNumber", newValue));
        startingColorAndPosition_ChoiceBox.setOnAction(event ->
                prematchStore.setValue("startingColorAndPosition", startingColorAndPosition_ChoiceBox.getValue()));
        preloadedCoral_CheckBox.setOnAction(event ->
                prematchStore.setValue("preloadedCoral", preloadedCoral_CheckBox.isSelected()));


    }

    @FXML
    void toAutonomousButtonClick(ActionEvent event) {
        PrimaryWindow.switchScene("Autonomous.fxml");
    }

}