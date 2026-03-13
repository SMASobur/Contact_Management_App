package se.lexicon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddContact {
    private Scanner scanner = new Scanner(System.in);

    private static List<String> contactList = new ArrayList<>();

    public void run() {
        displayMenu();

       // int contact = GetUserChoice.getInt(scanner,"");

        System.out.print("Enter Name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter Mobile: ");
        String mobile = scanner.nextLine().trim();

        String combineContact = name + " (" +mobile + ")";

        if (contactList.contains(combineContact)){
            System.out.println("Error: This contact already exists.");
        } else if (name.isEmpty() ||mobile.isEmpty()){
            System.out.println("Error: Name or Mobile can not be empty.");
        } else {
           contactList.add(combineContact);
            System.out.println("Contact added successfully: " + combineContact);
        }

    }

    private void displayMenu() {
        System.out.println("\n**** Add a new contact ****");
    }

    public static List<String> getContacts() {
        return contactList;
    }

}
