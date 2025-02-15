package com.cbarobokings.robokings2025scouting;

import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

import java.util.function.UnaryOperator;
import java.util.regex.Pattern;

public class NumericTextFieldFilter {

    public static void applyNumericFilter(TextField textField) {
        Pattern pattern = Pattern.compile("\\d*"); // Only digits (0-9)

        UnaryOperator<TextFormatter.Change> filter = change -> {
            if (pattern.matcher(change.getControlNewText()).matches()) {
                return change; // Accept change if it matches the pattern
            }
            return null; // Reject change
        };

        TextFormatter<String> textFormatter = new TextFormatter<>(filter);
        textField.setTextFormatter(textFormatter);
    }
}