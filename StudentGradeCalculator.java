import java.util.*;
public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int number = sc.nextInt();
        int[][] marks = new int[number][3];
        double[] percentages = new double[number];
        char[] grades = new char[number];
        for (int i = 0; i < number; i++) {
            System.out.println("Enter marks for student " + (i + 1) + ":");
            for (int j = 0; j < 3; j++) {
                String subject = j == 0 ? "Physics" : j == 1 ? "Chemistry" : "Maths";
                do {
                    System.out.print(subject + " marks: ");
                    marks[i][j] = sc.nextInt();
                    if (marks[i][j] < 0) {
                        System.out.println("Marks cannot be negative. Enter positive value.");
                    }
                } while (marks[i][j] < 0);
            }
            int totalMarks = marks[i][0] + marks[i][1] + marks[i][2];
            percentages[i] = (totalMarks / 3.0);
            if (percentages[i] >= 80) {
                grades[i] = 'A';
            } else if (percentages[i] >= 70) {
                grades[i] = 'B';
            } else if (percentages[i] >= 60) {
                grades[i] = 'C';
            } else if (percentages[i] >= 50) {
                grades[i] = 'D';
            } else if (percentages[i] >= 40) {
                grades[i] = 'E';
            } else {
                grades[i] = 'R';
            }
        }
        System.out.println("\nStudent Results:");
        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s\n", 
                          "Physics", "Chemistry", "Maths", "Percentage", "Grade");
        for (int i = 0; i < number; i++) {
            System.out.printf("%-10d %-10d %-10d %-10.2f %-10c\n", 
                    marks[i][0], marks[i][1], marks[i][2], percentages[i], grades[i]);
        }
    }
}