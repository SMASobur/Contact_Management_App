package se.lexicon;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DisplayAllContacts {
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        List<String> contacts = AddContact.getContacts();

        if (contacts.isEmpty()) {
            System.out.println("\n**** All Contacts ****");
            System.out.println("No contacts found. Your list is empty.");
            return;
        }


        Collections.sort(contacts);

        while (true) {
            displayMenu(contacts);



            String input = "";
            while (true) {
                System.out.print("\n0. ↩ Return to Main Menu: ");
                input = scanner.nextLine().trim().toLowerCase();

                if (input.equals("0")) {
                    break;
                }
                System.out.println("Invalid input! Please enter [0] ↩ Return to Main Menu");
            }

            if (input.equals("0")) {
                return;
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
