package se.lexicon;

import java.util.Scanner;

class MenuHandler {
    private Scanner scanner;

    public MenuHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    public void displayMainMenu() {
        System.out.println("\n=== Contact Management ===");
        System.out.println("1. Add Contact");
        System.out.println("2. Search by Name");
        System.out.println("3. Display All Contacts");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
    }

    public int getUserChoice() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }


}