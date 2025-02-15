package com.cbarobokings.robokings2025scouting;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class AutonomousController {
    @FXML
    private Button back_Button;
    @FXML
    private Button next_Button;
    @FXML
    private TextField algaeCollected_TextField;
    @FXML
    private TextField algaeDropped_TextField;
    @FXML
    private TextField algaeScored_TextField;
    @FXML
    private TextField algaeNetted_TextField;
    @FXML
    private TextField coralCollected_TextField;
    @FXML
    private TextField coralDropped_TextField;
    @FXML
    private TextField coralScoredL1_TextField;
    @FXML
    private TextField coralScoredL2_TextField;
    @FXML
    private TextField coralScoredL3_TextField;
    @FXML
    private TextField coralScoredL4_TextField;
    @FXML
    private CheckBox leftStartingZone_CheckBox;

    @FXML
    public void initialize() {
        //SceneDataStore initiation
        SceneDataStore autonStore = SceneDataStore.getInstance();

        //Modify anything not directly modifiable in SceneBuilder
        NumericTextFieldFilter.applyNumericFilter(algaeCollected_TextField);
        NumericTextFieldFilter.applyNumericFilter(algaeDropped_TextField);
        NumericTextFieldFilter.applyNumericFilter(algaeScored_TextField);
        NumericTextFieldFilter.applyNumericFilter(algaeNetted_TextField);
        NumericTextFieldFilter.applyNumericFilter(coralCollected_TextField);
        NumericTextFieldFilter.applyNumericFilter(coralDropped_TextField);
        NumericTextFieldFilter.applyNumericFilter(coralScoredL1_TextField);
        NumericTextFieldFilter.applyNumericFilter(coralScoredL2_TextField);
        NumericTextFieldFilter.applyNumericFilter(coralScoredL3_TextField);
        NumericTextFieldFilter.applyNumericFilter(coralScoredL4_TextField);

        // Restore any saved data
        if (autonStore.getValue("autonAlgaeCollected") != null) {
            algaeCollected_TextField.setText((String) autonStore.getValue("autonAlgaeCollected"));
        }
        if (autonStore.getValue("autonAlgaeDropped") != null) {
            algaeDropped_TextField.setText((String) autonStore.getValue("autonAlgaeDropped"));
        }
        if (autonStore.getValue("autonAlgaeScored") != null) {
            algaeScored_TextField.setText((String) autonStore.getValue("autonAlgaeScored"));
        }
        if (autonStore.getValue("autonAlgaeNetted") != null) {
            algaeNetted_TextField.setText((String) autonStore.getValue("autonAlgaeNetted"));
        }
        if (autonStore.getValue("autonCoralCollected") != null) {
            coralCollected_TextField.setText((String) autonStore.getValue("autonCoralCollected"));
        }
        if (autonStore.getValue("autonCoralDropped") != null) {
            coralDropped_TextField.setText((String) autonStore.getValue("autonCoralDropped"));
        }
        if (autonStore.getValue("autonCoralScoredL1") != null) {
            coralScoredL1_TextField.setText((String) autonStore.getValue("autonCoralScoredL1"));
        }
        if (autonStore.getValue("autonCoralScoredL2") != null) {
            coralScoredL2_TextField.setText((String) autonStore.getValue("autonCoralScoredL2"));
        }
        if (autonStore.getValue("autonCoralScoredL3") != null) {
            coralScoredL3_TextField.setText((String) autonStore.getValue("autonCoralScoredL3"));
        }
        if (autonStore.getValue("autonCoralScoredL4") != null) {
            coralScoredL4_TextField.setText((String) autonStore.getValue("autonCoralScoredL4"));
        }
        if (autonStore.getValue("leftStartingZone") != null) {
            leftStartingZone_CheckBox.setSelected((Boolean) autonStore.getValue("leftStartingZone"));
        }

        //Save any inputted data
        algaeCollected_TextField.textProperty().addListener((observable, oldValue, newValue) ->
                autonStore.setValue("autonAlgaeCollected", algaeCollected_TextField.getText()));
        algaeDropped_TextField.textProperty().addListener((observable, oldValue, newValue) ->
                autonStore.setValue("autonAlgaeDropped", algaeDropped_TextField.getText()));
        algaeScored_TextField.textProperty().addListener((observable, oldValue, newValue) ->
                autonStore.setValue("autonAlgaeScored", algaeScored_TextField.getText()));
        algaeNetted_TextField.textProperty().addListener((observable, oldValue, newValue) ->
                autonStore.setValue("autonAlgaeNetted", algaeNetted_TextField.getText()));
        coralCollected_TextField.textProperty().addListener((observable, oldValue, newValue) ->
                autonStore.setValue("autonCoralCollected", coralCollected_TextField.getText()));
        coralDropped_TextField.textProperty().addListener((observable, oldValue, newValue) ->
                autonStore.setValue("autonCoralDropped", coralDropped_TextField.getText()));
        coralScoredL1_TextField.textProperty().addListener((observable, oldValue, newValue) ->
                autonStore.setValue("autonCoralScoredL1", coralScoredL1_TextField.getText()));
        coralScoredL2_TextField.textProperty().addListener((observable, oldValue, newValue) ->
                autonStore.setValue("autonCoralScoredL2", coralScoredL2_TextField.getText()));
        coralScoredL3_TextField.textProperty().addListener((observable, oldValue, newValue) ->
                autonStore.setValue("autonCoralScoredL3", coralScoredL3_TextField.getText()));
        coralScoredL4_TextField.textProperty().addListener((observable, oldValue, newValue) ->
                autonStore.setValue("autonCoralScoredL4", coralScoredL4_TextField.getText()));
        leftStartingZone_CheckBox.setOnAction(event ->
                autonStore.setValue("leftStartingZone", leftStartingZone_CheckBox.isSelected()));



    }

    @FXML
    void backToPrematchButtonClick(ActionEvent event) {
        PrimaryWindow.switchScene("Prematch.fxml");
    }

    @FXML
    void toTeleopButtonClick(ActionEvent event) {
        PrimaryWindow.switchScene("Teleop.fxml");
    }

}
