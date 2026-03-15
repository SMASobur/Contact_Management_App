package se.lexicon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UpdateContact {
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        List<String> contacts = AddContact.getContacts();
        if (contacts.isEmpty()) {
            System.out.println("\n**** Update Contact ****");
            System.out.println("The list is empty. Nothing to update.");
            return;
        }

        while (true) {
            System.out.println("\n**** Update Contact ****");
            System.out.print("Search for the contact to update (or 0 to cancel): ");
            String term = scanner.nextLine().trim().toLowerCase();

            if (term.equals("0")) break;

            // Collect and Display Matches
            List<String> matches = new ArrayList<>();
            System.out.println("\n--- Search Results ---");
            for (String contact : contacts) {
                if (contact.toLowerCase().contains(term)) {
                    matches.add(contact);
                    System.out.println(matches.size() + ". " + contact);
                }
            }

            if (matches.isEmpty()) {
                System.out.println("No matching contacts found.");
                continue;
            }

            // Select by Serial Number
            int selection = GetUserChoice.getInt(scanner, "\nEnter serial number to update (0 to cancel): ");
            if (selection == 0) continue;

            if (selection > 0 && selection <= matches.size()) {
                String original = matches.get(selection - 1);
                performUpdate(original, contacts);
                break; // Exit to main menu after successful update
            } else {
                System.out.println("Invalid selection.");
            }
        }
    }

    private void performUpdate(String original, List<String> mainList) {
        // Parse current data: "Name (Mobile)"
        String currentName = original.substring(0, original.lastIndexOf(" ("));
        String currentMobile = original.substring(original.lastIndexOf("(") + 1, original.lastIndexOf(")"));

        System.out.println("\nUpdating: " + original);

        int choice;
        while (true){
            System.out.println("1. Update Name | 2. Update Mobile | 3. Both | 0. Cancel");
            choice = GetUserChoice.getInt(scanner, "Choice: ");

            if (choice>=0 && choice<=3) {
                break;
            }System.out.println("Invalid choice! Please select 1, 2, 3 or 0.");
        }
        if (choice==0){
            System.out.println("Update cancelled.");
            return;
        }


        String newName = currentName;
        String newMobile = currentMobile;

        if (choice == 1 || choice == 3) {
            System.out.print("Enter new Name: ");
            newName = scanner.nextLine().trim();
        }
        if (choice == 2 || choice == 3) {
            newMobile = String.valueOf(GetUserChoice.getInt(scanner, "Enter new Mobile: "));
        }
        if (choice == 0) return;

        // Validation
        String updated = newName + " (" + newMobile + ")";
        if (newName.isEmpty()) {
            System.out.println("Error: Name cannot be empty.");
        } else if (mainList.contains(updated) && !updated.equals(original)) {
            System.out.println("Error: This contact already exists.");
        } else {
            // Replace in main list
            int index = mainList.indexOf(original);
            mainList.set(index, updated);
            System.out.println("Update Successful! ✅\nResult: " + updated);
        }
    }
}
