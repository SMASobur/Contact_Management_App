package se.lexicon;

import java.util.Scanner;

/**
 * Entry point for the Contact Management Application.
 * Handles the main application loop and navigation between features.
 */
public class Main {
    private static Scanner scanner = new Scanner(System.in);

    // Feature modules initialized as static members
    private static MenuHandler menuHandler = new MenuHandler(scanner);
    private static AddContact addContact = new AddContact();
    private static SearchBy searchBy = new SearchBy();
    private static DisplayAllContacts displayAllContacts = new DisplayAllContacts();
    private static UpdateContact updateContact = new UpdateContact();

    /**
     * Standard Java main method to launch the application.
     */
    public static void main(String[] args) {
        System.out.println("---- Contact Management App ----");

        int choice;
        do {
            menuHandler.displayMainMenu();

            choice = GetUserChoice.getInt(scanner, "Choice: ");

            switch (choice) {
                case 1:
                    addContact.run(); // Create new contact
                    break;
                case 2:
                    searchBy.run(); // Search and/or Delete contacts
                    break;
                case 3:
                    displayAllContacts.run(); // View and Sort all contacts
                    break;
                case 4:
                    updateContact.run(); // Edit existing contacts
                    break;
                case 0:
                    System.out.println("...*ੈ✩༺ Goodbye ༻*ੈ✩...");
                    break;
                default:
                    // Fallback for numbers not defined in the menu
                    System.out.println("Invalid option. Please choose 1-4 or 0 to Exit.");
            }

            // Add a line break for better visual separation between operations
            if (choice != 0) {
                System.out.println();
            }

        } while (choice != 0); // Keep application running until user chooses 0
    }
}
