package se.lexicon;

import java.util.List;
import java.util.Scanner;

/**
 * Utility class to handle the deletion logic for contacts.
 * This helper is designed to be called after a search has been performed,
 * ensuring users only delete from a confirmed list of matches.
 */
public class DeleteHelper {
    // Shared scanner for reading confirmation input
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Processes the deletion of a specific contact selected from search results.
     *
     * @param mainList      The master static list containing all contacts.
     * @param searchMatches The temporary sub-list of contacts found during search.
     */
    public static void processDeletion(List<String> mainList, List<String> searchMatches) {
        // Prompt the user for the serial number corresponding to the search results
        int deleteIdx = GetUserChoice.getInt(scanner, "Enter the serial number # to delete (0 to cancel): ");

        // Immediate exit if the user chooses to cancel
        if (deleteIdx == 0) {
            System.out.println("Deletion cancelled.");
            return;
        }

        // Validate that the chosen serial number exists within the search results
        if (deleteIdx > 0 && deleteIdx <= searchMatches.size()) {
            // Retrieve the exact string from the matches (adjusting for 0-based index)
            String target = searchMatches.get(deleteIdx - 1);

            // Safety confirmation step to prevent accidental data loss
            System.out.print("Are you sure you want to delete ❌ '" + target + "'? (y/n): ");

            // Check for 'y' or 'Y' to confirm
            if (scanner.nextLine().trim().equalsIgnoreCase("y")) {
                // Removes the specific object/string from the main static contact list
                mainList.remove(target);
                System.out.println("Contact deleted successfully.");
            } else {
                System.out.println("Deletion cancelled.");
            }
        } else {
            System.out.println("Invalid selection. No contact removed.");
        }
    }
}
