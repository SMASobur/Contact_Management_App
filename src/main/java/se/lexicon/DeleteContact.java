package se.lexicon;

import java.util.List;
import java.util.Scanner;

public class DeleteContact {
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        System.out.println("\n**** Delete a Contact ****");
        List<String> contacts = AddContact.getContacts();

        if (contacts.isEmpty()) {
            System.out.println("The list is empty. Nothing to delete.");
            return;
        }

        System.out.print("Enter Name or Mobile to find for deletion: ");
        String term = scanner.nextLine().trim().toLowerCase();

        String foundContact = null;
        for (String contact : contacts) {
            if (contact.toLowerCase().contains(term)) {
                foundContact = contact;
                break;
            }
        }


        if (foundContact != null) {
            System.out.println("Matching contact found: " + foundContact);
            System.out.print("Are you sure you want to delete this? (yes/no): ");
            String confirmation = scanner.nextLine().trim().toLowerCase();

            if (confirmation.equals("yes")) {
                contacts.remove(foundContact);
                System.out.println("Contact deleted successfully.");
            } else {
                System.out.println("Deletion cancelled.");
            }
        } else {
            System.out.println("No contact found matching: " + term);
        }
    }
}
