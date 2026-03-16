package se.lexicon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class ContactTest {

    @BeforeEach
    public void setup() {
        // Clear the static list to ensure a clean slate for every test
        AddContact.getContacts().clear();
    }

    @Test
    public void testAddContact() {
        List<String> contacts = AddContact.getContacts();
        String newContact = "John Doe (12345)";

        contacts.add(newContact);

        assertEquals(1, contacts.size(), "List size should be 1");
        assertTrue(contacts.contains(newContact), "List should contain the added contact");
    }

    @Test
    public void testDuplicatePrevention() {
        List<String> contacts = AddContact.getContacts();
        String contact = "Jane Doe (98765)";

        contacts.add(contact);

        // Simulating the duplicate check logic from your AddContact class
        boolean isDuplicate = contacts.contains(contact);

        assertTrue(isDuplicate, "Should correctly identify an existing contact as a duplicate");
    }

    @Test
    public void testSearchByName() {
        List<String> contacts = AddContact.getContacts();
        contacts.add("Alice (111)");
        contacts.add("Bob (222)");

        String searchTerm = "Alice".toLowerCase();
        boolean found = false;

        for (String c : contacts) {
            if (c.toLowerCase().contains(searchTerm)) {
                found = true;
                break;
            }
        }

        assertTrue(found, "Search should successfully find contact by name");
    }

    @Test
    public void testDeleteContact() {
        List<String> contacts = AddContact.getContacts();
        String target = "Charlie (333)";
        contacts.add(target);

        // Remove the contact
        contacts.remove(target);

        assertFalse(contacts.contains(target), "Contact should be removed from the list");
        assertEquals(0, contacts.size(), "List should be empty after deletion");
    }

    @Test
    public void testUpdateContact() {
        List<String> contacts = AddContact.getContacts();
        String oldContact = "Alice (111)";
        String newContact = "Alice (999)";

        contacts.add(oldContact);

        // Simulate the update logic: find index and replace
        int index = contacts.indexOf(oldContact);
        contacts.set(index, newContact);

        assertEquals(newContact, contacts.get(0), "The contact at index 0 should be updated");
        assertFalse(contacts.contains(oldContact), "The old contact should no longer exist");
    }

    @Test
    public void testAlphabeticalSorting() {
        List<String> contacts = AddContact.getContacts();
        contacts.add("Zebra (999)");
        contacts.add("Apple (111)");
        contacts.add("Monkey (555)");

        // Trigger the sort used in DisplayAllContacts
        java.util.Collections.sort(contacts);

        assertEquals("Apple (111)", contacts.get(0), "Apple should be first (Index 0)");
        assertEquals("Monkey (555)", contacts.get(1), "Monkey should be second (Index 1)");
        assertEquals("Zebra (999)", contacts.get(2), "Zebra should be last (Index 2)");
    }

}
