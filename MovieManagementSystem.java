import java.util.*;
class Movie {
    String title;
    String director;
    int year;
    double rating;
    Movie next;
    Movie prev;

    Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Director: " + director + ", Year: " + year + ", Rating: " + rating;
    }
}

public class MovieManagementSystem {
    Movie head;
    Movie tail;
    Scanner scanner = new Scanner(System.in);


    public void addMovieBeginning(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    public void addMovieEnd(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }


    public void addMovieAtPosition(String title, String director, int year, double rating, int position) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (position <= 0) {
            addMovieBeginning(title, director, year, rating);
            return;
        }
        if (head == null) {
            return;
        }

        Movie current = head;
        int count = 0;
        while (current != null && count < position - 1) {
            current = current.next;
            count++;
        }
        if (current == null) {
            addMovieEnd(title, director, year, rating);
            return;
        }
        newMovie.next = current.next;
        newMovie.prev = current;
        current.next = newMovie;
        if (newMovie.next != null) {
            newMovie.next.prev = newMovie;
        } else {
            tail = newMovie;
        }

    }

    public void removeMovie(String title) {
        if (head == null) return;

        if (head.title.equals(title)) {
            head = head.next;
            if (head != null) head.prev = null;
            else tail = null;
            return;
        }

        Movie current = head;
        while (current != null && !current.title.equals(title)) {
            current = current.next;
        }

        if (current == null) return;

        if (current == tail) {
            tail = current.prev;
            tail.next = null;
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
    }

    public void searchByDirector(String director) {
        Movie current = head;
        while (current != null) {
            if (current.director.equals(director)) {
                System.out.println(current);
            }
            current = current.next;
        }
    }

    public void searchByRating(double rating) {
        Movie current = head;
        while (current != null) {
            if (current.rating == rating) {
                System.out.println(current);
            }
            current = current.next;
        }
    }

    public void displayForward() {
        Movie current = head;
        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
    }

    public void displayReverse() {
        Movie current = tail;
        while (current != null) {
            System.out.println(current);
            current = current.prev;
        }
    }

    public void updateRating(String title, double rating) {
        Movie current = head;
        while (current != null) {
            if (current.title.equals(title)) {
                current.rating = rating;
                return;
            }
            current = current.next;
        }
    }


    public static void main(String[] args) {
        MovieManagementSystem system = new MovieManagementSystem();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMovie Management System");
            System.out.println("1. Add movie at beginning");
            System.out.println("2. Add movie at end");
            System.out.println("3. Add movie at position");
            System.out.println("4. Remove movie");
            System.out.println("5. Search by director");
            System.out.println("6. Search by rating");
            System.out.println("7. Display forward");
            System.out.println("8. Display reverse");
            System.out.println("9. Update rating");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title1 = scanner.nextLine();
                    System.out.print("Enter director: ");
                    String director1 = scanner.nextLine();
                    System.out.print("Enter year: ");
                    int year1 = scanner.nextInt();
                    System.out.print("Enter rating: ");
                    double rating1 = scanner.nextDouble();
                    system.addMovieBeginning(title1, director1, year1, rating1);
                    break;
                case 2:
                    System.out.print("Enter title: ");
                    String title2 = scanner.nextLine();
                    System.out.print("Enter director: ");
                    String director2 = scanner.nextLine();
                    System.out.print("Enter year: ");
                    int year2 = scanner.nextInt();
                    System.out.print("Enter rating: ");
                    double rating2 = scanner.nextDouble();
                    system.addMovieEnd(title2, director2, year2, rating2);
                    break;
                case 3:
                    System.out.print("Enter title: ");
                    String title3 = scanner.nextLine();
                    System.out.print("Enter director: ");
                    String director3 = scanner.nextLine();
                    System.out.print("Enter year: ");
                    int year3 = scanner.nextInt();
                    System.out.print("Enter rating: ");
                    double rating3 = scanner.nextDouble();
                    System.out.print("Enter position: ");
                    int position = scanner.nextInt();
                    system.addMovieAtPosition(title3, director3, year3, rating3, position);
                    break;
                case 4:
                    System.out.print("Enter title to remove: ");
                    String titleToRemove = scanner.nextLine();
                    system.removeMovie(titleToRemove);
                    break;
                case 5:
                    System.out.print("Enter director to search: ");
                    String directorToSearch = scanner.nextLine();
                    system.searchByDirector(directorToSearch);
                    break;
                case 6:
                    System.out.print("Enter rating to search: ");
                    double ratingToSearch = scanner.nextDouble();
                    system.searchByRating(ratingToSearch);
                    break;
                case 7:
                    system.displayForward();
                    break;
                case 8:
                    system.displayReverse();
                    break;
                case 9:
                    System.out.print("Enter title to update rating: ");
                    String titleToUpdate = scanner.nextLine();
                    System.out.print("Enter new rating: ");
                    double newRating = scanner.nextDouble();
                    system.updateRating(titleToUpdate, newRating);
                    break;
                case 10:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 10);
    }
}
