package se.lexicon;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Responsible for fetching, sorting, and displaying all stored contacts.
 * Provides a clean, numbered list for the user to review.
 */
public class DisplayAllContacts {
    private Scanner scanner = new Scanner(System.in);

    /**
     * Main execution logic for displaying the contact list.
     * Checks for data, sorts alphabetically, and manages the view loop.
     */
    public void run() {
        // Retrieve the shared contact list from the AddContact class
        List<String> contacts = AddContact.getContacts();

        // Immediate exit if there is no data to show
        if (contacts.isEmpty()) {
            System.out.println("\n**** All Contacts ****");
            System.out.println("No contacts found. Your list is empty.");
            return;
        }

        // Standardizes the list by sorting A-Z before display
        Collections.sort(contacts);

        // View loop to keep the list visible until the user explicitly exits
        while (true) {
            displayMenu(contacts);

            String input = "";
            // Internal validation loop for navigation input
            while (true) {
                System.out.print("\n0. ↩ Return to Main Menu: ");
                input = scanner.nextLine().trim().toLowerCase();

                // Only allow "0" to proceed
                if (input.equals("0")) {
                    break;
                }
                System.out.println("Invalid input! Please enter [0] ↩ Return to Main Menu");
            }

            // Return to the application's main menu
            if (input.equals("0")) {
                return;
            }
        }
    }

    /**
     * Prints the formatted contact list with serial numbers.
     * @param contacts The sorted list of contacts to print.
     */
    private void displayMenu(List<String> contacts) {
        System.out.println("\n**** All Contacts (Alphabetical) ****");
        System.out.println("------------------------------------");

        // Iterate through the list and print with 1-based indexing for the user
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println((i + 1) + ". " + contacts.get(i));
        }

        System.out.println("------------------------------------");
        System.out.println("Total contacts: " + contacts.size());
    }
}
