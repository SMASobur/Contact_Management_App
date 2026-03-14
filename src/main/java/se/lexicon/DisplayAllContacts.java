package se.lexicon;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DisplayAllContacts {
    private static DeleteContact deleteContact = new DeleteContact();
    private Scanner scanner = new Scanner(System.in);


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
            return;
        }
            System.out.println("Contact List:");
            System.out.println("----------------------");

            for (int i=0; i<contacts.size(); i++){
                System.out.println((i+1) + ". " + contacts.get(i) );
            }

            System.out.println("----------------------");
            System.out.println("Total contacts: " + contacts.size());
            System.out.println();
            System.out.println("Want to delete contact? Type d");
            String isDelete = scanner.nextLine().trim().toLowerCase();
            if (isDelete.equals("d")){
                deleteContact.run();
            }


    }
}
