package se.lexicon;

import java.util.List;
import java.util.Scanner;

public class DeleteHelper {
    private static Scanner scanner = new Scanner(System.in);

    public static void processDeletion(List<String> mainList, List<String> searchMatches) {
        int deleteIdx = GetUserChoice.getInt(scanner, "Enter the serial number # to delete (0 to cancel): ");

        if (deleteIdx == 0) {
            System.out.println("Deletion cancelled.");
            return;
        }

        if (deleteIdx > 0 && deleteIdx <= searchMatches.size()) {
            String target = searchMatches.get(deleteIdx - 1);
            System.out.print("Are you sure you want to delete ❌ '" + target + "'? (y/n): ");

            if (scanner.nextLine().trim().equalsIgnoreCase("y")) {
                mainList.remove(target); // Removes the actual string from the static list
                System.out.println("Contact deleted successfully.");
            } else {
                System.out.println("Deletion cancelled.");
            }
        } else {
            System.out.println("Invalid selection. No contact removed.");
        }
    }
}
