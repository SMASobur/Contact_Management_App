package se.lexicon;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    private static MenuHandler menuHandler = new MenuHandler(scanner);
    private static AddContact addContact=new AddContact();
    private static SearchBy searchBy =new SearchBy();
    private static DisplayAllContacts displayAllContacts = new DisplayAllContacts();
    private static UpdateContact updateContact  =new UpdateContact();


    static void main() {
        // Using Java collection
        System.out.println("----Contact Management App----");

        int choice;
        do {
            menuHandler.displayMainMenu();

            choice = GetUserChoice.getInt(scanner, "");

            switch (choice){
                case 1:
                    addContact.run();
                    break;
                case 2:
                    searchBy.run();
                    break;
                case 3:
                    displayAllContacts.run();
                    break;
                case 4:
                    updateContact.run();
                    break;
                case 0:
                    System.out.println("...*ੈ✩༺Goodbye༻*ੈ✩...");
                    break;
                default:
                    System.out.println("Invalid option. Please choose 1-3 or 0->Exit");
            }
            if (choice != 0) {
                System.out.println();
            }

        } while (choice!=0);


    }
}
