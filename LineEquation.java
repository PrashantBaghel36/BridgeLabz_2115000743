import java.util.*;
public class LineEquation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter x1: ");
        double x1 = sc.nextDouble();
        System.out.print("Enter y1: ");
        double y1 = sc.nextDouble();
        System.out.print("Enter x2: ");
        double x2 = sc.nextDouble();
        System.out.print("Enter y2: ");
        double y2 = sc.nextDouble();
        double distance = calculateDistance(x1, y1, x2, y2);
        System.out.println("Euclidean Distance: " + distance);
        double[] line = calculateLineEquation(x1, y1, x2, y2);
        System.out.println("Equation of the line: y = " + line[0] + "x + " + line[1]);
    }
    public static double calculateDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
    public static double[] calculateLineEquation(double x1, double y1, double x2, double y2) {
        double[] result = new double[2];
        if (x1 == x2) {
            result[0] = Double.POSITIVE_INFINITY;
            result[1] = Double.NaN; 
        } else {
            result[0] = (y2 - y1) / (x2 - x1);
            result[1] = y1 - result[0] * x1;     
        }
        return result;
    }
}
