package se.lexicon;

import java.util.Scanner;

public class AddContact {
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        displayMenu();
        getUserChoice();
    }

    private static void displayMenu() {
        System.out.println("\n**** Add new contact ****");
    }
    private int getUserChoice() {
        return Integer.parseInt(scanner.nextLine());
    }


}
