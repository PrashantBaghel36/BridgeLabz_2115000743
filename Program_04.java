package Level_2;

import java.util.*;

public class Program_04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op = sc.nextInt();
        switch (op) {
            case 1:
                double km = sc.nextDouble();
                System.out.println("Miles: " + KmToMiles(km));
                break;
            case 2:
                double miles = sc.nextDouble();
                System.out.println("Kilometers: " + MilesToKm(miles));
                break;
            case 3:
                double meters = sc.nextDouble();
                System.out.println("Feet: " + MetersToFeet(meters));
                break;
            case 4:
                double feet = sc.nextDouble();
                System.out.println("Meters: " + FeetToMeters(feet));
                break;
        }
    }

    public static double KmToMiles(double km) {
        return km * 0.621371;
    }

    public static double MilesToKm(double miles) {
        return miles * 1.60934;
    }

    public static double MetersToFeet(double meters) {
        return meters * 3.28084;
    }

    public static double FeetToMeters(double feet) {
        return feet * 0.3048;
    }
}
