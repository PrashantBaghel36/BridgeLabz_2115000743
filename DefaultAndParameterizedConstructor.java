// Create a Book class with attributes title, author, and price. Provide both default and 
// parameterized constructors.
class Book{
    String title;
    String author;
    int price;
    Book(){
        this.title = "Unknown Title";
        this.author = "Unknown Author";
        this.price = 0;

    }
    public Book(String title, String author, int price){
        this.price = price;
        this.author = author;
        this.title = title;
    }
    public void displayDetails(){
        System.out.println("The title is "+title);
        System.out.println("The author is "+author);
        System.out.println("The price is "+price);
    }

}
public class DefaultAndParameterizedConstructor{
    public static void main(String[] args) {
        Book defualtBook = new Book();
        System.out.println("The details from Default constructor");
        defualtBook.displayDetails();

        System.out.println("-----------------------");
        Book paraBook = new Book("Flamingo", "John Elia", 2500);
        System.out.println("The details from parameterized constructor");
        paraBook.displayDetails();
        
        
    }
    
}
