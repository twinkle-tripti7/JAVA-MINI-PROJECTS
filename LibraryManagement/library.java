package LibraryManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class library {
    private List<Book> books;
    private Scanner scanner;

    public library() {
        books = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        library library = new library();
        library.run();
    }

    private void run() {
        boolean running = true;
        while (running) {
            printMenu();
            int choice = getChoice();
            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    viewBooks();
                    break;
                case 3:
                    updateBook();
                    break;
                case 4:
                    deleteBook();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private void printMenu() {
        System.out.println("\nLibrary Management System");
        System.out.println("1. Add Book");
        System.out.println("2. View Books");
        System.out.println("3. Update Book");
        System.out.println("4. Delete Book");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private int getChoice() {
        int choice = -1;
        try {
            choice = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // Clear the invalid input
        }
        return choice;
    }

    private void addBook() {
        System.out.print("Enter book title: ");
        String title = scanner.next();
        System.out.print("Enter book author: ");
        String author = scanner.next();
        System.out.print("Enter book ISBN: ");
        String isbn = scanner.next();

        Book book = new Book(title, author, isbn);
        books.add(book);
        System.out.println("Book added successfully.");
    }

    private void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            System.out.println("List of Books:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    private void updateBook() {
        System.out.print("Enter the ISBN of the book to update: ");
        String isbn = scanner.next();

        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                System.out.print("Enter new title: ");
                String newTitle = scanner.next();
                System.out.print("Enter new author: ");
                String newAuthor = scanner.next();

                // Create a new book instance
                books.remove(book);
                books.add(new Book(newTitle, newAuthor, isbn));
                System.out.println("Book updated successfully.");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    private void deleteBook() {
        System.out.print("Enter the ISBN of the book to delete: ");
        String isbn = scanner.next();

        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                books.remove(book);
                System.out.println("Book deleted successfully.");
                return;
            }
        }
        System.out.println("Book not found.");
    }
}
