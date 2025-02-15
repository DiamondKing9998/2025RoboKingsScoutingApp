package com.cbarobokings.robokings2025scouting;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;


public class PrimaryWindow extends Application {

    private static Stage primaryStage;

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;

        stage.setTitle("CBA RoboKings Scouting - 2025 REEFSCAPE");
        stage.setResizable(false);

        String imgDirectory = "/com/cbarobokings/robokings2025scouting/img/";
        Image windowIcon = new Image(PrimaryWindow.class.getResourceAsStream(imgDirectory+"windowIcon.png"));
        stage.getIcons().add(windowIcon);

        switchScene("Prematch.fxml");

        stage.show();

        createDirectory("robokingsscouting");

    }

    public static Stage getPrimaryStage() {
        return primaryStage; // Getter for primary stage
    }
    public static void setPrimaryStage(Stage stage) {

        primaryStage = stage;
    }

    // Static method to switch scenes based on the FXML file path
    public static void switchScene(String fxmlFileName) {

        String fxmlDirectory = "/com/cbarobokings/robokings2025scouting/fxml/";
        URL fxmlLocation = PrimaryWindow.class.getResource(fxmlDirectory+fxmlFileName);
        System.out.println("FXML Path: " + fxmlLocation);

        //Debug Start
        System.out.println(" ");
        Stage stage = PrimaryWindow.getPrimaryStage();
        System.out.println("Primary Stage: " + stage);
        System.out.println("Stage Visible?: " + stage.isShowing());
        System.out.println("Stage Title: " + stage.getTitle());
        System.out.println("Stage Scene: " + stage.getScene());
        //Debug End

        try {
            // Load the FXML file
            FXMLLoader loader = new FXMLLoader(PrimaryWindow.class.getResource(fxmlDirectory+fxmlFileName));
            Parent root = loader.load();

            // Set the new scene on the primary stage
            if (primaryStage != null) {
                primaryStage.setScene(new Scene(root));
                primaryStage.show();
            } else {
                System.out.println("Primary stage not initialized.");
            }
        } catch (IOException e) {
            System.out.println("Error loading FXML file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void generateQRcode(String fileContents, String fileName, String filePath, int width, int height) {
        try {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            Map<EncodeHintType, Object> hints = new HashMap<>();
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");

            // Encode the provided text into a QR code
            BitMatrix bitMatrix = qrCodeWriter.encode(fileContents, BarcodeFormat.QR_CODE, width, height, hints);

            // Convert the file path to an absolute path
            Path path = Paths.get(filePath).toAbsolutePath();
            File file = path.toFile();
            File parentDir = file.getParentFile();

            if (!parentDir.exists()) {
                parentDir.mkdirs(); // Ensure directories exist
            }

            // Write the generated QR code to the specified path as a PNG image
            MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);

        } catch (WriterException | IOException e) {
            // Handle any exceptions during the QR code generation process
            System.out.println("Error generating QR code: " + e.getMessage());
        }
    }

    public static void clearQRCodesDirectory() {
        String directoryPath = "robokingsscouting/qr_codes";
        Path qrCodeDir = Paths.get(directoryPath).toAbsolutePath();
        File dir = qrCodeDir.toFile();

        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        file.delete();
                    }
                }
            }
            System.out.println("All QR code files deleted from: " + qrCodeDir);
        } else {
            System.out.println("QR codes directory does not exist or is not a directory.");
        }
    }

    // Method to read file and return list of choices
    public static List<String> loadChoicesFromFile(String filePath) {
        List<String> choices = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                choices.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return choices;
    }

    private static void createDirectory(String directoryName) {
        File dir = new File(directoryName);

        // Check if the directory does not exist
        if (!dir.exists()) {
            if (dir.mkdir()) {
                System.out.println("Directory '" + directoryName + "' created successfully.");
            } else {
                System.out.println("Failed to create directory '" + directoryName + "'.");
            }
        } else {
            System.out.println("Directory '" + directoryName + "' already exists.");
        }
    }



    public static void main(String[] args) {
        launch(args);
    }

}
