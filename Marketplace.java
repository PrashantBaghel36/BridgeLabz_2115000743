abstract class Product<T> {
    String name;
    double price;
    T category;
    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
    public void applyDiscount(double percentage) {
        price -= price * (percentage / 100);
    }
    public void displayDetails() {
        System.out.println(name + " - " + category + " - Price: " + price);
    }
}
class BookCategory {
   String genre;
    public BookCategory(String genre) {
        this.genre = genre;
    }
    @Override
    public String toString() {
        return "Book Genre: " + genre;
    }
}
class ClothingCategory {
    String size;
    public ClothingCategory(String size) {
        this.size = size;
    }
    @Override
    public String toString() {
        return "Clothing Size: " + size;
    }
}
class GadgetCategory {
    String brand;
    public GadgetCategory(String brand) {
        this.brand = brand;
    }
    @Override
    public String toString() {
        return "Gadget Brand: " + brand;
    }
}
class Book extends Product<BookCategory> {
    public Book(String name, double price, BookCategory category) {
        super(name, price, category);
    }
}
class Clothing extends Product<ClothingCategory> {
    public Clothing(String name, double price, ClothingCategory category) {
        super(name, price, category);
    }
}
class Gadget extends Product<GadgetCategory> {
    public Gadget(String name, double price, GadgetCategory category) {
        super(name, price, category);
    }
}
class Marketplace {
    public static <T extends Product> void applyDiscount(T product, double percentage) {
        product.applyDiscount(percentage);
    }
    public static void main(String[] args) {
        BookCategory bookCategory = new BookCategory("Soft Romance");
        ClothingCategory clothingCategory = new ClothingCategory("Large");
        GadgetCategory gadgetCategory = new GadgetCategory("Apple");
        Book book = new Book("The in Between", 20.00, bookCategory);
        Clothing clothing = new Clothing("T-shirt", 15.00, clothingCategory);
        Gadget gadget = new Gadget("iPhone", 999.99, gadgetCategory);
        book.displayDetails();
        clothing.displayDetails();
        gadget.displayDetails();
        applyDiscount(book, 10);
        applyDiscount(clothing, 5);
        applyDiscount(gadget, 15);
        book.displayDetails();
        clothing.displayDetails();
        gadget.displayDetails();
    }
}
