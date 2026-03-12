package se.lexicon;

import java.util.Scanner;

public class SearchByName {
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        displayMenu();
        int contact = GetUserChoice.getInt(scanner,"");
    }

    private static void displayMenu() {
        System.out.println("\n**** Search by Name ****");
    }


}
