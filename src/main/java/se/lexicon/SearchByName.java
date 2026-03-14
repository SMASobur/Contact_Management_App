package se.lexicon;

import java.util.List;
import java.util.Scanner;

public class SearchByName {
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
            System.out.println("\n**** Search Contacts ****");
            System.out.println("1. Search by Name");
            System.out.println("2. Search by Mobile Number");
            System.out.println("0. Exit to Main Menu");

            int searchType;
            // Inner loop specifically for valid choice input
            while (true) {
                searchType = GetUserChoice.getInt(scanner, "Choose search type: ");

                if (searchType == 0 || searchType == 1 || searchType == 2) {
                    break; // Valid choice, exit inner loop
                }
                System.out.println("Invalid input! Please select 1, 2 or 0.");
            }

            if (searchType == 0) {
                System.out.println("Returning to Main Menu...");
                break; // Exit outer loop to Main
            }

            // Get search term
            System.out.print("Enter search term: ");
            String searchInput = scanner.nextLine().trim().toLowerCase();
            boolean found = false;

            System.out.println("\n--- Search Results ---");
            for (String contact : contacts) {
                String contactLower = contact.toLowerCase();
                if (searchType == 1) {
                    String namePart = contactLower.split(" \\(")[0];
                    if (namePart.contains(searchInput)) {
                        System.out.println(contact);
                        found = true;
                    }
                } else if (searchType == 2) {
                    if (contactLower.contains(searchInput)) {
                        System.out.println(contact);
                        found = true;
                    }
                }
            }

            if (!found) {
                System.out.println("No contacts matched your search.");
            }
            System.out.println("----------------------");
        }
    }


}
