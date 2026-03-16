# Contact Management System

A robust Java console application for managing personal contacts. This project demonstrates clean code architecture, modular design, and advanced data handling including File I/O and Unit Testing.

##  Key Features

*   **Data Persistence (File I/O)**:
    *   **Auto-Import**: Automatically loads saved contacts from `contacts.txt` on startup.
    *   **Export**: Saves contacts to plain text in the `name|mobile` format for portability.
*   **Full CRUD Operations**:
    *   **Create**: Add contacts with "Name (Mobile)" formatting and duplicate rejection.
    *   **Read**: View an alphabetically sorted list with serial numbers.
    *   **Update**: Modify existing contact names, numbers, or both via search.
    *   **Delete**: Remove specific contacts with a safety confirmation prompt.
*   **Smart Search**: Case-insensitive searching by Name (whole word matching) or Mobile Number.
*   **Error-Resistant Input**: Custom utility handles `NumberFormatException` and empty inputs to prevent crashes.
*   **Quality Assurance**: Comprehensive JUnit 5 test suite covering all data access operations.

## 🛠️ Project Structure


| Class | Responsibility |
| :--- | :--- |
| `Main` | Entry point, startup import logic, and main menu loop. |
| `MenuHandler` | Manages primary navigation and emoji-based UI. |
| `AddContact` | Handles data entry and stores contacts in a static `ArrayList`. |
| `DisplayAllContacts` | Alphabetical sorting and numbered display of entries. |
| `SearchBy` | Search logic with integrated deletion options. |
| `UpdateContact` | Logic for modifying existing data with duplicate validation. |
| `DeleteHelper` | Reusable utility for safe, confirmed contact removal. |
| `FileHandler` | Manages Export/Import logic using Java File I/O. |
| `GetUserChoice` | Central utility for validated integer and string input. |

## 🧪 Unit Testing

The project includes a `ContactTest` suite using **JUnit 5** to verify:
- Successful Addition & Duplicate Prevention.
- Case-insensitive Search accuracy.
- Alphabetical Sorting integrity.
- Successful Update & Deletion of records.

