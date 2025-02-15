module com.cbarobokings.robokings2025scouting {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires com.google.zxing;
    requires com.google.zxing.javase;


    opens com.cbarobokings.robokings2025scouting to javafx.fxml;

    exports com.cbarobokings.robokings2025scouting;
}