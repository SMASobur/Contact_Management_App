package se.lexicon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddContact {
    private Scanner scanner = new Scanner(System.in);
    private static List<String> contactList = new ArrayList<>();

    public void run() {
        boolean continueAdding = true;

        while (continueAdding) {
            displayMenu();

            // Ask to continue or exit
            System.out.println("\nPress 1 to add another contact, or 0 to return to Main Menu.");
            int choice = GetUserChoice.getInt(scanner, "Choice: ");
            if (choice == 0) {
                System.out.println("Exiting.... Return to Main Menu.");
                continueAdding = false;
            }
        }
    }

    private void displayMenu() {
        System.out.println("\n**** Add a new contact ****");
        System.out.print("Enter Name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter Mobile: ");
        String mobile = scanner.nextLine().trim();

        String combineContact = name + " (" + mobile + ")";
        if (name.isEmpty() || mobile.isEmpty()) {
            System.out.println("Error: Name and Mobile can not be empty.");
        } else if (contactList.contains(combineContact)) {
            System.out.println("Error: This contact already exists.");
        } else {
            contactList.add(combineContact);
            System.out.println("Contact added successfully: " + combineContact);
        }

    }

    public static List<String> getContacts() {
        return contactList;
    }
}
