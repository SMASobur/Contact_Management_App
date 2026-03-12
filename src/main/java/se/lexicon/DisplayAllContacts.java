package se.lexicon;

import java.util.List;

public class DisplayAllContacts {

    public void run() {
        displayMenu();


    }

    private void displayMenu() {
        System.out.println("\n**** Display all contacts ****");
        List<String> contacts = AddContact.getContacts();

        if (contacts.isEmpty()) {
            System.out.println("No contacts found. Your list is empty.");
        } else {
            System.out.println("Contact List:");
            System.out.println("----------------------");

            for (String contact : contacts) {
                System.out.println(contact);
            }

            System.out.println("----------------------");
            System.out.println("Total contacts: " + contacts.size());
        }
    }
}
