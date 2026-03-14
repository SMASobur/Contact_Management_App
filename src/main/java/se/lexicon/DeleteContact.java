package se.lexicon;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class DeleteContact {
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        List<String> contacts = AddContact.getContacts();

        while (true) {
            System.out.println("\n**** Delete a Contact ****");
            if (contacts.isEmpty()) {
                System.out.println("The list is empty. Returning to menu.");
                return;
            }

            System.out.print("Enter Name or Mobile to delete (or 0 to cancel): ");
            String term = scanner.nextLine().trim();

            if (term.equals("0")) {
                System.out.println("Returning to Main Menu...");
                break;
            }

            // Word-boundary regex for exact word match
            String regex = "(?i).*\\b" + Pattern.quote(term) + "\\b.*";
            String foundContact = null;

            for (String contact : contacts) {
                if (contact.matches(regex)) {
                    foundContact = contact;
                    break;
                }
            }

            if (foundContact != null) {
                System.out.println("Matching contact found: " + foundContact);
                System.out.print("❌ Confirm deletion? (yes/no): ");
                if (scanner.nextLine().trim().equalsIgnoreCase("yes")) {
                    contacts.remove(foundContact);
                    System.out.println("Contact deleted successfully.");
                    break; // Exit after successful deletion
                } else {
                    System.out.println("Deletion cancelled. Try again.");
                }
            } else {
                // If not found, the loop repeats and asks again
                System.out.println("No exact word match found for: " + term);
                System.out.println("Please try again or enter 0 to exit.");
            }
        }
    }
}
