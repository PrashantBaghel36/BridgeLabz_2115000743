import java.util.*;
public class StudentGradeCalculator2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int number = sc.nextInt();
        double[][] studentData = new double[number][5];
        String[] gradeLetters = new String[number];
        for (int i = 0; i < number; i++) {
            System.out.println("Enter marks for student " + (i + 1) + ":");
            for (int j = 0; j < 3; j++) {
                String subject = j == 0 ? "Physics" : j == 1 ? "Chemistry" : "Maths";
                do {
                    System.out.print(subject + " marks: ");
                    studentData[i][j] = sc.nextDouble();
                    if (studentData[i][j] < 0) {
                        System.out.println("Marks cannot be negative. Enter positive value.");
                    }
                } while (studentData[i][j] < 0);
            }
            studentData[i][3] = (studentData[i][0] + studentData[i][1] + studentData[i][2]) / 3.0;
            if (studentData[i][3] >= 80) {
                gradeLetters[i] = "A";
            } else if (studentData[i][3] >= 70) {
                gradeLetters[i] = "B";
            } else if (studentData[i][3] >= 60) {
                gradeLetters[i] = "C";
            } else if (studentData[i][3] >= 50) {
                gradeLetters[i] = "D";
            } else if (studentData[i][3] >= 40) {
                gradeLetters[i] = "E";
            } else {
                gradeLetters[i] = "R";
            }
        }
        System.out.println("\nStudent Results:");
        System.out.printf("%-10s %-10s %-10s %-12s %-10s\n", 
                          "Physics", "Chemistry", "Maths", "Percentage", "Grade");
        for (int i = 0; i < number; i++) {
            System.out.printf("%-10.1f %-10.1f %-10.1f %-12.2f %-10s\n", 
                    studentData[i][0], studentData[i][1], studentData[i][2], studentData[i][3], gradeLetters[i]);
        }
    }
}