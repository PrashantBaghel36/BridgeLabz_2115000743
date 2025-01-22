public class Average {
    public static void main(String[] args) {
        int maths = 94;
        int physics = 95;
        int chemistry = 96;
        int totalMarks = maths + physics + chemistry;
        int maxMarksPerSubject = 100;
        int totalMaxMarks = maxMarksPerSubject * 3; 
        double averagePercentage = ((double) totalMarks / totalMaxMarks) * 100;
        System.out.println("Sam’s average mark in PCM is " + averagePercentage + "%");
    }
}
