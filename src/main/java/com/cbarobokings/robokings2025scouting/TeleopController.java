package com.cbarobokings.robokings2025scouting;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class TeleopController {
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
    public void initialize() {
        //SceneDataStore initiation
        SceneDataStore teleopStore = SceneDataStore.getInstance();

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
        if (teleopStore.getValue("algaeCollected") != null) {
            algaeCollected_TextField.setText((String) teleopStore.getValue("algaeCollected"));
        }
        if (teleopStore.getValue("algaeDropped") != null) {
            algaeDropped_TextField.setText((String) teleopStore.getValue("algaeDropped"));
        }
        if (teleopStore.getValue("algaeScored") != null) {
            algaeScored_TextField.setText((String) teleopStore.getValue("algaeScored"));
        }
        if (teleopStore.getValue("algaeNetted") != null) {
            algaeNetted_TextField.setText((String) teleopStore.getValue("algaeNetted"));
        }
        if (teleopStore.getValue("coralCollected") != null) {
            coralCollected_TextField.setText((String) teleopStore.getValue("coralCollected"));
        }
        if (teleopStore.getValue("coralDropped") != null) {
            coralDropped_TextField.setText((String) teleopStore.getValue("coralDropped"));
        }
        if (teleopStore.getValue("coralScoredL1") != null) {
            coralScoredL1_TextField.setText((String) teleopStore.getValue("coralScoredL1"));
        }
        if (teleopStore.getValue("coralScoredL2") != null) {
            coralScoredL2_TextField.setText((String) teleopStore.getValue("coralScoredL2"));
        }
        if (teleopStore.getValue("coralScoredL3") != null) {
            coralScoredL3_TextField.setText((String) teleopStore.getValue("coralScoredL3"));
        }
        if (teleopStore.getValue("coralScoredL4") != null) {
            coralScoredL4_TextField.setText((String) teleopStore.getValue("coralScoredL4"));
        }

        //Save any inputted data
        algaeCollected_TextField.textProperty().addListener((observable, oldValue, newValue) ->
                teleopStore.setValue("algaeCollected", algaeCollected_TextField.getText()));
        algaeDropped_TextField.textProperty().addListener((observable, oldValue, newValue) ->
                teleopStore.setValue("algaeDropped", algaeDropped_TextField.getText()));
        algaeScored_TextField.textProperty().addListener((observable, oldValue, newValue) ->
                teleopStore.setValue("algaeScored", algaeScored_TextField.getText()));
        algaeNetted_TextField.textProperty().addListener((observable, oldValue, newValue) ->
                teleopStore.setValue("algaeNetted", algaeNetted_TextField.getText()));
        coralCollected_TextField.textProperty().addListener((observable, oldValue, newValue) ->
                teleopStore.setValue("coralCollected", coralCollected_TextField.getText()));
        coralDropped_TextField.textProperty().addListener((observable, oldValue, newValue) ->
                teleopStore.setValue("coralDropped", coralDropped_TextField.getText()));
        coralScoredL1_TextField.textProperty().addListener((observable, oldValue, newValue) ->
                teleopStore.setValue("coralScoredL1", coralScoredL1_TextField.getText()));
        coralScoredL2_TextField.textProperty().addListener((observable, oldValue, newValue) ->
                teleopStore.setValue("coralScoredL2", coralScoredL2_TextField.getText()));
        coralScoredL3_TextField.textProperty().addListener((observable, oldValue, newValue) ->
                teleopStore.setValue("coralScoredL3", coralScoredL3_TextField.getText()));
        coralScoredL4_TextField.textProperty().addListener((observable, oldValue, newValue) ->
                teleopStore.setValue("coralScoredL4", coralScoredL4_TextField.getText()));



    }

    @FXML
    void backToAutonButtonClick(ActionEvent event) {
        PrimaryWindow.switchScene("Autonomous.fxml");
    }

    @FXML
    void toEndgameButtonClick(ActionEvent event) {
        PrimaryWindow.switchScene("Endgame.fxml");
    }

}
