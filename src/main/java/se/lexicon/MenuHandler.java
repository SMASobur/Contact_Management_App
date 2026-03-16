package se.lexicon;

import java.util.Scanner;

/**
 * Handles the display of the application's primary navigation menu.
 * Uses a Scanner instance passed from the Main class for consistency.
 */

class MenuHandler {
    private Scanner scanner;

    public MenuHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    //Prints the interactive main menu options to the console.
    public void displayMainMenu() {
        System.out.println("\n=== Main Menu ===");
        System.out.println("1. \uD83D\uDC64 Add Contact");
        System.out.println("2. \uD83D\uDD0D\uFE0E Search Contact");
        System.out.println("3. \uD83D\uDCD6 Display All Contacts");
        System.out.println("4. \uD83D\uDCDD Update Contacts");
        System.out.println("0. ➜] EXIT");
        System.out.print("Choose an option: ");
    }

}