package se.lexicon;

import java.util.Scanner;

/**
 * Utility class to provide safe and robust user input handling.
 * Prevents the application from crashing due to non-numeric or empty inputs.
 */
public class GetUserChoice {

    /**
     * Repeatedly prompts the user for an integer until a valid one is provided.
     *
     * @param scanner The shared Scanner instance used to read input.
     * @param prompt  The message displayed to the user requesting input.
     * @return A validated integer provided by the user.
     */
    public static int getInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();

            // Check if the user just pressed Enter or typed only spaces
            if (input.trim().isEmpty()) {
                System.out.println("Input cannot be empty.");
                continue; // Restart the loop to ask again
            }

            try {
                // Attempt to convert the string input into an integer
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                // Catches errors if the input contains letters or symbols
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }
}
