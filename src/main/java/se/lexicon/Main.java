package se.lexicon;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    private static MenuHandler menuHandler = new MenuHandler(scanner);


    static void main() {
        // Using Java collection
        System.out.println("----Contact Management App----");

        int choice;
        do {
            menuHandler.displayMainMenu();

            choice = menuHandler.getUserChoice();

        } while (choice!=0);


    }
}
