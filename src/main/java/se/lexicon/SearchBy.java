package se.lexicon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchBy {
    private static Scanner scanner = new Scanner(System.in);

    public void run() {
        List<String> contacts = AddContact.getContacts();
        if (contacts.isEmpty()) {
            System.out.println("\n**** Search Contacts ****");
            System.out.println("The contact list is empty!");
            return;
        }
        displayMenu(contacts);
    }

    private static void displayMenu(List<String> contacts) {
        while (true) {
            // Check if list became empty during a deletion
            if (contacts.isEmpty()) {
                System.out.println("All contacts have been deleted. Returning to menu.");
                break;
            }

            System.out.println("\n**** Search Contacts ****");
            System.out.println("1. 1️⃣ Search by Name");
            System.out.println("2. 🔢 Search by Mobile Number");
            System.out.println("0. ↩ Return to Main Menu");

            int searchType;
            while (true) {
                searchType = GetUserChoice.getInt(scanner, "Choose search type: ");
                if (searchType >= 0 && searchType <= 2) break;
                System.out.println("Invalid input! Please select 1, 2 or 0.");
            }

            if (searchType == 0) break;

            System.out.print("Enter search term: ");
            String searchInput = scanner.nextLine().trim().toLowerCase();

            // New List to keep track of ONLY the matches found
            List<String> matches = new ArrayList<>();

            System.out.println("\n--- Search Results ---");
            for (String contact : contacts) {
                String contactLower = contact.toLowerCase();
                boolean isMatch = false;

                if (searchType == 1) {
                    String namePart = contactLower.split(" \\(")[0];
                    if (namePart.contains(searchInput)) isMatch = true;
                } else if (searchType == 2) {
                    if (contactLower.contains(searchInput)) isMatch = true;
                }

                if (isMatch) {
                    matches.add(contact);
                    System.out.println(matches.size() + ". " + contact);
                }
            }

            if (matches.isEmpty()) {
                System.out.println("No contacts matched your search.");
                System.out.println("----------------------");
                continue;
            }

            // --- NEW: Delete Process within Search ---
            System.out.println("----------------------");
            System.out.println("Options: [d] Delete a result | [Enter] Search again");
            System.out.print("Choice: ");
            String action = scanner.nextLine().trim().toLowerCase();

            if (action.equals("d")) {
                int deleteIdx = GetUserChoice.getInt(scanner, "Enter the serial number # to delete (0 to cancel): ");
                if (deleteIdx > 0 && deleteIdx <= matches.size()) {
                    String target = matches.get(deleteIdx - 1);
                    System.out.print("Are you sure you want to delete ❌ '" + target + "'? (y/n): ");
                    if (scanner.nextLine().trim().equalsIgnoreCase("y")) {
                        contacts.remove(target); // Remove from the main static list
                        System.out.println("Contact deleted successfully.");
                    }
                } else {
                    System.out.println("Invalid selection. Deletion cancelled.");
                }
            }
        }
    }
}
