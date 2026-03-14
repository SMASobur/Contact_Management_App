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

            addProcess();

            System.out.println("\n1. + Add another new contact.");
            System.out.println("0. ↩ Return to Main Menu.");

            int choice;

            while (true){

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

        int mobile = GetUserChoice.getInt(scanner, " \uD83D\uDCDE Enter Mobile: ");

        // Convert the int to a String for storage
        String combineContact = name + " (" + mobile + ")";

        if (name.isEmpty()) {
            System.out.println("Error: Name cannot be empty.");
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
