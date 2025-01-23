import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter marks for Physics: ");
        double physics = scanner.nextDouble();

        System.out.print("Enter marks for Chemistry: ");
        double chemistry = scanner.nextDouble();

        System.out.print("Enter marks for Maths: ");
        double maths = scanner.nextDouble();

       
        double totalMarks = physics + chemistry + maths;
        double averageMarks = totalMarks / 3;
        double percentage = (totalMarks / 300) * 100;

       
        String grade = calculateGrade(percentage);
        String remarks = getRemarks(grade);

       
        System.out.println("\n--- Result ---");
        System.out.println("Total Marks: " + totalMarks);
        System.out.printf("Average Marks: %.2f\n", averageMarks);
        System.out.printf("Percentage: %.2f%%\n", percentage);
        System.out.println("Grade: " + grade);
        System.out.println("Remarks: " + remarks);

        
    }

   
    private static String calculateGrade(double percentage) {
        if (percentage >= 80) {
            return "A";
        } else if (percentage >= 70) {
            return "B";
        } else if (percentage >= 60) {
            return "C";
        } else if (percentage >= 50) {
            return "D";
        } else if (percentage >= 40) {
            return "E";
        } else {
            return "R";
        }
    }

    private static String getRemarks(String grade) {
        switch (grade) {
            case "A":
                return "Level 4, above agency-normalized standards";
            case "B":
                return "Level 3, at agency-normalized standards";
            case "C":
                return "Level 2, below but approaching agency-normalized standards";
            case "D":
                return "Level 1, well below agency-normalized standards";
            case "E":
                return "Level 1-, too below agency-normalized standards";
            case "R":
                return "Remedial standards";
            default:
                return "No remarks available";
        }
    }
}


