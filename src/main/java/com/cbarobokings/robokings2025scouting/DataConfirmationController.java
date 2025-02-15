package com.cbarobokings.robokings2025scouting;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class DataConfirmationController {

    public static class tableDataTemplate {
        private final StringProperty dataName;
        private final StringProperty dataValue;

        public tableDataTemplate(String dataName, String dataValue) {
            this.dataName = new SimpleStringProperty(dataName);
            this.dataValue = new SimpleStringProperty(dataValue);
        }

        public StringProperty dataNameProperty() { return dataName; }
        public StringProperty dataValueProperty() { return dataValue; }

        public String getDataName() { return dataName.get(); }
        public String getDataValue() { return dataValue.get(); }
    }

    @FXML
    private TableView<tableDataTemplate> auton_TableView;
    @FXML
    private Button backToEndgame_Button;
    @FXML
    private TableView<tableDataTemplate> endgame_TableView;
    @FXML
    private TableView<tableDataTemplate> prematch_TableView;
    @FXML
    private TableView<tableDataTemplate> teleop_TableView;
    @FXML
    private Button viewQRCode_Button;

    @FXML
    public void initialize() {
        SceneDataStore finalizationStore = SceneDataStore.getInstance();

        // PREMATCH
        String scouterName = (String) finalizationStore.getValue("scouterName");
        String teamNumber = (String) finalizationStore.getValue("teamNumber");
        String matchNumber = (String) finalizationStore.getValue("matchNumber");
        String startingColorAndPosition = (String) finalizationStore.getValue("startingColorAndPosition");
        String preloadedCoral;
        if (finalizationStore.getValue("preloadedCoral") != null) {
            preloadedCoral = finalizationStore.getValue("preloadedCoral").toString();
        } else {
            preloadedCoral = "false";
        }
        // AUTON
        String autonAlgaeCollected = (String) finalizationStore.getValue("autonAlgaeCollected");
        String autonAlgaeScored = (String) finalizationStore.getValue("autonAlgaeScored");
        String autonAlgaeDropped = (String) finalizationStore.getValue("autonAlgaeDropped");
        String autonAlgaeNetted = (String) finalizationStore.getValue("autonAlgaeNetted");
        String autonCoralCollected = (String) finalizationStore.getValue("autonCoralCollected");
        String autonCoralScoredL1 = (String) finalizationStore.getValue("autonCoralScoredL1");
        String autonCoralScoredL2 = (String) finalizationStore.getValue("autonCoralScoredL2");
        String autonCoralScoredL3 = (String) finalizationStore.getValue("autonCoralScoredL3");
        String autonCoralScoredL4 = (String) finalizationStore.getValue("autonCoralScoredL4");
        String autonCoralDropped = (String) finalizationStore.getValue("autonCoralDropped");
        String leftStartingZone;
        if (finalizationStore.getValue("leftStartingZone") != null) {
            leftStartingZone = finalizationStore.getValue("leftStartingZone").toString();
        } else {
            leftStartingZone = "false";
        }
        // TELEOP
        String algaeCollected = (String) finalizationStore.getValue("algaeCollected");
        String algaeScored = (String) finalizationStore.getValue("algaeScored");
        String algaeDropped = (String) finalizationStore.getValue("algaeDropped");
        String algaeNetted = (String) finalizationStore.getValue("algaeNetted");
        String coralCollected = (String) finalizationStore.getValue("coralCollected");
        String coralScoredL1 = (String) finalizationStore.getValue("coralScoredL1");
        String coralScoredL2 = (String) finalizationStore.getValue("coralScoredL2");
        String coralScoredL3 = (String) finalizationStore.getValue("coralScoredL3");
        String coralScoredL4 = (String) finalizationStore.getValue("coralScoredL4");
        String coralDropped = (String) finalizationStore.getValue("coralDropped");
        //ENDGAME
        String endgamePosition = (String) finalizationStore.getValue("endgamePosition");
        String playedDefense;
        if (finalizationStore.getValue("playedDefense") != null) {
            playedDefense = finalizationStore.getValue("playedDefense").toString();
        } else {
            playedDefense = "false";
        }
        String totalAlliancePoints = (String) finalizationStore.getValue("totalAlliancePoints");
        String comments = (String) finalizationStore.getValue("comments");


        //PREMATCH TABLE
        TableColumn<tableDataTemplate, String> prematchNameColumn = new TableColumn<>("Description");
        prematchNameColumn.setCellValueFactory(new PropertyValueFactory<>("dataName"));
        TableColumn<tableDataTemplate, String> prematchValueColumn = new TableColumn<>("Value");
        prematchValueColumn.setCellValueFactory(new PropertyValueFactory<>("dataValue"));
        prematchNameColumn.setResizable(true);
        prematchValueColumn.setResizable(true);

        ObservableList<tableDataTemplate> prematchData = FXCollections.observableArrayList(
                new tableDataTemplate("Scouter Name", scouterName),
                new tableDataTemplate("Team Number", teamNumber),
                new tableDataTemplate("Match Number", matchNumber),
                new tableDataTemplate("Starting Color/Position", startingColorAndPosition),
                new tableDataTemplate("Preloaded Coral?", preloadedCoral)
        );
        prematch_TableView.getColumns().clear();
        prematch_TableView.getColumns().addAll(prematchNameColumn, prematchValueColumn);
        Platform.runLater(() -> {
            prematch_TableView.setItems(prematchData);
            prematch_TableView.refresh();
        });
        //AUTON TABLE
        TableColumn<tableDataTemplate, String> autonNameColumn = new TableColumn<>("Description");
        autonNameColumn.setCellValueFactory(new PropertyValueFactory<>("dataName"));
        TableColumn<tableDataTemplate, String> autonValueColumn = new TableColumn<>("Value");
        autonValueColumn.setCellValueFactory(new PropertyValueFactory<>("dataValue"));
        autonNameColumn.setResizable(true);
        autonValueColumn.setResizable(true);

        ObservableList<tableDataTemplate> autonData = FXCollections.observableArrayList(
                new tableDataTemplate("Auton Algae Collected", autonAlgaeCollected),
                new tableDataTemplate("Auton Algae Scored", autonAlgaeScored),
                new tableDataTemplate("Auton Algae Dropped",  autonAlgaeDropped),
                new tableDataTemplate("Auton Algae Netted", autonAlgaeNetted),
                new tableDataTemplate("Auton Coral Collected", autonCoralCollected),
                new tableDataTemplate("Auton Coral Scored L1", autonCoralScoredL1),
                new tableDataTemplate("Auton Coral Scored L2", autonCoralScoredL2),
                new tableDataTemplate("Auton Coral Scored L3", autonCoralScoredL3),
                new tableDataTemplate("Auton Coral Scored L4", autonCoralScoredL4),
                new tableDataTemplate("Auton Coral Dropped", autonCoralDropped),
                new tableDataTemplate("Left Starting Zone?", leftStartingZone)

        );
        auton_TableView.getColumns().clear();
        auton_TableView.getColumns().addAll(autonNameColumn, autonValueColumn);
        Platform.runLater(() -> {
            auton_TableView.setItems(autonData);
            auton_TableView.refresh();
        });
        //TELEOP TABLE
        TableColumn<tableDataTemplate, String> teleopNameColumn = new TableColumn<>("Description");
        teleopNameColumn.setCellValueFactory(new PropertyValueFactory<>("dataName"));
        TableColumn<tableDataTemplate, String> teleopValueColumn = new TableColumn<>("Value");
        teleopValueColumn.setCellValueFactory(new PropertyValueFactory<>("dataValue"));
        teleopNameColumn.setResizable(true);
        teleopValueColumn.setResizable(true);

        ObservableList<tableDataTemplate> teleopData = FXCollections.observableArrayList(
                new tableDataTemplate("Algae Collected", algaeCollected),
                new tableDataTemplate("Algae Scored", algaeScored),
                new tableDataTemplate("Algae Dropped",  algaeDropped),
                new tableDataTemplate("Algae Netted", algaeNetted),
                new tableDataTemplate("Coral Collected", coralCollected),
                new tableDataTemplate("Coral Scored L1", coralScoredL1),
                new tableDataTemplate("Coral Scored L2", coralScoredL2),
                new tableDataTemplate("Coral Scored L3", coralScoredL3),
                new tableDataTemplate("Coral Scored L4", coralScoredL4),
                new tableDataTemplate("Coral Dropped", coralDropped)

        );
        teleop_TableView.getColumns().clear();
        teleop_TableView.getColumns().addAll(teleopNameColumn, teleopValueColumn);
        Platform.runLater(() -> {
            teleop_TableView.setItems(teleopData);
            teleop_TableView.refresh();
        });
        //ENDGAME TABLE
        TableColumn<tableDataTemplate, String> endgameNameColumn = new TableColumn<>("Description");
        endgameNameColumn.setCellValueFactory(new PropertyValueFactory<>("dataName"));
        TableColumn<tableDataTemplate, String> endgameValueColumn = new TableColumn<>("Value");
        endgameValueColumn.setCellValueFactory(new PropertyValueFactory<>("dataValue"));
        endgameNameColumn.setResizable(true);
        endgameValueColumn.setResizable(true);

        ObservableList<tableDataTemplate> endgameData = FXCollections.observableArrayList(
                new tableDataTemplate("Endgame Position", endgamePosition),
                new tableDataTemplate("Played Defense?", playedDefense),
                new tableDataTemplate("Total Alliance Points", totalAlliancePoints),
                new tableDataTemplate("Additional Comments", comments)

        );
        endgame_TableView.getColumns().clear();
        endgame_TableView.getColumns().addAll(endgameNameColumn, endgameValueColumn);
        Platform.runLater(() -> {
            endgame_TableView.setItems(endgameData);
            endgame_TableView.refresh();
        });


    }

    @FXML
    void backToEndgameButtonClick(ActionEvent event) {
        PrimaryWindow.switchScene("Endgame.fxml");
    }

    @FXML
    void viewQRCodeButtonClick(ActionEvent event) {
        SceneDataStore finalizationStore = SceneDataStore.getInstance();

        // PREMATCH
        String scouterName = (String) finalizationStore.getValue("scouterName");
        String teamNumber = (String) finalizationStore.getValue("teamNumber");
        String matchNumber = (String) finalizationStore.getValue("matchNumber");
        String startingColorAndPosition = (String) finalizationStore.getValue("startingColorAndPosition");
        String preloadedCoral;
        if (finalizationStore.getValue("preloadedCoral") != null) {
            preloadedCoral = "Yes";
        } else {
            preloadedCoral = "No";
        }
        // AUTON
        String autonAlgaeCollected = (String) finalizationStore.getValue("autonAlgaeCollected");
        String autonAlgaeScored = (String) finalizationStore.getValue("autonAlgaeScored");
        String autonAlgaeDropped = (String) finalizationStore.getValue("autonAlgaeDropped");
        String autonAlgaeNetted = (String) finalizationStore.getValue("autonAlgaeNetted");
        String autonCoralCollected = (String) finalizationStore.getValue("autonCoralCollected");
        String autonCoralScoredL1 = (String) finalizationStore.getValue("autonCoralScoredL1");
        String autonCoralScoredL2 = (String) finalizationStore.getValue("autonCoralScoredL2");
        String autonCoralScoredL3 = (String) finalizationStore.getValue("autonCoralScoredL3");
        String autonCoralScoredL4 = (String) finalizationStore.getValue("autonCoralScoredL4");
        String autonCoralDropped = (String) finalizationStore.getValue("autonCoralDropped");
        String leftStartingZone;
        if (finalizationStore.getValue("leftStartingZone") != null) {
            leftStartingZone = "Yes";
        } else {
            leftStartingZone = "No";
        }
        // TELEOP
        String algaeCollected = (String) finalizationStore.getValue("algaeCollected");
        String algaeScored = (String) finalizationStore.getValue("algaeScored");
        String algaeDropped = (String) finalizationStore.getValue("algaeDropped");
        String algaeNetted = (String) finalizationStore.getValue("algaeNetted");
        String coralCollected = (String) finalizationStore.getValue("coralCollected");
        String coralScoredL1 = (String) finalizationStore.getValue("coralScoredL1");
        String coralScoredL2 = (String) finalizationStore.getValue("coralScoredL2");
        String coralScoredL3 = (String) finalizationStore.getValue("coralScoredL3");
        String coralScoredL4 = (String) finalizationStore.getValue("coralScoredL4");
        String coralDropped = (String) finalizationStore.getValue("coralDropped");
        //ENDGAME
        String endgamePosition = (String) finalizationStore.getValue("endgamePosition");
        String playedDefense;
        if (finalizationStore.getValue("playedDefense") != null) {
            playedDefense = "Yes";
        } else {
            playedDefense = "No";
        }
        String totalAlliancePoints = (String) finalizationStore.getValue("totalAlliancePoints");
        String comments = (String) finalizationStore.getValue("comments");

        String qrCodeScannedDataEntry = "\t" + String.join("\t",
                scouterName, teamNumber, matchNumber, startingColorAndPosition, preloadedCoral,
                autonAlgaeCollected, autonAlgaeScored, autonAlgaeDropped, autonAlgaeNetted,
                autonCoralCollected, autonCoralScoredL1, autonCoralScoredL2, autonCoralScoredL3, autonCoralScoredL4,
                autonCoralDropped, leftStartingZone, algaeCollected, algaeScored, algaeDropped, algaeNetted,
                coralCollected, coralScoredL1, coralScoredL2, coralScoredL3, coralScoredL4, coralDropped,
                endgamePosition, playedDefense, totalAlliancePoints, comments);
        String qrCodeFileName = "qrcode_M" + matchNumber + "_" + startingColorAndPosition + ".png";

        String qrCodeLocationDirectory = "robokingsscouting/qr_codes/" + qrCodeFileName;

        Path path = FileSystems.getDefault().getPath(qrCodeLocationDirectory);
        System.out.println("Default Path: " + path.toAbsolutePath());
        int width = 505;
        int height = 505;

        byte[] utf8Bytes = qrCodeScannedDataEntry.getBytes(StandardCharsets.UTF_8);
        qrCodeScannedDataEntry = new String(utf8Bytes, StandardCharsets.UTF_8);
        System.out.println("Your data reads: " + qrCodeScannedDataEntry);

        PrimaryWindow.generateQRcode(qrCodeScannedDataEntry, qrCodeFileName, qrCodeLocationDirectory, width, height);

        PrimaryWindow.switchScene("QRCode.fxml");
    }

}
