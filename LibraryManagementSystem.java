abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;
    private LibraryItem next;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    public String getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public abstract int getLoanDuration();

    public String getItemDetails() {
        return "ID: " + itemId + ", Title: " + title + ", Author: " + author;
    }

    public LibraryItem getNext() {
        return next;
    }

    public void setNext(LibraryItem next) {
        this.next = next;
    }
}

interface Reservable {
    boolean reserveItem();

    boolean checkAvailability();
}

class Book extends LibraryItem implements Reservable {
    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 14;
    }

    @Override
    public boolean reserveItem() {
        return true;
    }

    @Override
    public boolean checkAvailability() {
        return true;
    }
}

class Magazine extends LibraryItem {
    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 7;
    }
}

class DVD extends LibraryItem implements Reservable {
    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 5;
    }

    @Override
    public boolean reserveItem() {
        return true;
    }

    @Override
    public boolean checkAvailability() {
        return true;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Book book = new Book("B001", "The Great Gatsby", "F. Scott Fitzgerald");
        Magazine magazine = new Magazine("M001", "National Geographic", "Various");
        DVD dvd = new DVD("D001", "Inception", "Christopher Nolan");

        book.setNext(magazine);
        magazine.setNext(dvd);

        LibraryItem current = book;
        while (current != null) {
            System.out.println(current.getItemDetails());
            System.out.println("Loan Duration: " + current.getLoanDuration() + " days");
            if (current instanceof Reservable) {
                Reservable reservableItem = (Reservable) current;
                System.out.println("Reservable: " + reservableItem.reserveItem());
                System.out.println("Availability: " + reservableItem.checkAvailability());
            }
            System.out.println("----------------------------");
            current = current.getNext();
        }
    }
}
