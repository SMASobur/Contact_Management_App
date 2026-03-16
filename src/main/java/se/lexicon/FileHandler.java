package se.lexicon;

import java.io.*;
import java.nio.file.*;
import java.util.List;
import java.util.Scanner;

/**
 * Utility class for permanent data storage (File I/O).
 * Handles saving to plain text/CSV and loading data at startup.
 */
public class FileHandler {
    private static final String FILE_NAME = "contacts.txt";

    /**
     * Saves the current contact list to a plain text file.
     * Uses the format "name|mobile" as requested.
     */
    public static void exportToText(List<String> contacts) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (String contact : contacts) {
                // Convert "Name (Mobile)" format to "Name|Mobile" for export
                String plain = contact.replace(" (", "|").replace(")", "");
                writer.println(plain);
            }
            System.out.println("Contacts exported successfully to " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Error saving contacts: " + e.getMessage());
        }
    }

    /**
     * Loads contacts from the file into the application's static list.
     * This should be called once when the application starts.
     */
    public static void importOnStartup(List<String> mainList) {
        Path path = Paths.get(FILE_NAME);
        if (!Files.exists(path)) return; // No file yet, nothing to load

        try (Scanner fileScanner = new Scanner(path)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine().trim();
                if (line.isEmpty()) continue;

                // Convert "Name|Mobile" back to app format "Name (Mobile)"
                if (line.contains("|")) {
                    String[] parts = line.split("\\|");
                    mainList.add(parts[0] + " (" + parts[1] + ")");
                }
            }
            System.out.println("Loaded " + mainList.size() + " contacts from storage.");
        } catch (IOException e) {
            System.out.println("Error loading contacts: " + e.getMessage());
        }
    }
}
