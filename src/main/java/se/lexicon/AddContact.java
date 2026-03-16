package se.lexicon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Handles the logic for creating and storing new contacts.
 * Uses a static list to ensure data persists during the application's lifecycle.
 */
public class AddContact {
    private Scanner scanner = new Scanner(System.in);

    // Static list stores contacts in "Name (Mobile)" format across all instances
    private static List<String> contactList = new ArrayList<>();


    public void run() {
        boolean continueAdding = true;

        while (continueAdding) {
            // Execute the actual data entry logic
            addProcess();

            System.out.println("\n1. + Add another new contact.");
            System.out.println("0. ↩ Return to Main Menu.");

            int choice;
            // Internal validation loop to force a correct choice of 1 or 0
            while (true) {
                choice = GetUserChoice.getInt(scanner, "Choice: ");
                if (choice == 0 || choice == 1) break;
                System.out.println("Invalid input! Please type [1] to add more or [0] to return.");
            }

            if (choice == 0) {
                System.out.println("Returning to Main Menu.");
                continueAdding = false;
            }
        }
    }

    private void addProcess() {
        System.out.println("\n**** Add a new contact ****");

        System.out.print("Enter Name: ");
        String name = scanner.nextLine().trim();

        // Use utility to ensure mobile is a valid integer before proceeding
        int mobile = GetUserChoice.getInt(scanner, " 📞 Enter Mobile: ");
        String combineContact = name + " (" + mobile + ")";

        // Validation: Prevent empty names and duplicate entries
        if (name.isEmpty()) {
            System.out.println("Error: Name cannot be empty.");
        } else if (contactList.contains(combineContact)) {
            System.out.println("Error: This contact already exists.");
        } else {
            contactList.add(combineContact);
            System.out.println("Contact added successfully: " + combineContact);
        }
    }

    /**
     * Provides global access to the contact list for other classes (Search, Display, Update).
     * @return The static list of contact strings.
     */
    public static List<String> getContacts() {
        return contactList;
    }
}
