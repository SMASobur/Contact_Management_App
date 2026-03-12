package se.lexicon;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    private static MenuHandler menuHandler = new MenuHandler(scanner);
    private static AddContact addContact=new AddContact();
    private static SearchByName searchByName=new SearchByName();
    private static DisplayAllContacts displayAllContacts = new DisplayAllContacts();


    static void main() {
        // Using Java collection
        System.out.println("----Contact Management App----");

        int choice;
        do {
            menuHandler.displayMainMenu();

            choice = menuHandler.getUserChoice();

            switch (choice){
                case 1:
                    addContact.run();
                    break;
                case 2:
                    searchByName.run();
                    break;
                case 3:
                    displayAllContacts.run();
                    break;
                case 0:
                    System.out.println(".....Goodbye!.....");
                    break;
            }

        } while (choice!=0);


    }
}
