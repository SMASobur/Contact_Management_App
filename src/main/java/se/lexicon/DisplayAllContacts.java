package se.lexicon;

import java.util.Collections;
import java.util.List;

public class DisplayAllContacts {

    public void run() {

        List<String> contacts = AddContact.getContacts();

        //To Sort alphabetically (A-Z)
        Collections.sort(contacts);

        displayMenu(contacts);


    }

    private void displayMenu(List<String> contacts) {
        System.out.println("\n**** Display all contacts ****");

        if (contacts.isEmpty()) {
            System.out.println("No contacts found. Your list is empty.");
        } else {
            System.out.println("Contact List:");
            System.out.println("----------------------");

            for (int i=0; i<contacts.size(); i++){
                System.out.println((i+1) + ". " + contacts.get(i) );
            }

            System.out.println("----------------------");
            System.out.println("Total contacts: " + contacts.size());
        }
    }
}
