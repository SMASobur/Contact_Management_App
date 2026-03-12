package se.lexicon;

import java.util.Scanner;

public class GetUserChoice {

    public static int getInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();

            if (input.trim().isEmpty()) {
                System.out.println("Input cannot be empty.");
                continue;
            }

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }
}
