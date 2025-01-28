package Level_2;

import java.util.*;

public class Program_05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op = sc.nextInt();
        switch (op) {
            case 1:
                double yards = sc.nextDouble();
                System.out.println("Feets: " + yardsToFeets(yards));
                break;
            case 2:
                double feets = sc.nextDouble();
                System.out.println("Yards: " + feetsToYards(feets));
                break;
            case 3:
                double meters = sc.nextDouble();
                System.out.println("Inches: " + metersToInches(meters));
                break;
            case 4:
                double inches = sc.nextDouble();
                System.out.println("Meters: " + inchesToMeters(inches));
                break;
            case 5:
                inches = sc.nextDouble();
                System.out.println("Centimeters: " + inchesToCm(inches));
                break;
        }
    }

    public static double yardsToFeets(double yards) {
        return yards * 3;
    }

    public static double feetsToYards(double feets) {
        return feets * 0.333333;
    }

    public static double metersToInches(double meters) {
        return meters * 39.3701;
    }

    public static double inchesToMeters(double inches) {
        return inches * 0.0254;
    }

    public static double inchesToCm(double inches) {
        return inches * 2.54;
    }
}
