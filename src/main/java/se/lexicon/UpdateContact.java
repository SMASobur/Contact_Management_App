package se.lexicon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Handles the logic for modifying existing contact information.
 * Allows users to find a contact via search and update specific fields.
 */
public class UpdateContact {
    private Scanner scanner = new Scanner(System.in);

    /**
     * Entry point for the Update feature.
     * Manages the search-and-select flow to identify which contact to edit.
     */
    public void run() {
        List<String> contacts = AddContact.getContacts();

        // Immediate exit if no data exists to update
        if (contacts.isEmpty()) {
            System.out.println("\n**** Update Contact ****");
            System.out.println("The list is empty. Nothing to update.");
            return;
        }

        while (true) {
            System.out.println("\n**** Update Contact ****");
            System.out.print("Search for the contact to update (or 0 to cancel): ");
            String term = scanner.nextLine().trim().toLowerCase();

            if (term.equals("0")) break; // Return to Main Menu

            // 1. Filter the main list into a sub-list of potential matches
            List<String> matches = new ArrayList<>();
            System.out.println("\n--- Search Results ---");
            for (String contact : contacts) {
                if (contact.toLowerCase().contains(term)) {
                    matches.add(contact);
                    System.out.println(matches.size() + ". " + contact);
                }
            }

            // Prompt user again if search yielded no results
            if (matches.isEmpty()) {
                System.out.println("No matching contacts found.");
                continue;
            }

            // 2. Identify the specific contact to edit using the search result index
            int selection = GetUserChoice.getInt(scanner, "\nEnter serial number to update (0 to cancel): ");
            if (selection == 0) continue;

            if (selection > 0 && selection <= matches.size()) {
                String original = matches.get(selection - 1);
                performUpdate(original, contacts);
                break; // Exit to main menu after a successful update operation
            } else {
                System.out.println("Invalid selection.");
            }
        }
    }

    /**
     * Performs the actual string manipulation and validation for the update.
     * @param original The string as it currently exists in the list.
     * @param mainList The global contact list where changes will be saved.
     */
    private void performUpdate(String original, List<String> mainList) {
        // Parse current data by splitting the "Name (Mobile)" format
        // Extracts name (everything before the last space-parenthesis)
        String currentName = original.substring(0, original.lastIndexOf(" ("));
        // Extracts mobile (everything inside the parentheses)
        String currentMobile = original.substring(original.lastIndexOf("(") + 1, original.lastIndexOf(")"));

        System.out.println("\nUpdating: " + original);

        int choice;
        // Validation loop to ensure a valid menu option is selected
        while (true) {
            System.out.println("1. Update Name | 2. Update Mobile | 3. Both | 0. Cancel");
            choice = GetUserChoice.getInt(scanner, "Choice: ");

            if (choice >= 0 && choice <= 3) {
                break;
            }
            System.out.println("Invalid choice! Please select 1, 2, 3 or 0.");
        }

        if (choice == 0) {
            System.out.println("Update cancelled.");
            return;
        }

        String newName = currentName;
        String newMobile = currentMobile;

        // Gather new data based on the user's specific update choice
        if (choice == 1 || choice == 3) {
            System.out.print("Enter new Name: ");
            newName = scanner.nextLine().trim();
        }
        if (choice == 2 || choice == 3) {
            // Force integer validation for the mobile number
            newMobile = String.valueOf(GetUserChoice.getInt(scanner, "Enter new Mobile: "));
        }

        // 3. Final Validation & Data Integrity Check
        String updated = newName + " (" + newMobile + ")";

        if (newName.isEmpty()) {
            System.out.println("Error: Name cannot be empty.");
        }
        // Ensure the change doesn't conflict with another existing contact
        else if (mainList.contains(updated) && !updated.equals(original)) {
            System.out.println("Error: This contact already exists.");
        } else {
            // Replace the old string with the updated version at the same index
            int index = mainList.indexOf(original);
            mainList.set(index, updated);
            System.out.println("Update Successful! ✅\nResult: " + updated);
        }
    }
}
