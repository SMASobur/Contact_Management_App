package se.lexicon;

import java.util.Scanner;

public class AddContact {
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        displayMenu();

        int contact = GetUserChoice.getInt(scanner,"");
    }

    private void displayMenu() {
        System.out.println("\n**** Add new contact ****");
    }
}
