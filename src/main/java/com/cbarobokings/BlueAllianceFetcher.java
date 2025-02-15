package com.cbarobokings;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class BlueAllianceFetcher {
    public static void main(String[] args) {
        try {
            // Folder name
            String folderName = "robokingsscouting";

            // File for config
            File configFile = new File(folderName, "config.txt");

            // Read API key and event key from config.txt
            String apiKey = "";
            String eventKey = "";

            if (configFile.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(configFile));

                // Read first line for API key
                apiKey = reader.readLine();

                // Skip the second line (empty)
                reader.readLine();

                // Read third line for event key
                eventKey = reader.readLine();

                reader.close();
            } else {
                System.out.println("config.txt not found in the directory: " + folderName);
                return;
            }

            // Check if API key and event key are found
            if (apiKey.isEmpty() || eventKey.isEmpty()) {
                System.out.println("API key or event key is missing in config.txt.");
                return;
            }

            // Check if the folder exists, if not, create it
            File folder = new File(folderName);
            if (!folder.exists()) {
                folder.mkdir();  // Create the directory if it doesn't exist
                System.out.println("Directory created: " + folderName);
            }

            String urlString = "https://www.thebluealliance.com/api/v3/event/" + eventKey + "/teams";
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set request method and API key header
            connection.setRequestMethod("GET");
            connection.setRequestProperty("X-TBA-Auth-Key", apiKey); // API key in header
            connection.connect();

            // Check the response code
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // If the response code is 200 (HTTP_OK), we can read the response
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                // Read the response line by line
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Parse the JSON response
                JSONArray teams = new JSONArray(response.toString());

                // Create a file to save the team numbers
                File file = new File(folder, "eventTeams.txt");
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));

                // Iterate over the teams array and write just the team numbers to the file
                for (int i = 0; i < teams.length(); i++) {
                    JSONObject team = teams.getJSONObject(i);
                    int teamNumber = team.getInt("team_number");  // Get the team number as an integer
                    writer.write(String.valueOf(teamNumber));  // Convert the integer to a string and write to file
                    writer.newLine();  // Add a new line after each team number
                }

                writer.close();
                System.out.println("Team list saved to: " + file.getAbsolutePath());
            } else {
                System.out.println("Failed to fetch data. Response Code: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
