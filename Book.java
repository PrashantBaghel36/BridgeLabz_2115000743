import java.util.*;
class Book {
    private static String libraryName = "My Library";
    private final String isbn;
    private String title;
    private String author;
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }
    public void displayBookInfo() {
        if (this instanceof Book) {
            System.out.println("Library Name: " + libraryName);
            System.out.println("Title: " + this.title);
            System.out.println("Author: " + this.author);
            System.out.println("ISBN: " + this.isbn);
        }
    }
    public static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();
        System.out.print("Enter book ISBN: ");
        String isbn = scanner.nextLine();
        Book book = new Book(title, author, isbn);
        int choice;
        do {
            System.out.println("\nChoose an action:");
            System.out.println("1. Display book info");
            System.out.println("2. Display Library Name");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1:
                    book.displayBookInfo();
                    break;
                case 2:
                    Book.displayLibraryName();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 3);
    }
}
