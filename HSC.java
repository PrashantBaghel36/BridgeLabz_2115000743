import java.util.Scanner;

public class HSC {
    public static void main(String[] args) {
       
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numberOfStudents = scanner.nextInt();

       
        int handshakes = (numberOfStudents * (numberOfStudents - 1)) / 2;

        // Output the result
        System.out.println("The maximum number of handshakes possible among " + numberOfStudents + " students is: " + handshakes);

       
    }
}

