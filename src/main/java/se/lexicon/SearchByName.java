package se.lexicon;

import java.util.Scanner;

public class SearchByName {
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        displayMenu();
        getUserChoice();
    }

    private static void displayMenu() {
        System.out.println("\n**** Search by Name ****");
    }
    private int getUserChoice() {
        return Integer.parseInt(scanner.nextLine());
    }


}
