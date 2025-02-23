package com.cbarobokings.robokings2025scouting;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class FontLoader {
    public static void main(String[] args) {
        try {
            // Load the font file (Ensure the path is correct)
            File fontFile = new File("robokingsscouting/BerlinSansFB.ttf"); // e.g., "C:/fonts/MyFont.ttf"
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, fontFile);

            // Set font size
            customFont = customFont.deriveFont(24f);

            // Register the font in the system (optional)
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);

        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
    }
}
