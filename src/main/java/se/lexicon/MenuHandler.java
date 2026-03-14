package se.lexicon;

import java.util.Scanner;

class MenuHandler {
    private Scanner scanner;

    public MenuHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    public void displayMainMenu() {
        System.out.println("\n=== Main Menu ===");
        System.out.println("1. Add Contact");
        System.out.println("2. Search by Name");
        System.out.println("3. Display All Contacts");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
    }

    public void pressEnterToContinue() {
        System.out.print("Press Enter to continue...");
        scanner.nextLine();
    }





}