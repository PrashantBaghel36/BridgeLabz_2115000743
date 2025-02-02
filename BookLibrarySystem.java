// Design a Book class with:
// ISBN (public).
// title (protected).
// author (private).
// Write methods to:
// Set and get the author name.
// Create a subclass EBook to access ISBN and title and demonstrate access modifiers.

class Book{
    public String isbn;
    protected String title;
    private String author;

    Book(String isbn, String title, String author){
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }
    // Getter for author
    public String getAuthor(){
        return author;
    }
    // Setter for author
    public void setAuthor(String author){
        this.author = author;
    }

    public void displayBookDetails(){
        System.out.println("EBook ISBN: "+isbn);
        System.out.println("TItle: "+title);
        System.out.println("Auhtor: "+author);
    }
}
class EBook extends Book{
    public EBook(String isbn, String title, String author){
        super(isbn, title, author);
    }
    public void displayEBookDetails(){
        System.out.println("EBook ISBN: "+isbn);
        System.out.println("TItle: "+title);
    }
}
public class BookLibrarySystem{
    public static void main(String[] args) {
        Book book = new Book("123-456-789", "Java Programming", "John Doe");
        System.out.println("------Book details------");
        book.displayBookDetails();
        System.out.println("Author name: "+book.getAuthor());
        book.setAuthor("Prabhat");
        System.out.println("Author Changed to: "+book.getAuthor());
        EBook ebook = new EBook("987-654-321", "Advanced Java", "Alice Smith");
        System.out.println("--------EBook Details---------");
        ebook.displayEBookDetails();
    }
}