import java.util.*;
class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;
    Ticket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
    }
    @Override
    public String toString() {
        return "ID: " + ticketId + ", Customer: " + customerName + ", Movie: " + movieName + 
                ", Seat: " + seatNumber + ", Time: " + bookingTime;
    }
}
public class TicketReservationSystem {
    Ticket head;
    Scanner scanner = new Scanner(System.in);
    public void addTicket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketId, customerName, movieName, seatNumber, bookingTime);
        if (head == null) {
            head = newTicket;
            newTicket.next = head;
        } else {
            Ticket tail = head;
            while (tail.next != head) {
                tail = tail.next;
            }
            tail.next = newTicket;
            newTicket.next = head;
        }
    }
    public void removeTicket(int ticketId) {
        if (head == null) return;
        if (head.ticketId == ticketId) {
            if (head.next == head) {
                head = null;
            } else {
                Ticket tail = head;
                while (tail.next != head) {
                    tail = tail.next;
                }
                tail.next = head.next;
                head = head.next;
            }
            return;
        }
        Ticket current = head;
        while (current.next != head && current.next.ticketId != ticketId) {
            current = current.next;
        }
        if (current.next == head) return;
        current.next = current.next.next;
    }

    public void displayTickets() {
        if (head == null) return;
        Ticket current = head;
        do {
            System.out.println(current);
            current = current.next;
        } while (current != head);
    }

    public void searchTicketByCustomer(String customerName) {
        if (head == null) return;
        Ticket current = head;
        do {
            if (current.customerName.equals(customerName)) {
                System.out.println(current);
            }
            current = current.next;
        } while (current != head);
    }

    public void searchTicketByMovie(String movieName) {
        if (head == null) return;
        Ticket current = head;
        do {
            if (current.movieName.equals(movieName)) {
                System.out.println(current);
            }
            current = current.next;
        } while (current != head);
    }

    public int countBookedTickets() {
        if (head == null) return 0;
        int count = 0;
        Ticket current = head;
        do {
            count++;
            current = current.next;
        } while (current != head);
        return count;
    }

    public void userMenu() {
        while (true) {
            System.out.println("\n1. Add Ticket");
            System.out.println("2. Remove Ticket");
            System.out.println("3. Display Tickets");
            System.out.println("4. Search Ticket by Customer");
            System.out.println("5. Search Ticket by Movie");
            System.out.println("6. Count Booked Tickets");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter ticket ID: ");
                    int ticketId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter customer name: ");
                    String customerName = scanner.nextLine();
                    System.out.print("Enter movie name: ");
                    String movieName = scanner.nextLine();
                    System.out.print("Enter seat number: ");
                    String seatNumber = scanner.nextLine();
                    System.out.print("Enter booking time: ");
                    String bookingTime = scanner.nextLine();
                    addTicket(ticketId, customerName, movieName, seatNumber, bookingTime);
                    break;
                case 2:
                    System.out.print("Enter ticket ID to remove: ");
                    ticketId = scanner.nextInt();
                    removeTicket(ticketId);
                    break;
                case 3:
                    displayTickets();
                    break;
                case 4:
                    System.out.print("Enter customer name to search: ");
                    customerName = scanner.nextLine();
                    searchTicketByCustomer(customerName);
                    break;
                case 5:
                    System.out.print("Enter movie name to search: ");
                    movieName = scanner.nextLine();
                    searchTicketByMovie(movieName);
                    break;
                case 6:
                    System.out.println("Total Booked Tickets: " + countBookedTickets());
                    break;
                case 7:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }

    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();
        system.userMenu();
    }
}
