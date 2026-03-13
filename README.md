
# Contact Management System

A Java console application designed to manage personal contacts. This project focuses on clean code structure, modular classes, and robust input handling to prevent application crashes.

## 🚀 Features

*   **Safe Input Handling**: Uses a custom utility class to handle `NumberFormatException` and empty inputs.
*   **Add Contacts**: Save contacts in the format `Name (Mobile)`.
*   **Duplicate Prevention**: Automatically rejects entries that already exist in the list.
*   **Search Functionality**:
  *   Search by **Name** (Case-insensitive).
  *   Search by **Mobile Number**.
*   **Numbered Display**: View all saved contacts with automatic serial numbers.

## 🛠️ Project Structure

The application is built using the following classes in the `se.lexicon` package:


| Class | Responsibility |
| :--- | :--- |
| `Main` | Entry point and main menu loop. |
| `MenuHandler` | Displays the primary navigation menu. |
| `AddContact` | Handles data entry, formatting, and storage in a `Static List`. |
| `DisplayAllContacts` | Iterates through the list and displays formatted output. |
| `SearchByName` | Logic for filtering contacts by name or phone number. |
| `GetUserChoice` | Utility class for safe `Scanner` operations and error handling. |


