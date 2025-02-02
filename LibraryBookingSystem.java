// Library Book System: Create a Book class with attributes title, author, price, and availability. 
// Implement a method to borrow a book.

class Book{
    String title;
    String author;
    int price;
    String availability;
    Book(String title, String author, String availability, int price){
        this.title = title;
        this.author = author;
        this.availability = availability;
        this.price = price;
    }
    public void borrowBook(){
        System.out.println("The book's title is: "+title);
        System.out.println("The author name is: "+author);
        System.out.println("The price of the book is: "+price);
        System.out.println("Availability: "+availability);
    }
}
public class LibraryBookingSystem {
    public static void main(String[] args) {
        Book book1 = new Book("Vistas", "Charagh Sharma", "Yes", 2400);
        Book book2 = new Book("Ranta", "Nopita", "NO", 1900);
        Book book3 = new Book("Rich Dad Poor Dad", "Robert Kiyosaki", "Yes", 3900);
        System.out.println("-------Book 1 details------");
        book1.borrowBook();
        System.out.println("\n\n-------Book 2 details------");
        book2.borrowBook();
        System.out.println("\n\n-------Book 3 details------");
        book3.borrowBook();
    }
}
