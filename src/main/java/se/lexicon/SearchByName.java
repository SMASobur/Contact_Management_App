package se.lexicon;

import java.util.List;
import java.util.Scanner;

public class SearchByName {
    private static Scanner scanner = new Scanner(System.in);

    public void run() {

        List<String> contacts = AddContact.getContacts();
        displayMenu(contacts);


    }

    private static void displayMenu(List<String> contacts) {
        System.out.println("\n**** Search by Name ****");

        if (contacts.isEmpty()){
            System.out.println("The contact list is empty.!! ");
            return;
        }

        System.out.println("1. Search by Name");
        System.out.println("2. Search by Mobile Number");
        System.out.println("0. Exit");
        int searchType = GetUserChoice.getInt(scanner, "Choose search type: ");

        if (searchType==0){
            System.out.println("Exiting.... Return to Main Menu.");
        }else {
            System.out.println("Enter Name/Mobile number to search: ");
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
    }


}
