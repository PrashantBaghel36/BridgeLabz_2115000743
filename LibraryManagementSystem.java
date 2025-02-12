import java.util.*;

class Book {
    String title;
    String author;
    String genre;
    int bookId;
    boolean available;
    Book next;
    Book prev;

    Book(String title, String author, String genre, int bookId) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.available = true;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Genre: " + genre + ", ID: " + bookId + ", Available: " + available;
    }
}

public class LibraryManagementSystem {
    Book head;
    Book tail;
    Scanner scanner = new Scanner(System.in);

    // Add book at the beginning of the list
    public void addBookBeginning(String title, String author, String genre, int bookId) {
        Book newBook = new Book(title, author, genre, bookId);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
    }

    // Add book at the end of the list
    public void addBookEnd(String title, String author, String genre, int bookId) {
        Book newBook = new Book(title, author, genre, bookId);
        if (tail == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
    }

    // Add book at a specific position in the list
    public void addBookAtPosition(String title, String author, String genre, int bookId, int pos) {
        Book newBook = new Book(title, author, genre, bookId);
        if (pos == 0) {
            addBookBeginning(title, author, genre, bookId);
            return;
        }

        Book current = head;
        int index = 0;
        while (current != null && index < pos - 1) {
            current = current.next;
            index++;
        }

        if (current == null) {
            System.out.println("Position out of range. Adding at the end.");
            addBookEnd(title, author, genre, bookId);
        } else {
            newBook.next = current.next;
            if (current.next != null) {
                current.next.prev = newBook;
            }
            current.next = newBook;
            newBook.prev = current;
        }
    }

    // Remove book by ID
    public void removeBook(int bookId) {
        Book current = head;
        while (current != null && current.bookId != bookId) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Book not found.");
            return;
        }

        if (current == head) {
            head = current.next;
        } else {
            current.prev.next = current.next;
        }

        if (current == tail) {
            tail = current.prev;
        } else {
            current.next.prev = current.prev;
        }
    }

    // Search book by title
    public Book searchBookByTitle(String title) {
        Book current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Search book by author
    public Book searchBookByAuthor(String author) {
        Book current = head;
        while (current != null) {
            if (current.author.equalsIgnoreCase(author)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Update book availability
    public void updateAvailability(int bookId, boolean available) {
        Book current = head;
        while (current != null) {
            if (current.bookId == bookId) {
                current.available = available;
                return;
            }
            current = current.next;
        }
        System.out.println("Book not found.");
    }

    // Display all books (forward)
    public void displayForward() {
        Book current = head;
        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
    }

    // Display all books (reverse)
    public void displayReverse() {
        Book current = tail;
        while (current != null) {
            System.out.println(current);
            current = current.prev;
        }
    }

    // Count total number of books
    public int countBooks() {
        int count = 0;
        Book current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nLibrary Management System Menu");
            System.out.println("1. Add book at beginning");
            System.out.println("2. Add book at end");
            System.out.println("3. Add book at position");
            System.out.println("4. Remove book");
            System.out.println("5. Search book by title");
            System.out.println("6. Search book by author");
            System.out.println("7. Update availability");
            System.out.println("8. Display all books (forward)");
            System.out.println("9. Display all books (reverse)");
            System.out.println("10. Count books");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title1 = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author1 = scanner.nextLine();
                    System.out.print("Enter genre: ");
                    String genre1 = scanner.nextLine();
                    System.out.print("Enter book ID: ");
                    int id1 = scanner.nextInt();
                    library.addBookBeginning(title1, author1, genre1, id1);
                    break;
                case 2:
                    System.out.print("Enter title: ");
                    String title2 = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author2 = scanner.nextLine();
                    System.out.print("Enter genre: ");
                    String genre2 = scanner.nextLine();
                    System.out.print("Enter book ID: ");
                    int id2 = scanner.nextInt();
                    library.addBookEnd(title2, author2, genre2, id2);
                    break;
                case 3:
                    System.out.print("Enter title: ");
                    String title3 = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author3 = scanner.nextLine();
                    System.out.print("Enter genre: ");
                    String genre3 = scanner.nextLine();
                    System.out.print("Enter book ID: ");
                    int id3 = scanner.nextInt();
                    System.out.print("Enter position: ");
                    int pos = scanner.nextInt();
                    library.addBookAtPosition(title3, author3, genre3, id3, pos);
                    break;
                case 4:
                    System.out.print("Enter book ID to remove: ");
                    int idToRemove = scanner.nextInt();
                    library.removeBook(idToRemove);
                    break;
                case 5:
                    System.out.print("Enter title to search: ");
                    String titleToSearch = scanner.nextLine();
                    Book bookByTitle = library.searchBookByTitle(titleToSearch);
                    if (bookByTitle != null) {
                        System.out.println("Found: " + bookByTitle);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 6:
                    System.out.print("Enter author to search: ");
                    String authorToSearch = scanner.nextLine();
                    Book bookByAuthor = library.searchBookByAuthor(authorToSearch);
                    if (bookByAuthor != null) {
                        System.out.println("Found: " + bookByAuthor);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 7:
                    System.out.print("Enter book ID to update availability: ");
                    int idToUpdate = scanner.nextInt();
                    System.out.print("Enter availability (true/false): ");
                    boolean available = scanner.nextBoolean();
                    library.updateAvailability(idToUpdate, available);
                    break;
                case 8:
                    library.displayForward();
                    break;
                case 9:
                    library.displayReverse();
                    break;
                case 10:
                    System.out.println("Total Books: " + library.countBooks());
                    break;
                case 11:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 11);
    }
}

