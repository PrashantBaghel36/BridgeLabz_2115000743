import java.util.*;
public class StudentScores {
    public static void main(String[] args) {
        int numStudents = 5; // Example: 5 students

        int[][] studentScores = generateRandomScores(numStudents);
        displayScorecard(studentScores);
    }
    public static int[][] generateRandomScores(int numStudents) {
        Random rand = new Random();
        int[][] scores = new int[numStudents][4]; 
        for (int i = 0; i < numStudents; i++) {
            scores[i][0] = rand.nextInt(90) + 10;
            scores[i][1] = rand.nextInt(90) + 10;
            scores[i][2] = rand.nextInt(90) + 10;
            scores[i][3] = scores[i][0] + scores[i][1] + scores[i][2];
        }
        return scores;
    }
    public static void displayScorecard(int[][] scores) {
        System.out.println("Student\tPhysics\tChemistry\tMath\tTotal\tAverage\tPercentage\tGrade\tRemarks");
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("Student %d\t%d\t\t%d\t\t%d\t\t%d\t\t%.2f\t\t%.2f\t\t%s\t\t%s\n",
                    i + 1, scores[i][0], scores[i][1], scores[i][2], scores[i][3],
                    (double) scores[i][3] / 3, (double) scores[i][3] / 300 * 100,
                    getGrade((double) scores[i][3] / 300 * 100),
                    getRemarks((double) scores[i][3] / 300 * 100));
        }
    }
    public static String getGrade(double percentage) {
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
    public static String getRemarks(double percentage) {
        if (percentage >= 80) {
            return "(Level 4, above agency-normalized standards)";
        } else if (percentage >= 70) {
            return "(Level 3, at agency-normalized standards)";
        } else if (percentage >= 60) {
            return "(Level 2, below, but approaching agency-normalized standards)";
        } else if (percentage >= 50) {
            return "(Level 1, well below agency-normalized standards)";
        } else if (percentage >= 40) {
            return "(Level 1-, too below agency-normalized standards)";
        } else {
            return "(Remedial standards)";
        }
    }
}
