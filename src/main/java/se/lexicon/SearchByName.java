package se.lexicon;

import java.util.List;
import java.util.Scanner;

public class SearchByName {
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        displayMenu();

        List<String> contacts = AddContact.getContacts();

        if (contacts.isEmpty()){
            System.out.println("The contact list is empty.!! ");
            return;
        }

        System.out.println("1. Search by Name");
        System.out.println("2. Search by Mobile Number");
        int searchType = GetUserChoice.getInt(scanner, "Choose search type: ");

        System.out.println("Enter Name/Mobile to Search: ");
        String searchInput = scanner.nextLine().toLowerCase();
        boolean found =false;

        System.out.println("\n--- Search Results ---");


        for (String contact: contacts){
            String contactLower = contact.toLowerCase();

            if (searchType == 1){
                String namePart = contactLower.split("\\(")[0];
                if (namePart.contains(searchInput)){
                    System.out.println(contact);
                    found = true;
                }

            } else if (searchType==2){
                if (contactLower.contains("(" + searchInput) || contactLower.contains(searchInput + ")")){
                    System.out.println(contact);
                    found = true;
                }
            }

        }


        if (!found) {
            System.out.println("No contacts matched your search.");

        }
    }

    private static void displayMenu() {
        System.out.println("\n**** Search by Name ****");
    }


}
