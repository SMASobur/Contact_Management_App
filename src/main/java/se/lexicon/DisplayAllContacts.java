package se.lexicon;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DisplayAllContacts {
    private static DeleteContact deleteContact = new DeleteContact();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        List<String> contacts = AddContact.getContacts();

        if (contacts.isEmpty()) {
            System.out.println("\n**** All Contacts ****");
            System.out.println("No contacts found. Your list is empty.");
            return;
        }


        Collections.sort(contacts);
        boolean showing = true;

        while (showing) {
            displayMenu(contacts);

            System.out.println("\nOptions:");
            System.out.println("Type 'd' to delete a contact");
            System.out.println("Type '0' to return to Main Menu");

            String input = "";
            while (true) {
                System.out.print("Choice: ");
                input = scanner.nextLine().trim().toLowerCase();

                if (input.equals("d") || input.equals("0")) {
                    break;
                }
                System.out.println("Invalid choice. Please type 'd' or '0'.");
            }

            if (input.equals("0")) {
                showing = false;
            } else if (input.equals("d")) {
                deleteContact.run();

                if (contacts.isEmpty()) {
                    System.out.println("No contacts left. Returning to Main Menu.");
                    showing = false;
                } else {
                    Collections.sort(contacts);
                }
            }
        }
    }


    private void displayMenu(List<String> contacts) {
        System.out.println("\n**** All Contacts (Alphabetical) ****");
            System .out.println("------------------------------------");
            for (int i = 0; i < contacts.size(); i++) {
                System.out.println((i + 1) + ". " + contacts.get(i));
            }
            System.out.println("------------------------------------");
            System.out.println("Total contacts: " + contacts.size());

    }
}
