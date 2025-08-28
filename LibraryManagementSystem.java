import java.util.ArrayList;
import java.util.Scanner;

// Book class to store details of each book
class Book {
    String title;
    String author;
    String isbn;

    Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    void displayBook() {
        System.out.println("Title: " + title + ", Author: " + author + ", ISBN: " + isbn);
    }
}

public class LibraryManagementSystem {
    static ArrayList<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book by Title");
            System.out.println("4. Remove Book by ISBN");
            System.out.println("5. Update Book by ISBN");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    viewBooks();
                    break;
                case 3:
                    searchBook();
                    break;
                case 4:
                    removeBook();
                    break;
                case 5:
                    updateBook();
                    break;
                case 6:
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 6);
    }

    // Create: Add a new book
    public static void addBook() {
        System.out.print("Enter book title: ");
        String title = sc.nextLine();
        System.out.print("Enter author name: ");
        String author = sc.nextLine();
        System.out.print("Enter ISBN: ");
        String isbn = sc.nextLine();

        Book newBook = new Book(title, author, isbn);
        books.add(newBook);
        System.out.println("Book added successfully!");
    }

    // Read: View all books
    public static void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
        } else {
            System.out.println("\nList of Books:");
            for (Book b : books) {
                b.displayBook();
            }
        }
    }

    // Read/Search: Find book by title
    public static void searchBook() {
        System.out.print("Enter book title to search: ");
        String searchTitle = sc.nextLine();
        boolean found = false;

        for (Book b : books) {
            if (b.title.equalsIgnoreCase(searchTitle)) {
                System.out.println("Book Found:");
                b.displayBook();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Book not found!");
        }
    }

    // Delete: Remove book by ISBN
    public static void removeBook() {
        System.out.print("Enter ISBN of the book to remove: ");
        String removeIsbn = sc.nextLine();
        boolean removed = false;

        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).isbn.equalsIgnoreCase(removeIsbn)) {
                books.remove(i);
                System.out.println("Book removed successfully!");
                removed = true;
                break;
            }
        }

        if (!removed) {
            System.out.println("Book with given ISBN not found.");
        }
    }

    // Update: Modify book details by ISBN
    public static void updateBook() {
        System.out.print("Enter ISBN of the book to update: ");
        String updateIsbn = sc.nextLine();
        boolean updated = false;

        for (Book b : books) {
            if (b.isbn.equalsIgnoreCase(updateIsbn)) {
                System.out.println("Book Found:");
                b.displayBook();

                System.out.print("Enter new title (leave blank to keep unchanged): ");
                String newTitle = sc.nextLine();
                if (!newTitle.isEmpty()) {
                    b.title = newTitle;
                }

                System.out.print("Enter new author (leave blank to keep unchanged): ");
                String newAuthor = sc.nextLine();
                if (!newAuthor.isEmpty()) {
                    b.author = newAuthor;
                }

                System.out.print("Enter new ISBN (leave blank to keep unchanged): ");
                String newIsbn = sc.nextLine();
                if (!newIsbn.isEmpty()) {
                    b.isbn = newIsbn;
                }

                System.out.println("Book details updated successfully!");
                updated = true;
                break;
            }
        }

        if (!updated) {
            System.out.println("Book with given ISBN not found.");
        }
    }
}
